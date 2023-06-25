package starter.stepdef.User.Train;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.userTrain.SearchTokenAvailableintoken;
import starter.pages.User.Train.SearchTrainAvailable;

public class searchTrainAvailable {
    @Steps
    SearchTrainAvailable STA;

    @Steps
    SearchTokenAvailableintoken STAtoken;

    @Given("input Endpoint Login Valid Endpoint search Train available")
    public void loginValidEndpointSTA() {
        STA.setEndpointLogin();
    }

    @When("input  Request Login Valid Endpoint search Train available")
    public void sendrewvalidLoginSTA() {
        STA.sendRequestLogin();
    }

    @When("user on the search train available endpoint")
    public void validEndpointSTA() {
        STA.getEndpointSTA();
    }

    @When("user create request with GET method on search train available endpoint")
    public void enterValidEndpointSTA() {
        STA.getAllSTAData();
    }

    @Then("get status code {int} OKEE")
    public void getStatuscode200oke(int arg0) {
        STA.validateStatusCodeSTA();
    }

    @And("get valid data train available")
    public void succesgetDataSTA() {
        STA.succesGetSTA();
    }


    // INVALID ID
    @When("user on the search train available endpoint with invalid id")
    public void validEndpointSTAInvalid() {
        STA.getEndpointSTAinvalid();
    }

    @When("user create request with GET method on search train available endpoint with invalid id")
    public void enterValidEndpointSTAInvalid() {
        STA.getAllSTADataInvalid();
    }

    @Then("get status code {int} OK succes")
    public void getStatuscode200Invalid(int arg0) {
        STA.validateStatusCodeSTAInvalid();
    }

    @And("get data train available")
    public void succesgetDataSTAInvalid() {
        STA.succesGetSTAInvalid();
    }

    //invalid id 0
    @When("user on the search train available endpoint with id 0")
    public void validEndpointSTAInvalid0() {
        STA.getEndpointSTAinvalid0();
    }

    @When("user create request with GET method on search train available endpoint with id 0")
    public void enterValidEndpointSTAInvalid0() {
        STA.getAllSTADataInvalid0();
    }

    @Then("get status code {int} bad request")
    public void getStatuscode200Invalid0(int arg0) {
        STA.validateStatusCodeSTAInvalid0();
    }

    @And("failed to get data train available")
    public void succesgetDataSTAInvalid0() {
        STA.succesGetSTAInvalid0();
    }

    //invalid TOKEN
    @When("user on the search train available endpoint with invalid token")
    public void validEndpointSTAInvalidToken() {
        STAtoken.getEndpointSTAinvalidToken();
    }

    @When("user create request with GET method on search train available endpoint with invalid token")
    public void enterValidEndpointSTAInvalidToken() {
        STAtoken.getAllSTADataInvalidToken();
    }

    @Then("get status code {int} unautorized")
    public void getStatuscode400InvalidToken(int arg0) {
        STAtoken.validateStatusCodeSTAInvalidToken();
    }

    @And("failed to get data STA")
    public void succesgetDataSTAInvalidToken() {
        STAtoken.succesGetSTAInvalidToken();
    }

}
