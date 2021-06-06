package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase {

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
		jse =  (JavascriptExecutor)driver;
		action = new Actions(driver); 
	}
	

	@FindBy(css = "strong.current-item")
	public WebElement productNameBreadCrumb;
	@FindBy(xpath  ="/html/body/div[6]/div[3]/div/div[2]/div/div/form/div[2]/div[1]/div[2]/div[10]/div[3]/button")
	WebElement emailFriendBtn;
	
	@FindBy(id ="add-to-cart-button-4")
	WebElement cardBtn;

	@FindBy(css="price-value-4")
	public WebElement productPricelbl;
	
	@FindBy(linkText = "Add your review")
	WebElement addReviewLink;
	@FindBy(id = "add-to-wishlist-button-4")
	WebElement addToWishListBtn;
	
	@FindBy(linkText = "wishlist")
	WebElement 	wishlistLink;
	@FindBy(css = "input.button-2.add-to-compare-list-button")
	WebElement 	addToCompareBtn;
	
	@FindBy(id = "	add-to-cart-button-4\n")
			
	WebElement 	addToCartBtn;
	
	public void openSendEmail() {
		scrollTomiddele();
		clickButton(emailFriendBtn);
	}

	public void openAdReviewPage() {
		scrollToBottom();
		clickButton(addReviewLink);
	}
	public void addProductToWishList() {
		scrollTomiddele();
		clickButton(addToWishListBtn);
	}
	
	public void AddProductToCompare() {
		scrollTomiddele();

		clickButton(addToCompareBtn);
	}
	
	public void AddToCard() {
		scrollTomiddele();

		clickButton(addToCartBtn);
	}
	

	
}
