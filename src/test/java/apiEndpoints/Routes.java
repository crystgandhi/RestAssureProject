package apiEndpoints;

public class Routes {
	//user
	//https://petstore.swagger.io/v2/store/order
	public static String base_url="https://petstore.swagger.io/v2/";
	public static String post_url1=base_url+"user/";
	public static String get_url1=base_url+"user/{username}";
	public static String update_url1=base_url+"user/{username}";
	public static String delete_url1=base_url+"user/{username}";
	//store
	public static String post_url2="https://petstore.swagger.io/v2/store/order";
		//base_url+"store/order";
	public static String get_url2=base_url+"store/order/{orderId}";
	public static String update_url2=base_url+"store/order/{orderId}";
	public static String delete_url2=base_url+"store/order/{orderId}";
	//pet
	public static String post_url3=base_url+"pet";
	public static String get_url3=base_url+"pet/findByStatus";
	public static String update_url3=base_url+"pet";
	public static String delete_url3=base_url+"/pet/{petId}";
}
