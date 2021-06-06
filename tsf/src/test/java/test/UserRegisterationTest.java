package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegistrationPage;

public class UserRegisterationTest extends TestBase
{
	HomePage homeObject ; 
	UserRegistrationPage registerObject ; 
	LoginPage loginObject ; 
	String mail = "testing12@gmail.com";
	String password ="123456";
	@Test(priority=1,alwaysRun=true)
	public void UserCanRegisterSuccssfully() 
	{
		homeObject = new HomePage(driver); 
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver); 
		registerObject.userRegistration("Moataz", "Nabil", mail, password);
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
	}

	@Test(dependsOnMethods= {"UserCanRegisterSuccssfully"})
	public void RegisteredUserCanLogout() 
	{
		registerObject.userLogout();
	}

	@Test(dependsOnMethods= {"RegisteredUserCanLogout"})
	public void RegisteredUserCanLogin() 
	{
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver); 
		loginObject.UserLogin(mail, password);
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
	}
}