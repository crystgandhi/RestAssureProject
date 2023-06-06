package apiTest;

<<<<<<< HEAD
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

=======
import org.testng.annotations.Test;
import io.restassured.RestAssured;
>>>>>>> 50a5fcc4cb69c65fbeca1813ef4e17edd14ea15b
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;

public class GoogleMapAPI {

<<<<<<< HEAD
	@Test(priority = 1)
	public void testMap() {

		// Hashmap to pass the payload
=======
	@Test
	public void testMap() {
>>>>>>> 50a5fcc4cb69c65fbeca1813ef4e17edd14ea15b
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
<<<<<<< HEAD
		// post method to create new resource(to add a place)
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response = given().log().all().queryParam("key", "qaclick123")
				.body("{\r\n" + "  \"location\": {\r\n" + "    \"lat\": -38.383494,\r\n" + "    \"lng\": 33.427362\r\n"
						+ "  },\r\n" + "  \"accuracy\": 50,\r\n" + "  \"name\": \"Frontline house\",\r\n"
						+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
						+ "  \"address\": \"29, side layout, cohen 09\",\r\n" + "  \"types\": [\r\n"
						+ "    \"shoe park\",\r\n" + "    \"shop\"\r\n" + "  ],\r\n"
						+ "  \"website\": \"http://google.com\",\r\n" + "  \"language\": \"French-IN\"\r\n" + "}\r\n"
						+ "")
				.header("Content-Type", "application/json").when().post("/maps/api/place/add/json").then().assertThat()
				.statusCode(200).header("server", "Apache/2.4.41 (Ubuntu)").extract().response().asPrettyString();
		System.out.println("Response::" + response);
		JsonPath js = new JsonPath(response);
		String placeID = js.getString("place_id");

		// to update the resource
		String updateAddress="9 Plumtree walk";
		String response2 = given().log().all().queryParam("key", "qaclick123")
				.header("Content-Type", "application/json")
				.body("{\r\n" + "\"place_id\":\"" + placeID + "\",\r\n" + "\"address\":\""+updateAddress+"\",\r\n"
						+ "\"key\":\"qaclick123\"\r\n" + "}\r\n" + "")
				.when().put("/maps/api/place/update/json").then().assertThat().statusCode(200)
				.body("msg", equalTo("Address successfully updated")).extract().response().asPrettyString();
		System.out.println("Response2  :" + response2);
        //get the updated resource(updated address details)
		String res = given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeID).when()
				.get("/maps/api/place/get/json").then().extract().response().asPrettyString();
		System.out.println(res);
		JsonPath js1 = new JsonPath(res);
		String newAddress = js1.getString("address");
		Assert.assertEquals(updateAddress, newAddress);
		
	}

}
=======

		RestAssured.baseURI = "https://rahulshettyacademy.com";

		given().log().all().queryParam("key", "qaclick123").body(location).contentType("application/json").when()
				.post("/maps/api/place/add/json").then().log().all().assertThat().statusCode(200)
				.header("server",  "Apache/2.4.41 (Ubuntu)");
				
		
	}
	}
>>>>>>> 50a5fcc4cb69c65fbeca1813ef4e17edd14ea15b
