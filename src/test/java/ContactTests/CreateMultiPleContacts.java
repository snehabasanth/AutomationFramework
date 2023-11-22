package ContactTests;

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
import objectRepository.ContactInfoPage;
import objectRepository.ContactPage;
import objectRepository.CreateNewContactPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class CreateMultiPleContacts {
	
	ExcelFileUtility eUtil = new ExcelFileUtility();
	PropertyFileUtility pUtil = new PropertyFileUtility();
	WebDriverUtility wUtil = new WebDriverUtility();
	JavaUtility jUtil = new JavaUtility();
	
	@Test(dataProvider = "getData")
	public void createMultiPleContact(String LASTNAME) throws IOException, InterruptedException{
		
	WebDriver driver = null;
	
	String Browser = pUtil.readDataFromPropertyFile("browser");
    String URL = pUtil.readDataFromPropertyFile("url");
    String USERNAME = pUtil.readDataFromPropertyFile("username");
    String PASSWORD = pUtil.readDataFromPropertyFile("password");
    
    
   if(Browser.equalsIgnoreCase("Chrome"))
    {
    	WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
    }else if (Browser.equalsIgnoreCase("Edge"))
    {
    	WebDriverManager.edgedriver().setup();
		 driver = new EdgeDriver();
    } else if (Browser.equalsIgnoreCase("Firefox"))
    {
    	WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
    }else {
    	System.out.println("Invalid Browser Name");
    }

    wUtil.maximizeWindow(driver);
    wUtil.maximizeWindow(driver);
    driver.get(URL);
    
    //Loginto application
    
    LoginPage lp = new LoginPage(driver);
    lp.LoginToApp(USERNAME, PASSWORD);
    
    //Navigate to Contacts Link
    HomePage hp = new HomePage(driver);
    hp.clickOncontactLink();
    
    //click on create contact look Image
    ContactPage cp = new ContactPage(driver);
    cp.clickOnCreateContactLookUpimage();
    
    //create new contact
    CreateNewContactPage cncp = new CreateNewContactPage(driver);
    cncp.createNewContact(LASTNAME);
    
    //validate
    ContactInfoPage cip = new ContactInfoPage(driver);
    String contactHeader = cip.getContactHeader();
    Assert.assertTrue(contactHeader.contains(LASTNAME));
    System.out.println(contactHeader);
  //logout
    
    hp.logoutApp(driver);
    
    //close the browser
    driver.quit();
	
	}
	
	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException 
	{
		return eUtil.readMultipleDataFromExcel("CreateMultipleContacts");
	}
}