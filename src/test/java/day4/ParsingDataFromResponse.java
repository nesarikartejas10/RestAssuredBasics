package day4;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ParsingDataFromResponse {
	
	@Test
	
	public void getUsers()
	{
		Response res = given()
		.contentType(ContentType.JSON)
		.when()
		.get("https://reqres.in/api/users?page=2");
		
		JSONObject jo = new JSONObject(res.asString());
		
		for(int i=0; i<jo.getJSONArray("data").length(); i++)
		{
			String email = jo.getJSONArray("data").getJSONObject(i).get("email").toString();
			System.out.println(email);
		}
		
		
		
		
		
		
	}

}
