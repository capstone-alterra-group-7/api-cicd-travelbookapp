package starter.stepdef.User.Train;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.User.Train.CreateUserTrain;

public class CreateUserTrainSteps {
    @Steps
    CreateUserTrain createUsertrain;

    @Given("Enter Endpoint Login Valid Endpoint Order ticket KA")
    public void endpointLoginCreateOrderTiketKA(){
        createUsertrain.setEndpointLogin();
    }

    @When("Enter Request Login Valid Endpoint Order ticket KA")
    public void reqLoginCreateOrderTiketKA(){
        createUsertrain.sendRequestLogin();
    }
    @When("user on the create new Order ticket KA endpoint")
    public void setValidEndpointCreateOrderTiketKA() {
        createUsertrain.setValidEndpointOrderTiketKA();
    }

    @When("user create request with POST method on Order ticket KA endpoint")
    public void createReqOrderTiketKA() {
        createUsertrain.sendRequestCreateOrderTiketKA();
    }
    @Then("system responds with the status code 201 OK")
    public void theSystemRespondsWithTheStatusCodeOK() {
        createUsertrain.SuccesCreateOrderTiketKA();
    }

}

