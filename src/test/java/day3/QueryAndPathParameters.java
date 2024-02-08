package day3;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class QueryAndPathParameters {
	
	//https://reqres.in/api/users?page=2&id=11
	
	@Test
	public void testQueryAndPathParams()
	{
		given()
		.pathParam("myPath", "users") //path parameter
		.queryParam("page", 2)        //query parameter
		.queryParam("id", 11)         //query parameter
		
		.when()
		.get("https://reqres.in/api/{myPath}")
		
		.then()
		.statusCode(200)
		.log().body();
	}

}
