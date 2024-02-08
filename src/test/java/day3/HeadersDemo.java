package day3;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class HeadersDemo {
	
	//@Test(priority = 1)
	public void validateHeaders()
	{
		given()
		.when().get("https://google.com")
		.then().header("Content-Type", "text/html; charset=ISO-8859-1")
		       .header("Content-Encoding","gzip")
		       .header("Server","gws").log().headers();
	}
	
	//@Test(priority = 2)
	public void getSingleCookieInfo()
	{
		Response res = given()
		               .when().get("https://google.com");
		
		String headerValue = res.getHeader("Content-Type");
		System.out.println("Value of header ===>"+headerValue);
	}
	
	@Test(priority = 3)
	public void getAllCookiesInfo()
	{
		Response res = given()
		.when().get("https://google.com");
		
		Headers allHeaders = res.getHeaders();
		
		for(Header h: allHeaders)
		{
			System.out.println(h.getName()+"===>"+h.getValue());
		}
	}
	
	

}
