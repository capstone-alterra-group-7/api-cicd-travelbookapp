package starter.pages.userTrain;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class SearchTokenAvailableintoken {
    protected static String email="n@gmail.com";
    protected static String password="qweqwe123";
    public String token ="";
    public String endpointLogin = "https://api.tripease.my.id/api/v1/login";
    public String setEndpointAuthLogin() {
        return endpointLogin;
    }
    @Step("Enter Endpoint Login Valid Endpoint STA")
    public String setEndpointLogin() {
        return endpointLogin;
    }

    @Step("Enter Request Login Valid Endpoint STA")
    public void sendRequestLogin() {

        String body = "{\n" +
                "    \"email\":" + email + ",\n" +
                "    \"password\":" + password + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Content-Type", "application/json").body(reqBody.toString()).post(setEndpointAuthLogin());
        token = lastResponse().getBody().jsonPath().get("data.token");
    }

    public String getAllSTAInvalidToken = "https://api.tripease.my.id/api/v1/user/train/search?station_origin_id=4&station_destination_id=0";
    public String getEndpointSTAinvalidToken() {
        return getAllSTAInvalidToken;
    }


    public void getAllSTADataInvalidToken() {
        SerenityRest.given().header("Authorization", "Bearer " + token).get(getEndpointSTAinvalidToken());
    }

    public void validateStatusCodeSTAInvalidToken() {
        restAssuredThat(response -> response.statusCode(401));
    }

    public void succesGetSTAInvalidToken() {
        restAssuredThat(response -> response.body("data[0].station_id", equalTo(null)));
    }
}
