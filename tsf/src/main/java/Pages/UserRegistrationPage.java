package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class UserRegistrationPage extends PageBase 
{
	public UserRegistrationPage(WebDriver driver) {
		super(driver);
		jse = (JavascriptExecutor) driver; 
		action = new Actions(driver); 

	}





	@FindBy(name="firstname")
	WebElement fnTxtBox; 

	@FindBy(name="lastname")
	WebElement lnTxtBox ; 

	@FindBy(name ="phone")
	WebElement phoneTxtBox ; 

	@FindBy(name ="email")
	WebElement emailTxtBox ; 

	@FindBy(name="password")
	WebElement passwordTxtBox ; 

	@FindBy(name="confirmpassword")
	WebElement confirmPasswordTxtBox ; 


	@FindBy(xpath  ="/html/body/div[2]/div[1]/section/div/div/div[2]/div/form/div[8]/button")
	WebElement registerBtn ; 



	@FindBy(css  ="h3.text-align-left")
	public WebElement registerSuccessMessage ; 

	



	public void userRegistration(String firstName , String lastName ,String phone, String email , String password ) 
	{
		setTextElementText(fnTxtBox, firstName);
		setTextElementText(lnTxtBox, lastName);
		setTextElementText(emailTxtBox, email);
		setTextElementText(phoneTxtBox, phone);

		setTextElementText(passwordTxtBox, password);
		setTextElementText(confirmPasswordTxtBox, password);
		scrollToBottom();
	   clickButton(registerBtn);

	}
	

	



}





