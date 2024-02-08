package day8;

import org.testng.ITestContext;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class APIChaining_GetUser {
	
	@Test
	public void testGetUser(ITestContext context)
	{
		int id = (Integer) context.getSuite().getAttribute("user_id");
		String bearerToken = "2741527e1cd67a1b83d6ba4b47d560ea2330b900b1a5e6fd2ea52d5829a3bc63";
		
		given()
		.header("Authorization","Bearer "+bearerToken)
		.when()
		.get("https://gorest.co.in/public/v2/users/"+id)
		.then()
		.statusCode(200)
		.log().all();
	}

}
