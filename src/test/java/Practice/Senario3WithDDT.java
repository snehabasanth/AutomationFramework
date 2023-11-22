package Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

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
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Senario3WithDDT {

	public static void main(String[] args)  throws IOException, InterruptedException{
		// TODO Auto-generated method stub

		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\CommonDataProperties");
	    Properties p = new Properties();
	    p.load(fis);
	    String URL = p.getProperty("url");
	    String Browser = p.getProperty("browser");
	    String USERNAME = p.getProperty("username");
	    String PASSWORD = p.getProperty("password");
	    
	 
	    FileInputStream fis1 = new FileInputStream(".\\src\\test\\resources\\testdata.xlsx");
	    Workbook wb = WorkbookFactory.create(fis1);
	    String  ORGANISATIONNAME = wb.getSheet("Organisation").getRow(4).getCell(2).getStringCellValue();
	    String  INDUSTRYNAME = wb.getSheet("Organisation").getRow(4).getCell(3).getStringCellValue();
        WebDriver driver = null ;
	    
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
	
	    driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin",Keys.TAB,"admin",Keys.ENTER);
	   
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(ORGANISATIONNAME);
	    WebElement industry = driver.findElement(By.name("industry"));
	    industry.click();
	    Thread.sleep(1000);
	    Select sel = new Select(industry);
	    sel.selectByVisibleText(INDUSTRYNAME);
	    
	    driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
	    
	    String organizationHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	    if(organizationHeader.contains(ORGANISATIONNAME))
	    {
	    	System.out.println("organizationHeader");
	    	System.out.println("pass");
	   }
	    else
	    {
	    	System.out.println("fail");
	    }
	     WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	     
	     Actions act = new Actions(driver);
	     act.moveToElement(ele).perform();
	     Thread.sleep(1000);
	     driver.findElement(By.xpath("//a[.='Sign Out']")).click();
	}

}
