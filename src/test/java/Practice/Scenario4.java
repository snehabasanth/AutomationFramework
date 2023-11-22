package Practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import GenericUtilities.ExcelFileUtility;
import GenericUtilities.JavaUtility;
import GenericUtilities.PropertyFileUtility;
import GenericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario4  {
 
	public static void main(String[] args) throws InterruptedException, IOException {
	
	ExcelFileUtility eUtil = new ExcelFileUtility();
	PropertyFileUtility pUtil = new PropertyFileUtility();
	WebDriverUtility wUtil = new WebDriverUtility();
	JavaUtility jUtil = new JavaUtility();
	WebDriver driver = null;
	
	String BROWSER = pUtil.readDataFromPropertyFile("browser");
	String URL = pUtil.readDataFromPropertyFile("url");
	String USERNAME = pUtil.readDataFromPropertyFile("username");
	String PASSWORD = pUtil.readDataFromPropertyFile("password");
	
	String ORGNAME = eUtil.readDatafromExcelFile("Organisation", 7, 2);
	String INDUSTRYNAME = eUtil.readDatafromExcelFile("Organisation", 7, 3);
	String TYPENAME = eUtil.readDatafromExcelFile("Organisation", 7, 4);
	
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

	// Step 3: Login to Application
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();

	//Step 4: Navigate to Organizations
	driver.findElement(By.linkText("Organizations")).click();
	
	//Step 5: Click on Create Organization look up Imge
	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	
	//Step 6: Create Organization With Mnadatory fields
	driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
	
	driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(ORGNAME);
    WebElement industry = driver.findElement(By.name("industry"));
    industry.click();
    Thread.sleep(1000);
    wUtil.handleDropdown(INDUSTRYNAME, industry);
    
    WebElement type = driver.findElement(By.name("accounttype"));
    type.click();
    wUtil.handleDropdown(TYPENAME, type);
    
    driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
    
    String organizationHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
    if(organizationHeader.contains(ORGNAME))
    {
    	System.out.println("organizationHeader");
    	System.out.println("pass");
   }
    else
    {
    	System.out.println("fail");
    }
     WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
     
     wUtil.mouseHoverAction(driver, ele);
     Thread.sleep(1000);
     driver.findElement(By.xpath("//a[.='Sign Out']")).click();
	
	}
	
}
