package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.EmailPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.PageBase;
import Pages.ProductDetailsPage;
import Pages.SearchPage;
import Pages.UserRegistrationPage;

public class EmailFriendTest extends TestBase {

	
	HomePage homeObject ; 
	UserRegistrationPage registerObject ; 
	LoginPage loginObject ; 
	
	String productName = "Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	EmailPage emailObject;
	// 1- userRegisteration 
	@Test(priority=1,alwaysRun=true)
	public void UserCanRegisterSuccssfully() 
	{
		homeObject = new HomePage(driver); 
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver); 
		registerObject.userRegistration("Moataz", "Nabil", "testnadatalaat@gmail.com", "12345678");
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
	//3- email to friend
	
	@Test(priority = 3)
	public void RegisteredUserCanSendProductToFriend() {
		
		detailsObject.openSendEmail();
		emailObject = new EmailPage(driver);
		emailObject.sendEmailToFriend("aaa@test.com", "hello my friend , check this product");
		//Assert.assertTrue(emailObject.messageNotification.getText().contains("Your message has been sent "));
	}
	
	//4- user logout
	@Test(priority = 4)
	public void RegisteredUserCanLogout() 
	{
		registerObject.userLogout();
	}
	

}
