package apiTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import apiEndpoints.UserEndpoints;
import apiPayload.User;
import io.restassured.response.Response;

public class UserTests {

	Faker faker;
	User userpayload;

	@BeforeClass
	public void setUp() {
		faker = new Faker();
		userpayload = new User();
		userpayload.setId(faker.idNumber().hashCode());
		userpayload.setFirstname(faker.name().firstName());
		userpayload.setLastname(faker.name().lastName());
		userpayload.setUsername(faker.name().username());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		userpayload.setPassword(faker.internet().password(5, 10));
		userpayload.setPhone(faker.phoneNumber().cellPhone());
	}

	@Test(priority = 1)
	public void testPostUser() {
		Response response = UserEndpoints.createUser(userpayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println(response.time());
		System.out.println(response.getContentType());
	}

	@Test(priority = 2)
	public void testReadUser() {
		Response response = UserEndpoints.readUser(this.userpayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(200, response.getStatusCode());
		System.out.println(response.time());
		System.out.println(response.getContentType());
	}

	@Test(priority = 3)
	public void testUpdateUser() {
		userpayload.setEmail(faker.internet().safeEmailAddress());
		userpayload.setPassword(faker.internet().password(5, 10));
		Response response = UserEndpoints.updateUser(this.userpayload.getUsername(), userpayload);
		response.then().log().all();
		Assert.assertEquals(200, response.getStatusCode());
		System.out.println(response.time());
		System.out.println(response.getContentType());

		Response responseupdated = UserEndpoints.readUser(this.userpayload.getUsername());
		responseupdated.then().log().all();
		Assert.assertEquals(200, response.getStatusCode());
	}

	@Test(priority = 4)
	public void testDeleteUser() {
		Response response = UserEndpoints.deleteUser(this.userpayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(200, response.getStatusCode());
		System.out.println(response.time());
		System.out.println(response.getContentType());
	}
}
