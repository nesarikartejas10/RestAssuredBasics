package day2;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;



/*
Different ways to create Post request body.
1)using Hashmap
2)using org.json
3)using POJO(Plain Old Java Object)
4)using External json file  */

public class WaysToCreatePostRequestBody {
	
	//1.POST request body using HashMap

//	@Test(priority = 1)
	public void testpostUsingHashmap()
	{
		HashMap<String,Object> data = new HashMap<String,Object>();
		data.put("name", "Tejas");
		data.put("age", "28");
		data.put("grade", "A");
		
		String subjectArr[] = {"RestAssured","Selenium"};
		data.put("subjects", subjectArr);
		
		given()
		.contentType("application/json")
		.body(data)
		
		.when()
		.post("http://localhost:3000/students")
		
		.then()
		.statusCode(201)
		.body("name", equalTo("Tejas"))
		.body("age", equalTo("28"))
		.body("grade", equalTo("A"))
		.body("subjects[0]", equalTo("RestAssured"))
		.body("subjects[1]", equalTo("Selenium"))
		.header("Content-Type", "application/json; charset=utf-8")
		.log().all();		
	}
	
	//2.POST request body using org.json
	
	//@Test(priority = 2)
	public void testPostUsingJsonLibrary()
	{
		JSONObject data = new JSONObject();
		data.put("name", "Tejas");
		data.put("age", "28");
		data.put("grade", "A");
		
		String subjectArr[] = {"RestAssured","Selenium"};
		data.put("subjects", subjectArr);
		
		given()
		.contentType("application/json")
		.body(data.toString())
		
		.when()
		.post("http://localhost:3000/students")
		
		.then()
		.statusCode(201)
		.body("name", equalTo("Tejas"))
		.body("age", equalTo("28"))
		.body("grade", equalTo("A"))
		.body("subjects[0]", equalTo("RestAssured"))
		.body("subjects[1]", equalTo("Selenium"))
		.header("Content-Type", "application/json; charset=utf-8")
		.log().all();	
	}
	
	//3.POST request body using POJO
	
	//@Test(priority = 3)
	public void testPostUsingPojo()
	{
		Pojo_PostRequest data = new Pojo_PostRequest();
		data.setName("Tejas");
		data.setAge("28");
		data.setGrade("A");
		
		String subjectArr[] = {"RestAssured","Selenium"};
		data.setSubjects(subjectArr);
		
		given()
		.contentType("application/json")
		.body(data)
		
		.when()
		.post("http://localhost:3000/students")
		
		.then()
		.statusCode(201)
		.body("name", equalTo("Tejas"))
		.body("age", equalTo("28"))
		.body("grade", equalTo("A"))
		.body("subjects[0]", equalTo("RestAssured"))
		.body("subjects[1]", equalTo("Selenium"))
		.header("Content-Type", "application/json; charset=utf-8")
		.log().all();	
	}
	
	//4.POST request body using external JSON file
	
	@Test(priority = 4)
	public void testPostUsingExternalJsonFile() throws FileNotFoundException
	{
		File f = new File(System.getProperty("user.dir")+"\\src\\test\\resource\\body.json");
		FileReader fr = new FileReader(f);
		JSONTokener jt = new JSONTokener(fr);
		JSONObject data = new JSONObject(jt);
		
		given()
		.contentType("application/json")
		.body(data.toString())
		
		.when()
		.post("http://localhost:3000/students")
		
		.then()
		.statusCode(201)
		.body("name", equalTo("Tejas"))
		.body("age", equalTo("28"))
		.body("grade", equalTo("A"))
		.body("subjects[0]", equalTo("RestAssured"))
		.body("subjects[1]", equalTo("Selenium"))
		.header("Content-Type", "application/json; charset=utf-8")
		.log().all();	
	}
	
	
	@Test(priority=100)
	public void deleteData()
	{
		when()
		.delete("http://localhost:3000/students/4")
		
		.then()
		.statusCode(200);
	}
	
	
	
	

}
