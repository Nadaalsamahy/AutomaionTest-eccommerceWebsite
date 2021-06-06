package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.ProductDetailsPage;
import Pages.SearchPage;
import Pages.WishListPage;

public class AddProductToWishLisTest extends TestBase {
	SearchPage searchPage;
	ProductDetailsPage productDetails;
	WishListPage wishlistObject;
	String productName = "Apple MacBook Pro 13-inch";

	@Test(priority=1)
	public void UserCanSearchForProductsWithAutoSuggest() throws InterruptedException {
		searchPage = new SearchPage(driver);
		searchPage.ProductNameAutoSuggest("MacB");
		productDetails = new ProductDetailsPage(driver);
		//Assert.assertTrue(productDetails.productNameBreadCrumb.getText().contains(productName));
	}

	@Test(priority=2)
	public void UserCanAddProductToWishlist() throws InterruptedException {
		productDetails = new ProductDetailsPage(driver);
		productDetails.addProductToWishList();
		//driver.navigate().to("http://demo.nopcommerce.com" + "/wishlist");
		wishlistObject = new WishListPage(driver); 
		//Assert.assertTrue(wishlistObject.wishListAssertion.getText().contains("wishlist"));
		//Assert.assertTrue(wishlistObject.productCell.getText().contains(productName));
	}

	
}
