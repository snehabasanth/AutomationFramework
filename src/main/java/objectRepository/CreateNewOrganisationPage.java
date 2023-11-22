package objectRepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilities.WebDriverUtility;

public class CreateNewOrganisationPage extends WebDriverUtility {
 
	

    @FindBy(name = "accountname")
	private WebElement OrganisationNameEdt;
    
    @FindBy(name = "industry")
    private WebElement IndustryDropDown;
    
    @FindBy(name = "accounttype")
    private WebElement TypeDropDown;
    
    @FindBy(xpath = "//input[@value='  Save  ']")
    private WebElement SaveBtn;
   
    public CreateNewOrganisationPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
    }
     public WebElement getOrganisationNameEdt() 
     {
	  return OrganisationNameEdt;
     }
     public WebElement getIndustryDropDown() 
	{
	return IndustryDropDown;
    }
    public WebElement getTypeDropDown() 
    {
	return TypeDropDown;
    }
public WebElement getSaveBtn() {
	return SaveBtn;
}
	public void CreateNewOrganization(String ORGNAME) {
		OrganisationNameEdt.sendKeys(ORGNAME);
	    SaveBtn.click();
	}
	
  public void CreateNewOrganization(String ORGNAME, String INDUSTRYNAME)
  {
	  OrganisationNameEdt.sendKeys(ORGNAME);
	  handleDropdown(IndustryDropDown, INDUSTRYNAME);
	  SaveBtn.click();
  }
  public void CreateNewOrganization1(String ORGNAME, String INDUSTRYNAME, String TYPE) 
  {
	  OrganisationNameEdt.sendKeys(ORGNAME);
	  handleDropdown(IndustryDropDown, INDUSTRYNAME);
	  handleDropdown(TypeDropDown, TYPE);
      SaveBtn.click();
}
}

