package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

//declaration
	@FindBy(name = "user_name")
	private WebElement userNameEdt;
	
	@FindBy(name = "user_password")
	private WebElement userPasswordEdt;
	
	@FindBy(id = "submitButton")
	private WebElement Login;
	
	//Utilisatio
	

	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getUserPasswordEdt() {
	
	return userPasswordEdt;
	}
	public WebElement getLogin() {
		return Login;
	}

	public void LoginToApp(String USERNAME, String PASSWORD) 
	{
		userNameEdt.sendKeys(USERNAME);
		userPasswordEdt.sendKeys(PASSWORD);
		Login.click();
	}

	
	
}