package day4;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ValidateJSONResponse {
	
	//*Validating json response using Matchers==>(with using then())
	
	//@Test(priority = 1)
	public void testJsonResponseApproach1()
	{
		given()
		.contentType(ContentType.JSON)
		.when()
		.get("https://reqres.in/api/users?page=2")
		.then()
		.statusCode(200)
		.header("Content-Type", "application/json; charset=utf-8")
		.body("data[4].first_name", equalTo("George"));
		
	}
	
	//*validating json response using Assertions(without using then())
	
	@Test(priority = 2)
	public void testJsonResponseApproach2()
	{
		Response res = given()
		                  .contentType(ContentType.JSON)
		               .when()
		                  .get("https://reqres.in/api/users?page=2");
		
		Assert.assertEquals(res.getStatusCode(), 200);
		Assert.assertEquals(res.header("Content-Type"), "application/json; charset=utf-8");
		Assert.assertEquals(res.jsonPath().get("data[4].first_name").toString(), "George");
		
		
	}

}
