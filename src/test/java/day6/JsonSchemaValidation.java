package day6;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;

public class JsonSchemaValidation {
	
	@Test
	public void validateJsonSchema()
	{
		given()
		.contentType(ContentType.JSON)
		
		.when()
		.get("https://reqres.in/api/users?page=2")
		
		.then()
		.statusCode(200)
		.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("getUsersJSONSchema.json"));
	}
	

}
