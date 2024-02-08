package day7;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class FakerDataLibrary {
	
	@Test
	public void fakerDataGenerator()
	{
		Faker fk = new Faker();
		
		System.out.println("First Name : "+fk.name().firstName());
		System.out.println("Last Name : "+fk.name().lastName());
		System.out.println("Username : "+fk.name().username());
		System.out.println("Password : "+fk.internet().password());
		System.out.println("email Id : "+fk.internet().emailAddress());
		
	}

}
