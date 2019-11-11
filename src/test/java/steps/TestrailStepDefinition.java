package steps;

import com.fasterxml.jackson.databind.ObjectMapper;
import cucumber.api.Scenario;
import cucumber.api.java.AfterStep;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.severex.feasy.qa.api.APIException;
import io.severex.feasy.qa.app_context.RunContext;
import io.severex.feasy.qa.service.TestrailService;
import org.json.simple.JSONObject;

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
        String path = "/home/potato/IdeaProjects/feasy/feasy-qa/src/test/resources/TCs.json";
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(path);
        var car = objectMapper.readValue(file, HashMap.class);

        var tcs = car.get("tcs_all");
        return (ArrayList<Integer>) tcs;
    }

    @Given("TC: {string}")
    public void tc(String arg0) {
        context.put("tcId", Integer.parseInt(arg0));
    }

    @Then("Add result for TC")
    public void addResultToTestrail() throws IOException, APIException {
        Integer tcId = context.get("tcId", Integer.class);
//        Long suiteId = context.get("runId", Long.class);
        JSONObject jsonObject = testrailService.getLastRun();
        testrailService.addResultPass((Long) jsonObject.get("id"), tcId);
    }

    @AfterStep
    public void doSomethingAfterStep(Scenario scenario) throws IOException, APIException {
        if (scenario.isFailed()) {
            Integer tcId = context.get("tcId", Integer.class);
            Long suiteId = context.get("runId", Long.class);
            String scenarioName = scenario.getName();
            screenshot(scenarioName);
            testrailService.addResultFail(suiteId, tcId, scenarioName);
        }
    }
}
