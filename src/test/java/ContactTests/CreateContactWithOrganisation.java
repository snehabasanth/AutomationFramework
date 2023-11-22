package ContactTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
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

import objectRepository.CreateNewOrganisationPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.OrganisationPage;
import objectRepository.OrganisationPageInfo;

public class CreateContactWithOrganisation extends BaseClass{

	
	@Test(groups = "RegressionSuite")
	public void CreateContactWithOrganisation() throws IOException, InterruptedException, EncryptedDocumentException {

		

		

		/* Test Data */
		String LASTNAME = eUtil.readDatafromExcelFile("Contacts", 4, 2);
		String ORGNAME = eUtil.readDatafromExcelFile("Contacts", 4, 3)+jUtil.getRandomNumber();

		
	    
	    HomePage hp = new HomePage(driver);
	    hp.clickOnOrganizationsLink();
	    
	    OrganisationPage op = new OrganisationPage(driver);
	    op.clickOnCreateOrganisationLookUpImage();
	    
	   CreateNewOrganisationPage cnop = new CreateNewOrganisationPage(driver);
	   cnop.CreateNewOrganization(ORGNAME);
	    
	    OrganisationPageInfo opi = new OrganisationPageInfo(driver);
	    String organsationheader = opi.getOrganizationHeader();
		Assert.assertTrue(organsationheader.contains(ORGNAME));
		System.out.println(organsationheader);    
		
	    
		hp.clickOncontactLink();
		
		ContactPage cp = new ContactPage(driver);
	    cp.clickOnCreateContactLookUpimage();
	    
	   
	    
	    CreateNewContactPage cncp = new CreateNewContactPage(driver);
	    cncp.createNewContact(ORGNAME, LASTNAME, driver);
	   
	    ContactInfoPage cip = new ContactInfoPage(driver);
	    String contactHeader = cip.getContactHeader();
	    Assert.assertTrue(contactHeader.contains(LASTNAME));
	    System.out.println("contactHeader");
	    
	  //logout
	    
	    hp.logoutApp(driver);
	    
	    //close the browser
	    driver.quit();
	}
}
