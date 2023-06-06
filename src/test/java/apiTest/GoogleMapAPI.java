package apiTest;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;

public class GoogleMapAPI {

	@Test
	public void testMap() {
		HashMap<Object, Object> location = new HashMap<Object, Object>();
		location.put("lat", "38.383494");
		location.put("lng", "33.427362");
		location.put("accuracy", "50");
		location.put("name", "Frontline house");
		location.put("phone_number", "(+91) 983 893 3937");
		location.put("address", "29, side layout, cohen 09");
		location.put("website", "http://google.com");
		location.put("language", "French-IN");
		location.put("types", "shoe park, shop");
		System.out.println(location.get("name"));

		RestAssured.baseURI = "https://rahulshettyacademy.com";

		given().log().all().queryParam("key", "qaclick123").body(location).contentType("application/json").when()
				.post("/maps/api/place/add/json").then().log().all().assertThat().statusCode(200)
				.header("server",  "Apache/2.4.41 (Ubuntu)");
				
		
	}
	}
