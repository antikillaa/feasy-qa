package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.severex.feasy.qa.api.APIException;
import io.severex.feasy.qa.app_context.RunContext;
import io.severex.feasy.qa.service.TestrailService;
import org.json.simple.JSONObject;

import java.io.IOException;

public class TestrailStepDefinition {
    private RunContext context = new RunContext();
    private TestrailService testrailService = new TestrailService();

    @Before
    public void createSuite() throws IOException, APIException {
        if (context.get("runId", Long.class) == null) {
            JSONObject run = testrailService.createRun();
            Long id = (Long) run.get("id");
            context.put("runId", id);
        }
    }

    @Given("TC: {string}")
    public void tc(String arg0) {
        context.put("tcId", Integer.parseInt(arg0));
    }

    @Then("Add result for TC")
    public void addResultToTestrail() throws IOException, APIException {
        Integer tcId = context.get("tcId", Integer.class);
        Long suiteId = context.get("runId", Long.class);
        testrailService.addResult(suiteId, tcId);
    }
}
