package io.severex.feasy.qa.service;

import io.severex.feasy.qa.api.APIClient;
import io.severex.feasy.qa.api.APIException;
import io.severex.feasy.qa.app_context.RunContext;
import io.severex.feasy.qa.config.TestrailConfig;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TestrailService {
    private final static String ENDPOINT = TestrailConfig.ENDPOINT;
    private final static String USERNAME = TestrailConfig.USERNAME;
    private final static String PASSWORD = TestrailConfig.PASSWORD;
    private final static int USER_ID = TestrailConfig.USER_ID;
    private final static int PROJECT_ID = TestrailConfig.PROJECT_ID;

    private APIClient apiClient;
    private RunContext context = new RunContext();

    private static APIClient createTestRailInstance() {
        APIClient client = new APIClient(ENDPOINT);
        client.setUser(USERNAME);
        client.setPassword(PASSWORD);
        return client;
    }

    public JSONObject createRun(ArrayList<Integer> tcs) throws IOException, APIException {
        SimpleDateFormat format = new SimpleDateFormat("dd MMM yyy kk mm");
        String dateString = format.format(new Date());
        String runName = "Automation " + dateString;
        APIClient apiClient = createTestRailInstance();
        Map<String, Object> data = new HashMap<>();
        data.put("name", runName);
        data.put("include_all", Boolean.FALSE);
        data.put("suite_id", 2);
        data.put("case_ids", tcs);
        JSONObject r = (JSONObject) apiClient.sendPost("add_run/" + PROJECT_ID, data);
        context.put("runObject", JSONObject.class);
        return r;
    }

    public JSONObject getLastRun() throws IOException, APIException {
        apiClient = createTestRailInstance();
        JSONArray runs = (JSONArray) apiClient.sendGet("get_runs/" + PROJECT_ID + "&created_by=" + USER_ID);

        return (JSONObject) runs.get(0);
    }

    public void addResultPass(Long runId, Integer tcId) throws IOException, APIException {
        apiClient = createTestRailInstance();
        Map<String, java.io.Serializable> data = new HashMap<>();
        data.put("status_id", 1);
        data.put("comment", "This test worked fine!");
        JSONObject r = (JSONObject) apiClient.sendPost("add_result_for_case/" + runId + "/" + tcId, data);
    }

    public void addResultFail(Long runId, Integer tcId, String scenarioName) throws IOException, APIException {
        apiClient = createTestRailInstance();

        Map<String, java.io.Serializable> data = new HashMap<>();
        data.put("status_id", 5);
        data.put("comment", "FAILED");

        JSONObject r1 = (JSONObject) apiClient.sendPost("add_result_for_case/" + runId + "/" + tcId, data);

        apiClient.sendPost("add_attachment_to_result/" + r1.get("id") + "/", "build/reports/tests/" + scenarioName + ".html");
        apiClient.sendPost("add_attachment_to_result/" + r1.get("id") + "/", "build/reports/tests/" + scenarioName + ".png");
    }
}
