package OrganizationTests;
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
import objectRepository.CreateNewOrganisationPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.OrganisationPage;
import objectRepository.OrganisationPageInfo;

public class OrganisationWithIndustryandType extends BaseClass {


     @Test(groups = "SmokeSuite1")
	public void  OrganisationWithIndustry() throws IOException, InterruptedException, EncryptedDocumentException{
		

		
		String ORGNAME = eUtil.readDatafromExcelFile("Organisation", 7, 2);
		String INDUSTRYNAME = eUtil.readDatafromExcelFile("Organisation", 7, 3);
		String TYPENAME = eUtil.readDatafromExcelFile("Organisation", 7, 4);

		// Step 2: Launch the browser - PolyMorphism - Run Time - Driver
		
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
	}
