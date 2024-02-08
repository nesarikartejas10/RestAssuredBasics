package day7;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Authentications {

	//Basic Authentication
	//@Test(priority = 1)
	public void basicAuth()
	{
		given()
		.auth().basic("postman", "password")
		.when()
		.get("https://postman-echo.com/basic-auth")
		.then()
		.statusCode(200)
		.body("authenticated", equalTo(true))
		.log().all();
	}

	//Digest Authentication
	//@Test(priority = 2)
	public void digestAuth()
	{
		given()
		.auth().digest("postman", "password")
		.when()
		.get("https://postman-echo.com/basic-auth")
		.then()
		.statusCode(200)
		.body("authenticated", equalTo(true))
		.log().all();
	}

	//Preemptive Authentication
//	@Test(priority = 3)
	public void preemptiveAuth()
	{
		given()
		.auth().preemptive().basic("postman", "password")
		.when()
		.get("https://postman-echo.com/basic-auth")
		.then()
		.statusCode(200)
		.body("authenticated", equalTo(true))
		.log().all();
	}

	//Bearer Token authentication
	//	@Test(priority = 4)
	public void bearerTokenAuth()
	{
		String bearerToken = "Bearer 2741527e1cd67a1b83d6ba4b47d560ea2330b900b1a5e6fd2ea52d5829a3bc63";
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("name", "Tejas");
		data.put("gender", "male");
		data.put("email", "tn17@gmail.com");
		data.put("status", "active");

		given()
		.contentType(ContentType.JSON)
		.body(data)
		.header("Authorization", bearerToken)
		.when()
		.post("https://gorest.co.in/public/v2/users")
		.then()
		.statusCode(201)
		.header("Content-Type", "application/json; charset=utf-8")
		.log().body();			
	}

	//OAuth 1.0 authentication

	public void oAuth1()
	{
		//syntax			
		given()
		.auth().oauth("consumerKey","consumerSecret","accessToken","tokenSecret")
		.when()
		.get("url")
		.then()
		.statusCode(200)
		.log().all();
	}

	//OAuth 2.0 authentication

	//@Test(priority = 5)
	public void oAuth2()
	{			
		given()
		.auth().oauth2("A21AAKafX8TtbrWW1t0P7YDNzmXs_hit4hPu0cW9X1iaob9TV9INkKzos_-DrzrKFDNh29XGw5dc4SPlGy6LQQNgR4MQO3y7Q")
		.queryParam("page", 3)
		.queryParam("page_size", 4)
		.queryParam("total_count_required", true)
		.when()
		.get("https://api-m.sandbox.paypal.com/v1/invoicing/invoices")
		.then()
		.statusCode(200)
		.log().all();
	}
	
	//API key authentication
	
	@Test(priority = 6)
	public void apiKeyAuth()
	{
		given()
		.queryParam("appid", "2b175f7b74b97dd6935764d2db769d6b")
		.queryParam("q", "Delhi")
		.pathParam("myPath", "data/2.5/weather")
		.when()
		.get("https://api.openweathermap.org/{myPath}")
		.then()
		.statusCode(201)
		.log().body();
	}

}
