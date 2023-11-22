package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationPageInfo {
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
    private WebElement OrganizationHeaderText;
	
	public OrganisationPageInfo (WebDriver driver)
	{
	   PageFactory.initElements(driver, this);
	}
	
	public WebElement getOrganizationHeaderText() 
	{
		return OrganizationHeaderText;
	}
	
     public String getOrganizationHeader()
    {
	return OrganizationHeaderText.getText();
    }
}
