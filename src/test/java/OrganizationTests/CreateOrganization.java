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

public class CreateOrganization extends BaseClass{

	@Test(groups = "SmokeSuite1")
	public void CreateOrganization() throws IOException, InterruptedException, EncryptedDocumentException{
	
	
	

	String ORGNAME = eUtil.readDatafromExcelFile("Organisation", 1, 2)+jUtil.getRandomNumber();

	
    
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
    
    hp.logoutApp(driver);
    
    driver.quit();
	}
}

