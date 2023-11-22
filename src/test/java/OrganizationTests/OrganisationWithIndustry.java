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

import GenericUtilities.BaseClass;
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

public class OrganisationWithIndustry extends BaseClass {


     @Test(groups = "SmokeSuite1")
	public void  OrganisationWithIndustry() throws IOException, InterruptedException, EncryptedDocumentException{
		

		// Step 1: Read all the required Data
		/* Common Data */
		
		/* Test Data */
		String ORGNAME = eUtil.readDatafromExcelFile("Organisation", 4, 2);
		String INDUSTRYNAME = eUtil.readDatafromExcelFile("Organisation", 4, 3);

		
	    
	    HomePage hp = new HomePage(driver);
	    hp.clickOnOrganizationsLink();
	    
	    OrganisationPage op = new OrganisationPage(driver);
	    op.clickOnCreateOrganisationLookUpImage();
	    
	    CreateNewOrganisationPage CNOP = new CreateNewOrganisationPage(driver);
	    CNOP.CreateNewOrganization(ORGNAME, INDUSTRYNAME);
		
	    OrganisationPageInfo opi = new OrganisationPageInfo(driver);
	    String organsationheader = opi.getOrganizationHeader();
	    Assert.assertTrue(organsationheader.contains(ORGNAME));
		System.out.println(organsationheader);
        
	    
	    //close the browser
	    driver.quit();
	}

}
     
