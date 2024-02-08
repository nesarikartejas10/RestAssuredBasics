package practise;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RerunFailedTestCase {
	
	@Test(priority = 1)
	public void logIn()
	{
		System.out.println("LogIn to the application");
	}
	
	@Test(priority = 2)
	public void homePage()
	{
		System.out.println("Redirect to the home page");
	}
	
	@Test(priority = 3, retryAnalyzer = Retry.class)
	public void addToCart()
	{
		Assert.assertTrue(false);
		System.out.println("Product is selected and added to the cart");
		
	}
	
	@Test(priority = 4)
	public void transaction()
	{
		System.out.println("Make a payment");
	}
	
	@Test(priority = 5)
	public void logOut()
	{
		System.out.println("successfully log out");
	}

}
