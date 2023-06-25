package starter.pages.User.Train;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;
import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class patchUserTrain {
    public static String email="n@gmail.com";
    public static String password="qweqwe123";
    public static String token ="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJleHAiOjE2ODc1MjIzMDYsInJvbGUiOiJ1c2VyIiwidXNlcklkIjo4Nn0.gHwtNbkr8e83YJT-44GmOzriF-QXEPoxBcWmjeWhgug";
    public String endpointLogin = "https://api.tripease.my.id/api/v1/login";
    public String ValidEndpointpatchupdateOrderTKA = "https://api.tripease.my.id/api/v1/user/train/order?ticket_order_id=382&status=canceled";

    @Step("user on Endpoint Login Valid Endpoint Order TKA")
    public String setEndpointLogin() {
        return endpointLogin;
    }

    @Step("user Request Login Valid Endpoint Order TKA")
    public void sendRequestLogin() {

        String body = "{\n" +
                "    \"email\":" + email + ",\n" +
                "    \"password\":" + password + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Authorization", "Bearer " + token).contentType("application/json").body(reqBody.toString()).post(setEndpointLogin());
        token = lastResponse().getBody().jsonPath().get("data.token");
    }

    public String setParamsValidEndpointTKA(String tiketorderid, String status) {
        String endpoint = ValidEndpointpatchupdateOrderTKA;
        StringBuilder queryParams = new StringBuilder("?");

        if (tiketorderid != null) {
            queryParams.append("ticket_order_id=").append(tiketorderid).append("&");
        }
        if (status != null) {
            queryParams.append("status=").append(status).append("&");
        }
        if (queryParams.charAt(queryParams.length() - 1) == '&') {
            queryParams.deleteCharAt(queryParams.length() - 1);
        }
        return endpoint + queryParams.toString();
    }

    @Step("Enter Endpoint Order TKA Valid Endpoint")
    public String setValidEndpointupdateOrderTKA() {
        String tiketorderid = "382";
        String status = "canceled";
        return setParamsValidEndpointTKA (tiketorderid, status);
    }

    @Step("Enter Request Order TKA Valid Endpoint")
    public void sendRequestupdateOrderTKA() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .patch(setValidEndpointupdateOrderTKA());
    }

    @Step("the system responds with the status code 201 ")
    public void getstatuscode201() {
        restAssuredThat(response -> response.statusCode(201));
    }

    public void succesGetDataTKA() {
        restAssuredThat(response -> response.body("status_code", equalTo(201)));
        restAssuredThat(response -> response.body("message", equalTo("Successfully to update a ticket order")));
    }
}
