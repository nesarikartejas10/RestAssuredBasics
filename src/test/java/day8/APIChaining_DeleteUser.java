package day8;

import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class APIChaining_DeleteUser {
	
	@Test
	public void testDeleteUser(ITestContext context)
	{
		int id = (Integer) context.getSuite().getAttribute("user_id");
		String bearerToken = "2741527e1cd67a1b83d6ba4b47d560ea2330b900b1a5e6fd2ea52d5829a3bc63";
		
		given()
		.header("Authorization","Bearer "+bearerToken)
		.when()
		.delete("https://gorest.co.in/public/v2/users/"+id)
		.then()
		.statusCode(204)
		.log().all();
	}

}
