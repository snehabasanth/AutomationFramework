package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationPage {
	
	public OrganisationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
    
	
	
	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement CreateOrganisationLookUpImage;
	
	
	

	

	public WebElement getCreateOrganisationEdt() {
		return CreateOrganisationLookUpImage;
	}

public void clickOnCreateOrganisationLookUpImage() {
	 CreateOrganisationLookUpImage.click();
}
}
	

