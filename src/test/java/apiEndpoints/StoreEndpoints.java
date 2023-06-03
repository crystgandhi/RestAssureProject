package apiEndpoints;

import static io.restassured.RestAssured.given;

import apiPayload.PetOrder;
import apiPayload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class StoreEndpoints {
	
	public static Response placeOrderForPet(PetOrder payload) {
		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload).when()
				.post(Routes.post_url2);
		return response;
	}

}
