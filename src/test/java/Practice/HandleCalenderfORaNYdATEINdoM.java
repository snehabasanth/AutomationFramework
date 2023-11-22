package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;



public class HandleCalenderfORaNYdATEINdoM {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
     
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 
		driver.get("https://www.makemytrip.com/");
       
		Thread.sleep(1000);
		
		Actions act = new Actions(driver);
		act.moveByOffset(10, 10).click().perform();
		
		
		
		driver.findElement(By.name("//input[@data-cy='departure']")).click();


	}

}
