package Practice2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Senario1 {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
     
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin",Keys.TAB,"admin",Keys.ENTER);
		
		//driver.findElement(By.xpath("//a[.='Contacts']")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("Wipro");
		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
		
		
	   String organizationHeader =driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	   if(organizationHeader.contains("Informatics"))
	    {
	    	System.out.println("organizationHeader");
	    	System.out.println("pass");
	   }
	    else
	    {
	    	System.out.println("fail");
	    }

	WebElement  ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	
	Actions act = new Actions(driver);
    act.moveToElement(ele).perform();
    Thread.sleep(1000);
    driver.findElement(By.xpath("//a[.='Sign Out']")).click();
	}

}
