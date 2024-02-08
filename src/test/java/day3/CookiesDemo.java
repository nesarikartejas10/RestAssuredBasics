package day3;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

public class CookiesDemo {
	
	//@Test(priority = 1)
	public void validateCookie()
	{
		given()
		.when().get("https://google.com")
		.then().cookie("AEC").log().cookies();
	}
	
	//@Test(priority = 2)
	public void getSingleCookieInfo()
	{
		Response res = given()
		.when().get("https://google.com");
		
		String cookieValue = res.getCookie("AEC");
		System.out.println("Value of cookie ===>"+cookieValue);
	}
	
	@Test(priority = 3)
	public void getAllCookiesInfo()
	{
		Response res = given()
				.when().get("https://google.com");
		
		Map<String, String> allCookies = res.getCookies();
		
		System.out.println(allCookies.keySet());
		for(String k : allCookies.keySet())
		{
			String cookieValue = res.getCookie(k);
			System.out.println(k+"===>"+cookieValue);
		}
	}

}
