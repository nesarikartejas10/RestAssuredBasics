package day6;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SerializationDeserialization {
	
	@Test(priority = 1)
	public void convertJavaObjectToJsonObject() throws JsonProcessingException
	{
		//created java object using POJO class
		PojoRequestBody javaObj = new PojoRequestBody();
		
		javaObj.setName("Tejas");
		javaObj.setAge("28");
		javaObj.setGrade("A");
		
		String subjectArray[] = {"Java","Selenium"};
		javaObj.setSubjects(subjectArray);
		
		//convert java object into JSON object using Serialization
		ObjectMapper objMapper = new ObjectMapper();
		String jsonData = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(javaObj);
		System.out.println(jsonData);
	}
	
	@Test(priority = 2)
	public void convertJSONObjectToJavaObject() throws JsonMappingException, JsonProcessingException
	{
		String jsonData = "{\r\n"
				+ "  \"name\" : \"Tejas\",\r\n"
				+ "  \"age\" : \"28\",\r\n"
				+ "  \"grade\" : \"A\",\r\n"
				+ "  \"subjects\" : [ \"Java\", \"Selenium\" ]\r\n"
				+ "}";
		
		ObjectMapper objMapper = new ObjectMapper();
		PojoRequestBody javaObj = objMapper.readValue(jsonData, PojoRequestBody.class);
		System.out.println(javaObj.getName());
		System.out.println(javaObj.getAge());
		System.out.println(javaObj.getGrade());
		System.out.println(javaObj.getSubjects()[0]);
		System.out.println(javaObj.getSubjects()[1]);
	}

}
