package practise;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{

	private int count = 0;
	private int maxRetryCount = 2;
	@Override
	public boolean retry(ITestResult result) {
		
		if(!result.isSuccess())
		{
			if(count<maxRetryCount)
			{
				count++;
				return true;
			}
		}
		return false;
	}

}
