package practise;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyDemo {
	
	public static String getPropData(String key) throws FileNotFoundException {
		
		String path = System.getProperty("user.dir")+"\\src\\test\\resource\\config.properties";
		File file = new File(path);
		FileInputStream fis = new FileInputStream(file);
		Properties prop = new Properties();
		
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String value = prop.getProperty(key);
		return value;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		
		System.out.println("Username : "+getPropData("username"));
		System.out.println("Password : "+getPropData("password"));
	}

}
