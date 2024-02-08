package day5;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

import org.testng.annotations.Test;

public class FileUpload {
	
	@Test(priority = 1)
	public void singleFileUpload()
	{
		File myfile = new File("D:\\SoftwareTestingSyllabus\\Rest Assured\\Sample text1.txt");
		
		 given()
		.multiPart("file",myfile)
		.contentType("multipart/form-data")
		.when()
		.post("http://httpbin.org/post")
	    .then()
	    .statusCode(200)
	    .log().body();		
	}
	
	@Test(priority = 2)
	public void multipleFileUpload()
	{
		File myfile1 = new File("D:\\SoftwareTestingSyllabus\\Rest Assured\\Sample text1.txt");
		File myfile2 = new File("D:\\SoftwareTestingSyllabus\\Rest Assured\\Sample text2.txt");
		
		 given()
		.multiPart("files",myfile1)
		.multiPart("files",myfile2)
		.contentType("multipart/form-data")
		.when()
		.post("http://httpbin.org/post")
	    .then()
	    .statusCode(200)
	    .log().body();		
	}

}
