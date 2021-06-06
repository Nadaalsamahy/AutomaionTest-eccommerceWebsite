package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.EmailPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProductDetailsPage;
import Pages.ProductReviewPage;
import Pages.SearchPage;
import Pages.UserRegistrationPage;

public class AddProductReviewTest extends TestBase {

	/* 1-user registeration
	 * 2-search for product
	 * 3-add review 
	 * 4-logout
	 * 
	 */
	HomePage homeObject ; 
	UserRegistrationPage registerObject ; 
	LoginPage loginObject ; 
	
	String productName = "Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	ProductReviewPage reviewObject;

	// 1- userRegisteration 
	@Test(priority=1,alwaysRun=true)
	public void UserCanRegisterSuccssfully() 
	{
		homeObject = new HomePage(driver); 
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver); 
		registerObject.userRegistration("Moataz", "Nabil", "tasnim12345@gmail.com", "12345678");
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
	}
	
	//2 search for product 
	@Test(priority = 2)
	public void userCanSearchWithAutoSuggest() {
		try {
			searchObject = new SearchPage(driver);
			searchObject.ProductNameAutoSuggest("MacB");
			detailsObject = new ProductDetailsPage(driver);
			
			Assert.assertEquals(detailsObject.productNameBreadCrumb.getText(),productName );

		} catch (Exception e) {

			System.out.println("error occured " + e.getMessage());
		}
		
	}
	 //3 Add review
	@Test(priority = 3)
	public void RegisteredUserCanReviewProduct() {
		detailsObject = new ProductDetailsPage(driver);
		detailsObject.openAdReviewPage();
		reviewObject = new ProductReviewPage(driver);
		reviewObject.AddProductReview("new review message", "the product is very good");
		Assert.assertTrue(reviewObject.reviewNotification.getText()
				.contains("Product review is successfully added."));
	}
	
	//4- user logout
		@Test(priority = 4)
		public void RegisteredUserCanLogout() 
		{
			registerObject.userLogout();
		}
}
