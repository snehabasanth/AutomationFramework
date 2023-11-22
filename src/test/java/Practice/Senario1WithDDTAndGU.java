package Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.util.PropertiesUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


import GenericUtilities.ExcelFileUtility;
import GenericUtilities.JavaUtility;
import GenericUtilities.PropertyFileUtility;
import GenericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.LoginPage;


public class Senario1WithDDTAndGU {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		ExcelFileUtility eUtil = new ExcelFileUtility();
		PropertyFileUtility pUtil = new PropertyFileUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		JavaUtility jUtil = new JavaUtility();
		WebDriver driver = null;
		
		String Browser = pUtil.readDataFromPropertyFile("browser");
	    String URL = pUtil.readDataFromPropertyFile("url");
	    String USERNAME = pUtil.readDataFromPropertyFile("username");
	    String PASSWORD = pUtil.readDataFromPropertyFile("password");
	 
	    
	    String LASTNAME = eUtil.readDatafromExcelFile("Contacts", 1, 2);
	    
	    
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
	 
	    driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin",Keys.TAB,"admin",Keys.ENTER);
	
	   LoginPage lp = new LoginPage(driver);
	   
	   
	    
	    
	    driver.findElement(By.linkText("Contacts")).click();
		
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	 
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
	    driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
	    
	    //driver.findElement(By.xpath("//td[@class='small' and @valign='bottom'][1]")).click();
	    String contactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	    if(contactHeader.contains(LASTNAME))
	    {
	    	System.out.println("contactHeader");
	    	System.out.println("pass");
	   }
	    else
	    {
	    	System.out.println("fail");
	    }
	     WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	     
	     wUtil.clickAndHoldAction(driver, ele);
	     Thread.sleep(1000);
	     driver.findElement(By.xpath("//a[.='Sign Out']")).click();
	}
}