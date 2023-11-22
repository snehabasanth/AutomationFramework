package GenericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/** 
 * This class consists of all generic  methods related to WebDriver action
 * @author Sneha
 * 
 */
public class WebDriverUtility {
private WebDriver driver;
/** 
 * this method will maximize the window
 * @param driver
 */
	
 public void maximizeWindow(WebDriver driver)
	{
	  driver.manage().window().maximize();
	}
	/** 
	 * this method will minimize the window
	 * @param driver
	 */
public void minimizeWindow(WebDriver driver)
		{
		  driver.manage().window().minimize();
		}
	/**
	 * This method will wait for 10 seconds for the web page to get loaded 
	 * @param driver
	 */

public void waitForPageLoad(WebDriver driver)
{
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}
/**
 * This method will wait wait 10seconds for element to be visible
 * @param driver
 * @param element
 */
public void waitForElementToBeVisible(WebDriver driver, WebElement element)
{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.visibilityOf(element));
}
/**
 * This method will wait wait 10 seconds for element to be clickable
 * @param driver
 * @param element
 */
public void waitForElementToBeClickable(WebDriver driver, WebElement element)
{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.elementToBeClickable(element));
}
/**
 * This method will perform handle drop-down by value
 * @param element
 * @param value
 */
public void handleDropdown(WebElement element, String value)
{
	Select sel = new Select(element);
	sel.selectByValue(value);
}
/**
 * This method will perform handle drop-down by index
 * 
 * @param element
 * @param index
 */
public void handleDropdown(WebElement element, int index)
{
	Select sel = new Select(element);
	sel.selectByIndex(index);
}
/**
 * This method will perform handle drop-down by text
 *@param text
 */
public void handleDropdown(String text, WebElement element) 
{
	Select sel = new Select(element);
	sel.selectByVisibleText(text);
}
/**
 * This method will perform mouse hovering action
 * @param driver
 * @param element
 */
public void mouseHoverAction(WebDriver driver, WebElement element) 
{
	Actions act = new Actions(driver);
	act.moveToElement(element).perform();
}
/**
 * This method will perform double click action on web element
 * @param driver
 * @param element
 */
public void doubleClickAction(WebDriver driver, WebElement element) 
{
	Actions act = new Actions(driver);
	act.doubleClick(element).perform();
}
/**
 * this method will perform right click action on web element
 * @param driver
 * @param element
 */
public void rightClickAction(WebDriver driver, WebElement element) 
{
	Actions act = new Actions(driver);
	act.contextClick(element).perform();
}
/**
 * This method will drag and drop the src element to target element
 * @param driver
 * @param srcEle
 * @param targetEle
 */
public void dragAndDropAction(WebDriver driver, WebElement srcEle, WebElement targetEle) 
{
	Actions act = new Actions(driver);
	act.dragAndDrop(srcEle, targetEle).perform();
}
/**
 * This method will click and hold on to particular web element
 * @param driver
 * @param element
 */
public void clickAndHoldAction(WebDriver driver, WebElement element) 
{
	Actions act = new Actions(driver);
	act.clickAndHold(element).perform();	
}
/**
 * This method will scroll down for 500units
 * @param driver
 */
public void ScrollDownAction(WebDriver driver)
{
	JavascriptExecutor js =(JavascriptExecutor) driver;
	js.executeAsyncScript("window.scrollbBy(500,0);", "");
}
/**
 *This method will scroll up for 500units 
 * @param driver
 */
public void ScrollUpAction(WebDriver driver)
{
	JavascriptExecutor js =(JavascriptExecutor) driver;
	js.executeScript("window.scrollbBy(0,-500);", "");
}
/**
 * This method will scroll right for 500units
 * @param driver
 */
public void ScrollRightAction(WebDriver driver)
{
	JavascriptExecutor js =(JavascriptExecutor) driver;
	js.executeScript("window.scrollbBy(500,0);", "");
}
/**
 * This method will scroll left for 500units
 * @param driver
 */
public void ScrollLeftAction(WebDriver driver)
{
	JavascriptExecutor js =(JavascriptExecutor) driver;
	js.executeScript("window.scrollbBy(-500,0);", "");
}
/**
 * This method will accept the alert popup
 * @param driver
 */
public void acceptAlert(WebDriver driver)
{
	driver.switchTo().alert().accept();
}
/**
 * This method will cancel the alert popup
 * @param driver
 */
public void cancelAlert(WebDriver driver)
{
	driver.switchTo().alert().dismiss();
}
/** 
 * This method will capture the alert text and return to caller
 * @param driver
 */
public String getAlertText(WebDriver driver)
{
	String text = driver.switchTo().alert().getText();
    return text;
}
/**
 * This method will switch to frame base on index
 * @param driver
 * @param index
 */

public void switchToFrame(WebDriver driver, int index)
{
	driver.switchTo().frame(index);
}
/**
 * This method will switch to frame base on nameorID
 * @param driver
 * @param nameOrID
 */

public void switchToFrame(WebDriver driver, String nameOrID)
{
	driver.switchTo().frame(nameOrID);
}
/**
 * This method will switch to frame base on WebElement
 * @param driver
 * @param element
 */
public void switchToFrame(WebDriver driver, WebElement element)
{
	driver.switchTo().frame(element);
}
/**
 * This method will switch to window based on partial with title
 * @param driver
 * @param partialWindowTitle
 */
public void switchToWindow(WebDriver driver, String  partialWindowTitle)
{
	//Step 1: Capture all the window IDs
	Set<String> allWindowsIDs = driver.getWindowHandles(); //main/child/child

	//Step 2: Navigate through each Window ID
	for(String windowID:allWindowsIDs)
	{
		//Step 3: switch to each window capture the title
	String actTitle	= driver.switchTo().window(windowID).getTitle();
		
		
		//Step 4: compare the title with expected partial window Title
		if(actTitle.contains(partialWindowTitle))
		{
			break;
		}
	}
}
/**
 * This method will take screen shot and store it in required folder
 * @param driver
 * @param sreenShotName
 * @return
 * @throws IOException
 */
public String captureScreenShot(WebDriver driver,  String sreenShotName) throws IOException
{
	TakesScreenshot ts = (TakesScreenshot) driver;
	File src = ts.getScreenshotAs(OutputType.FILE);
	File dst = new File(".\\ScreenShots\\"+sreenShotName+".png");
	
	Files.copy(src, dst);//crct
	return dst.getAbsolutePath();// complete path of screenshot - extents report
 }
}



