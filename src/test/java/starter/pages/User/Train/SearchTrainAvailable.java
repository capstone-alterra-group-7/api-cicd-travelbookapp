package starter.pages.User.Train;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class SearchTrainAvailable {
    protected static String email="nj@gmail.com";
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

    public String getAllSTA = "https://api.tripease.my.id/api/v1/user/train/search?station_origin_id=44&station_destination_id=45";
    public String getEndpointSTA() {
        return getAllSTA;
    }


    public void getAllSTAData() {
        SerenityRest.given().header("Authorization", "Bearer " + token).get(getEndpointSTA());
    }

    public void validateStatusCodeSTA() {
        restAssuredThat(response -> response.statusCode(200));
    }

    public void succesGetSTA() {
        restAssuredThat(response -> response.body("data[0].station_id", equalTo(null)));
    }

    //invalid id
    public String getAllSTAInvalid = "https://api.tripease.my.id/api/v1/user/train/search?station_origin_id=4&station_destination_id=5";
    public String getEndpointSTAinvalid() {
        return getAllSTAInvalid;
    }


    public void getAllSTADataInvalid() {
        SerenityRest.given().header("Authorization", "Bearer " + token).get(getEndpointSTAinvalid());
    }

    public void validateStatusCodeSTAInvalid() {
        restAssuredThat(response -> response.statusCode(200));
    }

    public void succesGetSTAInvalid() {
        restAssuredThat(response -> response.body("data[0].station_id", equalTo(null)));
    }

    // invalid id 0
    public String getAllSTAInvalid0 = "https://api.tripease.my.id/api/v1/user/train/search?station_origin_id=4&station_destination_id=0";
    public String getEndpointSTAinvalid0() {
        return getAllSTAInvalid0;
    }


    public void getAllSTADataInvalid0() {
        SerenityRest.given().header("Authorization", "Bearer " + token).get(getEndpointSTAinvalid0());
    }

    public void validateStatusCodeSTAInvalid0() {
        restAssuredThat(response -> response.statusCode(400));
    }

    public void succesGetSTAInvalid0() {
        restAssuredThat(response -> response.body("data[0].station_id", equalTo(null)));
    }


}
