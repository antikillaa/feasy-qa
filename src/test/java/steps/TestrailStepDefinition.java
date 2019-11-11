package steps;

import com.fasterxml.jackson.databind.ObjectMapper;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import io.severex.feasy.qa.api.APIException;
import io.severex.feasy.qa.app_context.RunContext;
import io.severex.feasy.qa.service.TestrailService;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.junit.Before;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import static com.codeborne.selenide.Selenide.screenshot;

public class TestrailStepDefinition {
    private RunContext context = new RunContext();
    private TestrailService testrailService = new TestrailService();

    @Given("Create Test Suite")
    public void createSuite() throws IOException, APIException {
        if (context.get("runId", Long.class) == null) {
            ArrayList<Integer> tcs = getTestCasesIds();
            JSONObject run = testrailService.createRun(tcs);
            Long id = (Long) run.get("id");
            context.put("runId", id);
        }
    }

    private ArrayList<Integer> getTestCasesIds() throws IOException {
        String path = "src/test/resources//TCs.json";
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(path);
        var car = objectMapper.readValue(file, HashMap.class);

        return (ArrayList<Integer>) car.get("tcs_automated");
    }

    @Given("TC: {string}")
    public void tc(String arg0) {
        context.put("tcId", Integer.parseInt(arg0));
    }

    //    @AfterStep
    public void doSomethingAfterStep(Scenario scenario) throws IOException, APIException {
        if (scenario.isFailed()) {
            Integer tcId = context.get("tcId", Integer.class);
            JSONObject jsonObject = testrailService.getLastRun();
            String scenarioName = scenario.getName();
            screenshot(scenarioName);
            testrailService.addResultFail((Long) jsonObject.get("id"), tcId, scenarioName);
        }
    }

    @Before
    public void doSomethingBefore() throws IOException {
        if (new File("built").exists())
            FileUtils.deleteDirectory(new File("built"));
    }

    @After
    public void addResultToTestrail(Scenario scenario) throws IOException, APIException {
        if (scenario.isFailed()) {
            Integer tcId = context.get("tcId", Integer.class);
            JSONObject jsonObject = testrailService.getLastRun();
            String scenarioName = scenario.getName();
            screenshot(scenarioName);
            testrailService.addResultFail((Long) jsonObject.get("id"), tcId, scenarioName);
        } else {
            Integer tcId = context.get("tcId", Integer.class);
            JSONObject jsonObject = testrailService.getLastRun();
            testrailService.addResultPass((Long) jsonObject.get("id"), tcId);
        }
    }
}
