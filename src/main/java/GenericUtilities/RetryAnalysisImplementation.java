package GenericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;


public  class RetryAnalysisImplementation implements IRetryAnalyzer{

	int count = 0;
    int retryCount = 3;//based on manual analysis
	
    public boolean retry(ITestResult result) {
		//count is  is it 0< 3 1<3 2<3 3<3
    	while(count<retryCount)
		{
			count++;//1 2 3
			return true;//retry
		}
		return false;//stop retrying
	}
	


}



