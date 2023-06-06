package apiTest;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class AboutPet {
	
	@Test
	public void test1() {
		HashMap<Object, Object> petPayload = new HashMap<Object, Object>();
		petPayload.put("petId", "10");
		petPayload.put("type", "puppy");
		petPayload.put("file", "./rest.jpg");
		
		Response res = given().contentType("application/json").body(petPayload).when()
				.post("https://petstore.swagger.io/v2/pet/10/uploadImage").then().statusCode(200).log().body().extract()
				.response();
		
		String data=res.asString();
		Assert.assertEquals(data.contains("puppy"), true);
	}

}
