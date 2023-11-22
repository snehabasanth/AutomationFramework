package Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

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

import io.github.bonigarcia.wdm.WebDriverManager;

public class Senario5WithDDT {

	public static void main(String[] args) throws IOException, InterruptedException {
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
	    String LASTNAME = wb.getSheet("Contacts").getRow(1).getCell(2).getStringCellValue();
	    String  ORGANISATIONNAME = wb.getSheet("Organisation").getRow(7).getCell(2).getStringCellValue();
	    String  INDUSTRYNAME = wb.getSheet("Organisation").getRow(7).getCell(3).getStringCellValue();
        String  TYPENAME = wb.getSheet("Organisation").getRow(7).getCell(4).getStringCellValue();
	    
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
		 
driver.findElement(By.linkText("Contacts")).click();
		
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		  
		  
	    driver.findElement(By.name("lastname")).sendKeys("Murulidhar");
	    driver.findElement(By.xpath("(//img[@title='Select'])[1]")).click();
	    
	  Thread.sleep(2000);
	  String mainwindowID = driver.getWindowHandle();
	  System.out.println("mainwindowID");
	  Set<String> allwindowIDs = driver.getWindowHandles();
	  
	  for(String winID: allwindowIDs)
	  {
		  if(!winID.equals(mainwindowID))
		  {
			  System.out.println(winID +" --child window ID");
			  driver.switchTo().window(winID);
			  System.out.println("Switched to child");
			  break;
		  } 
	  }      
		      driver.findElement(By.name("search_text")).sendKeys("Informatics");
		      driver.findElement(By.name("search")).click();
			  driver.findElement(By.xpath("//a[.='Informatics']")).click();
		
	  
	  driver.switchTo().window(mainwindowID);
	  System.out.println("Switched  back to parent");
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//input[@value='  Save  ']")).click();

	  WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	     
	     Actions act = new Actions(driver);
	     act.moveToElement(ele).perform();
	     Thread.sleep(1000);
	     driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		
	}

}
