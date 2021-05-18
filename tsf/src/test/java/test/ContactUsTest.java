package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.ContactUsPage;
import Pages.HomePage;


public class ContactUsTest extends TestBase{

	HomePage home;
	ContactUsPage contactPage;
	
	String email= "test@test.com";
	String fullName= "test User";
	String enquiry = "hello admin , it's for test";
	
	@Test
	public void userCanUseContactUs() {
		home = new HomePage(driver);
		home.openContactUsPage();
		contactPage = new ContactUsPage(driver);
		contactPage.contactUs(fullName, email, enquiry);
		Assert.assertTrue(contactPage.sucssessMessage.getText().contains(" Your enquiry has been successfully sent to the store owner. "));

	}
	
	
	
	

}
	
	


