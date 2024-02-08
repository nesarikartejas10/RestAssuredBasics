package day3;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class LoggingDemo {
	
	@Test(priority = 1)
	public void getLogging()
	{
		given()
		.when().get("https://reqres.in/api/users?page=2")
		.then()
		//.log().all(); //get all information 
		//.log().body(); //get response body
		//.log().cookies(); //get all cookies info
		//.log().headers(); //get all headers info
		.log().status(); //get status code		
	}
	
	@Test(priority = 2)
	public void getStatusCodeAndResponseTime()
	{
		Response res = given()
		              .when().get("https://reqres.in/api/users?page=2");
		
		int statusCode = res.getStatusCode();
		System.out.println("Status code = "+statusCode);
		
		long responseTime = res.time();
		System.out.println("Time taken to fetch the data "+responseTime);
	}
	
	

}
