package practise;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {
	
	@DataProvider(name="loginTestData")
	public Object[][] setData() {
		Object[][] data = {{"abc","abc@123"},{"xyz","xyz@123"},{"pqr","pqr@123"}};
		return data;
	}
	
	@Test(dataProvider = "loginTestData")
	public void getData(String un, String pwd) {
		System.out.println(un+" : "+pwd);
	}

}
