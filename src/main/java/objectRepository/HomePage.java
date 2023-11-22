package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility {
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
  @FindBy(linkText = "Contacts")
  private WebElement contactlinkEdt;
  
  @FindBy(linkText = "Organizations")
  private WebElement organizationslinkEdt;
  
  @FindBy(linkText = "Products")
  private WebElement productlinkEdt;
  
  @FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
  private WebElement AdminstrationimageEdt;
  
  @FindBy(xpath = "//a[.='Sign Out']")
  private WebElement SignoutBtn;


  
 public WebElement getContactlinkEdt() {
	return contactlinkEdt;
}

public WebElement getOrganizationsEdt() {
	return organizationslinkEdt;
}

public WebElement getProductsEdt() {
	return productlinkEdt;
}


public WebElement getAdminstrationimageEdt() {
	return AdminstrationimageEdt;
}

public WebElement getSignoutBtn() {
	return SignoutBtn;
}
/**
 * this method will click on organisations link
 */
public void clickOnOrganizationsLink() 
{
	organizationslinkEdt.click();
}
/**
 * this method will click on contact link
 * 
 */
public void clickOncontactLink()
{
	contactlinkEdt.click();
}
/**
 * this method will click on products link
 *
 */
public void clickOnproductsLink()
{
	productlinkEdt.click();
}
/**
 * 
 * this method will log out the application
 * @param driver
 * @throws InterruptedException
 */

public void logoutApp(WebDriver driver) throws InterruptedException 
{
	mouseHoverAction(driver, AdminstrationimageEdt);
	Thread.sleep(1000);
	SignoutBtn.click();
}
}
