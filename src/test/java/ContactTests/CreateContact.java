package ContactTests;



import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericUtilities.BaseClass;
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
@Listeners (GenericUtilities.ListenersImplementation.class)
public class CreateContact extends BaseClass{

	@Test(groups = {"SmokeSuite", "RegressionSuite"})
	public void CreateContact() throws IOException, InterruptedException, EncryptedDocumentException  {
		{
			
		String LASTNAME = eUtil.readDatafromExcelFile("Contacts", 1, 2);
		    
		    HomePage hp = new HomePage(driver);
		    hp.clickOncontactLink();
		    
		    ContactPage cp = new ContactPage(driver);
		    cp.clickOnCreateContactLookUpimage();
		    
		    
		    
		    CreateNewContactPage cncp = new CreateNewContactPage(driver);
		    cncp.createNewContact(LASTNAME);
		    
		    ContactInfoPage cip = new ContactInfoPage(driver);
		    String contactHeader = cip.getContactHeader();
		    Assert.assertTrue(contactHeader.contains(LASTNAME));
		    System.out.println(contactHeader);
		    hp.logoutApp(driver);
		     driver.quit();
		}
	}
}

