package day8;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.http.ContentType;

public class APIChaining_UpdateUser {

	@Test
	public void testUpdateUser(ITestContext context)
	{
		int id = (Integer) context.getSuite().getAttribute("user_id");
		String bearerToken = "2741527e1cd67a1b83d6ba4b47d560ea2330b900b1a5e6fd2ea52d5829a3bc63";
		Faker fk = new Faker();

		JSONObject jo = new JSONObject();
		jo.put("name", fk.name().fullName());
		jo.put("gender", "male");
		jo.put("email", fk.internet().emailAddress());
		jo.put("status", "active");

		given()
		.header("Authorization","Bearer "+bearerToken)
		.contentType(ContentType.JSON)
		.body(jo.toString())
		.when()
		.put("https://gorest.co.in/public/v2/users/"+id)
		.then()
		.statusCode(200)
		.log().all();
		
	}

}
