package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilities.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility {
 
	






   
	
	
	@FindBy(name = "lastname")
	private WebElement LastNameEdt;
	
	@FindBy(xpath = "(//img[@alt='Select'])[1]")
	private WebElement OrganisationLookUpImage;
	
	@FindBy(name = "search_text")
	private WebElement OrganisationSearchEdT;
	
	@FindBy(name = "search")
	private WebElement OrganisationSearchBtn;
	
    @FindBy(xpath = "//input[@value='  Save  ']")
    private WebElement SaveBtn;
    
	@FindBy(xpath = "//input[@value='Cancel  ']")
    private WebElement CancelBtn;
	
	public CreateNewContactPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
    
    public WebElement getLastNameEdt() {
		return LastNameEdt;
	}

	public WebElement getOrganisationLookUpImage() {
		return OrganisationLookUpImage;
	}

	public WebElement getOrganisationSearchEDT() {
		return OrganisationSearchEdT;
	}

	public WebElement getOrganisationSearchBtn() {
		return OrganisationSearchBtn;
	}

   public WebElement getSaveBtn() {
		return SaveBtn;
	}

/**
 * this method will create contact with mandatory fields
 * @param LASTNAME
 */

	public void createNewContact(String LASTNAME) 
	{
		LastNameEdt.sendKeys(LASTNAME);
		SaveBtn.click();
		
	}
/**
 * This method will create contact by choosing the organisation
 * @param ORGANISATIONNAME
 * @param LASTNAME
 * @param driver
 */
	
	
	public void createNewContact(String ORGANISATIONNAME, String LASTNAME, WebDriver driver) 
	{
		LastNameEdt.sendKeys(LASTNAME);
		OrganisationLookUpImage.click();
	    switchToWindow(driver, "Accounts");
	    OrganisationSearchEdT.sendKeys(ORGANISATIONNAME);
	    OrganisationSearchBtn.click();
	    driver.findElement(By.xpath("//a[.='"+ORGANISATIONNAME+"']")).click();
	    switchToWindow(driver, "contacts");
	    SaveBtn.click();
	    
	    
	
	}

}
