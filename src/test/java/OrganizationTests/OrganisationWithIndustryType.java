package OrganizationTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import GenericUtilities.ExcelFileUtility;
import GenericUtilities.JavaUtility;
import GenericUtilities.PropertyFileUtility;
import GenericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.CreateNewOrganisationPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.OrganisationPage;
import objectRepository.OrganisationPageInfo;

public class OrganisationWithIndustryType {
	
	ExcelFileUtility eUtil = new ExcelFileUtility();
	PropertyFileUtility pUtil = new PropertyFileUtility();
	WebDriverUtility wUtil = new WebDriverUtility();
	JavaUtility jUtil = new JavaUtility();
	
	
	@Test(dataProvider="getData")
	
	public void OrganisationWithIndustryType(String ORGNAME, String INDUSTRYNAME, String TYPENAME) throws IOException, InterruptedException{
		
		WebDriver driver = null;

		// Step 1: Read all the required Data
		/* Common Data */
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
	  
		
		if (BROWSER.equalsIgnoreCase("Chrome"))// true f
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("Firefox")) // t f
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (BROWSER.equalsIgnoreCase("Edge"))// f
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			System.out.println("invalid Browser name");
		}

		wUtil.maximizeWindow(driver);
		wUtil.waitForPageLoad(driver);
		driver.get(URL);
		
		LoginPage lp = new LoginPage(driver);
	    lp.LoginToApp(USERNAME, PASSWORD);
	    
	    HomePage hp = new HomePage(driver);
	    hp.clickOnOrganizationsLink();
	    
	    OrganisationPage op = new OrganisationPage(driver);
	    op.clickOnCreateOrganisationLookUpImage();
	    
	    CreateNewOrganisationPage CNOP = new CreateNewOrganisationPage(driver);
	    CNOP.CreateNewOrganization1(ORGNAME, INDUSTRYNAME, TYPENAME);
		
	   
		
		OrganisationPageInfo opi=new OrganisationPageInfo(driver);
	    String organsationheader = opi.getOrganizationHeader();
	    Assert.assertTrue(organsationheader.contains(ORGNAME));
		System.out.println(organsationheader);
	    hp.logoutApp(driver);
	    
	    driver.quit();
		}
	
	@DataProvider
 	public Object[][] getData() throws EncryptedDocumentException, IOException 
 	{
 		
		return eUtil.readMultipleDataFromExcel("OrganizationWithIndustryType");
 	}
}