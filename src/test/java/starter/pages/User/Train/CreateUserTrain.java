package starter.pages.User.Train;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONArray;
import org.json.JSONObject;
import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class CreateUserTrain {
    protected static String email="n@gmail.com";
    protected static String password="qweqwe123";
    public String token ="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJleHAiOjE2ODczNjEwMDMsInJvbGUiOiJ1c2VyIiwidXNlcklkIjo4Nn0.mXE6I0aCqmQ0T6uml6m3vBynYoW7sJUXwYHT0GRHjyU";
    public String endpointLogin = "https://api.tripease.my.id/api/v1/login";

    //step login
    @Step("Enter Endpoint Login Valid Endpoint Order tiket KA")
    public String setEndpointLogin() {
        return endpointLogin;
    }

    @Step("Enter Request Login Valid Endpoint Order tiket KA")
    public void sendRequestLogin() {

        String body = "{\n" +
                "    \"email\":" + email + ",\n" +
                "    \"password\":" + password + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Authorization", "Bearer " + token).contentType("application/json").body(reqBody.toString()).post(setEndpointLogin());
        token = lastResponse().getBody().jsonPath().get("data.token");
    }

    public String endpointOrderTiketKA = "https://api.tripease.my.id/api/v1/user/train/order";

    @Step("Enter Endpoint Order tiket KA Valid Endpoint")
    public String setValidEndpointOrderTiketKA() {
        return endpointOrderTiketKA;
    }

    @Step("Enter Request Order tiket KA Valid Endpoint")
    public void sendRequestCreateOrderTiketKA() {
        JSONObject requestBody = new JSONObject();
            requestBody.put("email_order", "me@hanifz.com");
            requestBody.put("name_order", "Mochammad Hanif");
            requestBody.put("payment_id", 1);
            requestBody.put("phone_number_order", "085115151515");
            requestBody.put("quantity_adult", 1);
            requestBody.put("quantity_infant", 1);
            requestBody.put("with_return", true);

        JSONArray ticketTravelerDetailDeparture = new JSONArray();
        JSONObject ticketDetailDeparture = new JSONObject();
            ticketDetailDeparture.put("date", "2023-05-31");
            ticketDetailDeparture.put("station_destination_id", 2);
            ticketDetailDeparture.put("station_origin_id", 1);
            ticketDetailDeparture.put("train_carriage_id", 1);
            ticketDetailDeparture.put("train_seat_id", 2);
            ticketTravelerDetailDeparture.put(ticketDetailDeparture);

        requestBody.put("ticket_traveler_detail_departure", ticketTravelerDetailDeparture);
        requestBody.put("ticket_traveler_detail_return", ticketTravelerDetailDeparture);

        JSONArray travelerDetail = new JSONArray();
        JSONObject traveler = new JSONObject();
        traveler.put("full_name", "Mochammad Hanif");
        traveler.put("id_card_number", "1902389012801211");
        traveler.put("title", "Saudara");
        travelerDetail.put(traveler);

        requestBody.put("traveler_detail", travelerDetail);
        String body = requestBody.toString();

//        JSONObject TiketKAObject = new JSONObject();
//            TiketKAObject.put("email_order", "me@hanifz.com");
//            TiketKAObject.put("name_order", "hanif");
//            TiketKAObject.put("payment_id", 1);
//            TiketKAObject.put("phone_number_order", "085115151515");
//            TiketKAObject.put("quantity_adult", 1);
//            TiketKAObject.put("quantity_infant", 1);
//
////        array ticket_traveler_detail_departure"
//        JSONArray ticketArray = new JSONArray();
//        JSONObject ticketObject = new JSONObject();
//            ticketObject.put("date", "2023-05-31");
//            ticketObject.put("station_destination_id", 2);
//            ticketObject.put("station_origin_id", 1);
//            ticketObject.put("train_carriage_id", 1);
//            ticketObject.put("train_seat_id", 2);
//            ticketArray.put(ticketObject);
//
////        array ticket_traveler_detail_return
//        JSONArray ticketDetailArray = new JSONArray();
//        JSONObject ticketDetailObject = new JSONObject();
//            ticketDetailObject.put("date", "2023-05-31");
//            ticketDetailObject.put("station_destination_id", 2);
//            ticketDetailObject.put("station_origin_id", 1);
//            ticketDetailObject.put("train_carriage_id", 1);
//            ticketDetailObject.put("train_seat_id", 2);
//            ticketDetailArray.put(ticketDetailObject);
//
////        array traveler_detail
//        JSONArray travelerDetailArray = new JSONArray();
//        JSONObject traveler_detail = new JSONObject();
//            traveler_detail.put("full_name", "nuk");
//            traveler_detail.put("id_card_number", "1902389012801211");
//            traveler_detail.put("title", "saudara");
//            travelerDetailArray.put(traveler_detail);
//
//        TiketKAObject.put("ticketObject", ticketArray);
//        TiketKAObject.put("ticketDetailObject", ticketDetailArray);
//        TiketKAObject.put("travelerDetailObject", travelerDetailArray);
//        TiketKAObject.put("with_return", "true");
//        JSONArray jsonArray = new JSONArray();
//
//        jsonArray.put(TiketKAObject);
//
//        JSONObject requestBody = new JSONObject();
//        requestBody.put("data", jsonArray);
//
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .body(requestBody.toString())
                .post(setValidEndpointOrderTiketKA());
    }


    @Step("system responds with the status code 201 OK")
    public void SuccesCreateOrderTiketKA() {
        restAssuredThat(response -> response.statusCode(201));
    }

}
