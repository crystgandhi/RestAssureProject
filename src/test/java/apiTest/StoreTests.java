package apiTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import apiEndpoints.StoreEndpoints;
import apiPayload.PetOrder;
import io.restassured.response.Response;

public class StoreTests {
	
	PetOrder petorder;
	Faker faker;
	
	@BeforeClass
	public void setUp() {
		petorder=new PetOrder();
		faker=new Faker();
		petorder.setId(faker.idNumber().hashCode());
		petorder.setPetId(faker.number().randomDigit());
		petorder.setQuantity(faker.number().numberBetween(0, 20));
		petorder.setShipDate(faker.date().toString());
		petorder.setStatus(faker.bothify("placed"));
		petorder.setComplete(true);
		
	}
	@Test
	public void createOrder() {
		Response response=StoreEndpoints.placeOrderForPet(petorder);
		response.then().log().all();
		//Assert.assertEquals(response.getStatusCode(),200);
		System.out.println(response.time());
		System.out.println(response.getContentType());
		
	}

}
