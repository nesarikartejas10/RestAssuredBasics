package practise;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parameterization {
	
	@Parameters({"uname","pwd"})
	@Test
	public void logIn(String userName, String password)
	{
		System.out.println("Valid username is : "+userName);
		System.out.println("Valid password is : "+password);
	}

}
