package GenericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/** 
 * This class provides implementation to ITestListener Interface of TestNg
 * GenericUtilities.ListenersImplementation
 */
public class ListenersImplementation  implements ITestListener {

	 ExtentReports report;
	 ExtentTest test;
	 
	 public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		String methodName= result.getMethod().getMethodName();//name of the test annotation method
		System.out.println(methodName+"--------Test Execution Started--------");
	    
		test = report.createTest(methodName);
	 
	 }

	
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"--------Test Pass--------");
	   
		test.log(Status.PASS, methodName+"--------Test Pass--------");
	
	}

	
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"--------Test Fail--------");	
		System.out.println(result.getThrowable());
		
		test.log(Status.FAIL, methodName+"--------Test Fail--------");
		test.log(Status.INFO, result.getThrowable());
		
		
		WebDriverUtility wUtil = new WebDriverUtility();
		JavaUtility jUtil = new JavaUtility();
		
		String screenshotName = methodName+jUtil.getSystemDateInFormat();
		
		try {
			
		String	path = wUtil.captureScreenShot(BaseClass.sdriver, screenshotName);
		
		test.addScreenCaptureFromPath(path);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"--------Test Skip--------");
		System.out.println(result.getThrowable());
	
		test.log(Status.SKIP, methodName+"--------Test Skip--------");
		test.log(Status.INFO, result.getThrowable());
	
	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	    
	}

	public void onTestFailedWithTimeout(ITestResult result) {
	// TODO Auto-generated method stub	
	
	}
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("-------Suite Execution Started-------");
		// Extent Report Configuration
		ExtentSparkReporter htmlreport = new ExtentSparkReporter(".\\ExtentReport\\Report-"+new JavaUtility().getSystemDateInFormat()+".html");
		htmlreport.config().setDocumentTitle("Execution Report");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("QCO-SOEAJD-MS-Execution Report");
		
		report = new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("Base Browser", "Edge");
		report.setSystemInfo("Base Platform", "Windows Family");
		report.setSystemInfo("Base Environment", "Testing");
		report.setSystemInfo("Base URL", "http://localhost:8888");
		report.setSystemInfo("Reporter Name", "Sneha");
		
	}

	
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("-------Suite Execution Finished-------");
		
	report.flush();
	
	
	}

	

}
