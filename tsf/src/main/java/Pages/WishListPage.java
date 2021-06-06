package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage extends PageBase {

	public WishListPage(WebDriver driver) {
		super(driver);

	}
	
	@FindBy(linkText = "apple-macbook-pro-13-inch" )
    public WebElement productCell;
   
	@FindBy(css = "div.bar-notification.success")
    public WebElement wishListAssertion;
    @FindBy(css = "h1")
    public WebElement wishlistHeader;
   
    @FindBy(name = "updatecart")
    private WebElement updateWishlistBtn;
    
    @FindBy(name = "removefromcart")
    private WebElement removefromCartCheck;
   
    @FindBy(css = "div.no-data")
    public WebElement EmptyCartLbl;
   
    public void removeProductFromWishlist() {
        clickButton(removefromCartCheck);
        clickButton(updateWishlistBtn);
    }
}


