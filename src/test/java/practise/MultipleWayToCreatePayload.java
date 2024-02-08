package practise;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class MultipleWayToCreatePayload {
	
	//using hashmap
	//@Test
	public void usingHashmap() {
		HashMap<String, Object> data = new HashMap<String, Object>();
		
		data.put("name", "Tejas");
		data.put("age", "28");
		data.put("grade", "A+");
		
		String subArray[] = {"Java","Selenium","SQL"};
		data.put("subjects", subArray);
		
		given()
		.contentType(ContentType.JSON)
		.body(data)
		.when()
		.post("http://localhost:3000/students")
		.then()
		.statusCode(201)
		.header("Content-Type", "application/json; charset=utf-8")
		.log().body();
	}
	
	//@Test
	public void usingJsonObject() {
		
		JSONObject data = new JSONObject();
		data.put("name", "Prasad");
		data.put("age", "25");
		data.put("grade", "B");
		
		String subArray[] = {"API","Postman","SQL"};
		data.put("subjects", subArray);
		
		given()
		.contentType(ContentType.JSON)
		.body(data.toString())
		.when()
		.post("http://localhost:3000/students")
		.then()
		.statusCode(201)
		.header("Content-Type", "application/json; charset=utf-8")
		.log().body();
	}
	
	//@Test
	public void usingPojo() {
		
		PojoData data = new PojoData();
		data.setName("Soham");
		data.setAge("26");
		data.setGrade("A-");
		String subArray[] = {"Javascript","React","nodeJS"};
		data.setSubjects(subArray);
		
		given()
		.contentType(ContentType.JSON)
		.body(data)
		.when()
		.post("http://localhost:3000/students")
		.then()
		.statusCode(201)
		.header("Content-Type", "application/json; charset=utf-8")
		.log().body();
	}
	
	@Test
	public void usingExternalJson() throws FileNotFoundException {
		
		File file = new File(System.getProperty("user.dir")+"\\src\\test\\resource\\stud.json");
		FileReader fr = new FileReader(file);
		JSONTokener jt = new JSONTokener(fr);
		JSONObject data = new JSONObject(jt);
		
		given()
		.contentType(ContentType.JSON)
		.body(data.toString())
		.when()
		.post("http://localhost:3000/students")
		.then()
		.statusCode(201)
		.header("Content-Type", "application/json; charset=utf-8")
		.log().body();
		
	}

}
