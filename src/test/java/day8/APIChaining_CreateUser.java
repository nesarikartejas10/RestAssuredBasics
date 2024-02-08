package day8;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;

public class APIChaining_CreateUser {

	@Test
	public void testCreateUser(ITestContext context)
	{
		String bearerToken = "2741527e1cd67a1b83d6ba4b47d560ea2330b900b1a5e6fd2ea52d5829a3bc63";
		Faker fk = new Faker();

		JSONObject jo = new JSONObject();
		jo.put("name", fk.name().fullName());
		jo.put("gender", "male");
		jo.put("email", fk.internet().emailAddress());
		jo.put("status", "inactive");

		int id =given()
				.header("Authorization","Bearer "+bearerToken)
				.contentType(ContentType.JSON)
				.body(jo.toString())
				.when()
				.post("https://gorest.co.in/public/v2/users")
				.jsonPath().getInt("id");

		System.out.println("Created user_id : "+id);

		context.getSuite().setAttribute("user_id", id);	
	}

}
