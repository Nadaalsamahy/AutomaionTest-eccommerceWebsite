package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase
{
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath  = "/html/body/div[2]/header/div[1]/div/div/div[2]/div/ul/li[3]/div")
	WebElement loginDropDown;
	
	@FindBy(linkText = "Login")
	WebElement loginLink ;
	
	@FindBy(name="username")
	WebElement emailTxtBox ; 

	@FindBy(name="password")
	WebElement passwordTxtBox ; 

	@FindBy(xpath = "/html/body/div[2]/div[1]/section/div/div[1]/div[2]/form/button")
	WebElement loginBtn ; 
	

	@FindBy(css ="h3.text-align-left")
	public WebElement loginSuccessMessage ; 
	public void openLoginPage() {
		
		clickButton(loginDropDown);
		clickButton(loginLink);
		
	}
	public void UserLogin(String email , String password) 
	{
		
		setTextElementText(emailTxtBox, email);
		setTextElementText(passwordTxtBox, password);
		clickButton(loginBtn);
	}

}
