package RestAssuredExamples;

public class Payload {
	
	public static String addBookdata(String aisle, String isbn) {
	String data=	"{\r\n"
		+ "\"name\":\"Learn Appium Automation with Java\",\r\n"
		+ "\"isbn\":\""+isbn+"\",\r\n"
		+ "\"aisle\":\""+aisle+"\",\r\n"
		+ "\"author\":\"John foe\"\r\n"
		+ "}\r\n"
		+ "";
	return data;
	}

}
