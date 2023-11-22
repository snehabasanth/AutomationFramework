package Practice2;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Senario5 {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
     
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin",Keys.TAB,"admin",Keys.ENTER);
		
		//driver.findElement(By.xpath("//a[.='Contacts']")).click();
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
