package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase {

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(css = "strong.current-item")
	public WebElement productNameBreadCrumb;
	@FindBy(css ="input.button-2.email-a-friend-button")
	WebElement emailFriendBtn;
	
	
	public void openSendEmail() {
		
		clickButton(emailFriendBtn);
	}
	
	
}
