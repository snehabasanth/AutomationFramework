package Practice;


import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.Test;

public class RetryAnalyserPractice  {
	
	@Test(retryAnalyzer = GenericUtilities.RetryAnalysisImplementation.class)
	public void sample()
	{
	    Assert.fail();
		System.out.println("Hi");
    }

	@Test
	public void sample1()
	{
	System.out.println("Hello");
    }

}
