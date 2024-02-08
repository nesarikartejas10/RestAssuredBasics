package practise;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class HttpRequest {
	
	String base_url = "https://fakestoreapi.com/products";
	int id = 0;
	@Test(priority = 1)
	public void getAllProducts()
	{
		
		when()
		.get(base_url)
		.then()
		.statusCode(200)
		.contentType("application/json")
		.log().body();
	}
	
	@Test(priority = 2)
	public void getSingleProduct()
	{
		when()
		.get(base_url+"/3")
		.then()
		.statusCode(200)
		.log().body();
	}

	@Test(priority = 3)
	public void addNewProduct()
	{
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("title", "test product");
		data.put("price", 13.5);
		data.put("description", "lorem ipsum set");
		data.put("image", "https://i.pravatar.cc");
		data.put("category", "electronic");
		
		Response resp = given()
		.contentType(ContentType.JSON)
		.body(data)
		.when()
		.post(base_url);
		
		id = resp.jsonPath().get("id");
		resp.then()
		.statusCode(200)
		.header("Content-Type","application/json; charset=utf-8")
		.log().body();		
		System.out.println("New product created ID : "+id);
		
	}
	
	@Test(priority = 4)
	public void updateProduct()
	{
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("title", "Mac");
		data.put("price", 20);
		data.put("description", "apple product");
		data.put("image", "https://apple.cc");
		data.put("category", "electronic");
		
		       given()
				.contentType(ContentType.JSON)
				.body(data)
				.when()
				.put(base_url+"/"+id)
		       .then()
		       .statusCode(200)
		       .header("Content-Type","application/json; charset=utf-8")
		       .log().body();
	}
	
	@Test(priority = 5,dependsOnMethods = "addNewProduct")
	public void deleteProduct()
	{
		when()
		.delete(base_url+"/"+id)
		.then()
		.statusCode(200)
		.contentType("application/json")
		.log().body();
	}

}
