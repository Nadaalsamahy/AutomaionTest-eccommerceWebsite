package Pages;

import java.security.PublicKey;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageBase {

	public SearchPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(id = "small-searchterms")
	WebElement searchTextBox;
	@FindBy(xpath  = "/html/body/div[6]/div[1]/div[2]/div[2]/form/button")
	WebElement searchbtn;
	
	@FindBy(id = "ui-id-1")
	List<WebElement> productList ;
	
	@FindBy(linkText  = "Apple MacBook Pro 13-inch")
	public WebElement productTitle;
	
	public void productSearch(String productName) {
		
		setTextElementText(searchTextBox, productName);
		clickButton(searchbtn);
	}
	
	public void openProductItemDetailsPage() {
		
		clickButton(productTitle);
	}
	public void ProductNameAutoSuggest(String searchtxt) {
		
		setTextElementText(searchTextBox, searchtxt);

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		productList.get(0).click();
		productList.get(0).click();


		
	}

}
