package starter.stepdef.User.Train;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.User.Train.patchUserTrain;

public class PatchUserTrain {
    @Steps
    patchUserTrain updateOrderTKA;
    @Given("user on Endpoint Login Valid Endpoint Train Update Order ticket KA")
    public void userOnEndpointLoginValidEndpointOrderTKA() {
        updateOrderTKA.setEndpointLogin();
    }

    @When("user Request Login Valid Endpoint Train Update Order ticket KA")
    public void userRequestLoginValidEndpointOrderTKA() {
        updateOrderTKA.sendRequestLogin();
    }

    @When("user send update request with PUT method on Update Order ticket KA endpoint")
    public void userOnTheUpdateOrderTKAEndpoint() {
        updateOrderTKA.setValidEndpointupdateOrderTKA();
    }

    @When("user on the Update Order ticket KA endpoint")
    public void userUpdateRequestWithPatchMethod() {
        updateOrderTKA.sendRequestupdateOrderTKA();
    }


    @Then("system responds with the status code 201 OKK")
    public void systemRespondsWithTheStatusCode201( ) {
        updateOrderTKA.getstatuscode201();
    }

    @And("data updated")
    public void dataUpdateTKA() {
        updateOrderTKA.succesGetDataTKA();
    }

}
