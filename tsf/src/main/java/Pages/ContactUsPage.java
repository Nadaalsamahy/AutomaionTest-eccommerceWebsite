package Pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Pages.PageBase;

public class ContactUsPage extends PageBase{

	public ContactUsPage(WebDriver driver) {
		super(driver);
		
		
		// TODO Auto-generated constructor stub
	}
	@FindBy(id = "FullName")
	WebElement fullNameText;
	
	@FindBy(id = "Email")
	WebElement emailText;
	
	@FindBy(id = "Enquiry")
	WebElement enquiryNameText;
	
	@FindBy(name = "send-email")
	WebElement submitBtn;
	

	@FindBy(css = "div.result")
	public WebElement sucssessMessage;
	
	public void contactUs(String fullName , String email, String message ) {
		
		setTextElementText(fullNameText, fullName);
		setTextElementText(emailText, email);
		setTextElementText(enquiryNameText, message);
		clickButton(submitBtn);
	}
	
	

}
