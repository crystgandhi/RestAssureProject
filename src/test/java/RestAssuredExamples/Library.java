package RestAssuredExamples;

import org.testng.annotations.DataProvider;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Library {

	@Test(dataProvider="Bookdetails")
	public void addBook(String aisle, String isbn) {
	RestAssured.baseURI="http://216.10.245.166/";
	String res=given().log().all().header("Content-Type", "application/json").body(Payload.addBookdata(aisle, isbn))
	.when().post("Library/Addbook.php")
	.then().assertThat().statusCode(200).extract().response().asPrettyString();
	System.out.println("Book Added Response : "+res);
	JsonPath js=new JsonPath(res);
	System.out.println(js.get("ID"));
	System.out.println(js.get("Msg"));
}
	@DataProvider(name="Bookdetails")
	public Object[][] getData() {
		return new Object[][] {{"kgknk", "1343"},{"kgknr", "1564"}, {"kgsr", "1298"}};
	}
	
	
	@Test(dataProvider="deleteBookdetails")
	public void deleteBook(String aisle, String isbn) {
		RestAssured.baseURI="http://216.10.245.166/";
		String deleteResponse=given().log().all().header("Content-Type", "application/json")
				.body(Payload.addBookdata(aisle, isbn))
		.when().delete("Library/DeleteBook.php")
		.then().assertThat().statusCode(200).extract().response().asPrettyString();
		System.out.println("Book deleted : "+ deleteResponse);
	}
	@DataProvider(name="deleteBookdetails")
	public Object[][] getData1() {
		return new Object[][] {{"kgknk", "1343"},{"kgknr", "1564"}};
	}
	
	@Test
	public void addBookJsonfile() throws IOException {
	RestAssured.baseURI="http://216.10.245.166/";
	String res=given().log().all().header("Content-Type", "application/json")
	.body(new String(Files.readAllBytes(Paths.get("C:\\Users\\Nikilkumaran\\workspace\\Java2023 workspace\\RestAssuredProject\\Bookdata.json"))))
	.when().post("Library/Addbook.php")
	.then().assertThat().statusCode(200).extract().response().asPrettyString();
	System.out.println("Book Added Response : "+res);
	JsonPath js=new JsonPath(res);
	System.out.println(js.get("ID"));
	System.out.println(js.get("Msg"));
}
	
}


