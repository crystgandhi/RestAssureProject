package apiTest;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;

public class StoreRestAssuredProjectStandAlone {

	
	@Test(priority=1)
	public void placeOrderForPet() {
		 
		HashMap<Object, Object> storePayload = new HashMap<Object, Object>();
		storePayload.put("id", "50");
		storePayload.put("petId", "76");
		storePayload.put("quantity", "9");
		storePayload.put("shipdate", LocalDate.now().plusDays(10));
		storePayload.put("status", "placed");
		storePayload.put("complete", true);

		Response res = given().contentType("application/json").body(storePayload).when()
				.post("https://petstore.swagger.io/v2/store/order").then().statusCode(200).log().body().extract()
				.response();
		
		String data=res.asString();
		Assert.assertEquals(data.contains("placed"), true);
	}
	
	@Test(priority=2)
	public void getOrderDetails() {
		
		given()
		.when().get("https://petstore.swagger.io/v2/store/order/50")
		.then().statusCode(200).log().body();
	}
	@Test(priority=3)
	public void updateOrderDetails() {
		
		given()
		.when()
			.delete("https://petstore.swagger.io/v2/store/order/50")
			.then().statusCode(200)
			.log().body();
		}
}
