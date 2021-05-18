package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.MyAccountPage;
import Pages.UserRegistrationPage;


public class MyAccountTest extends TestBase
{
	HomePage homeObject ; 
	UserRegistrationPage registerObject ; 
	LoginPage loginObject ; 
	MyAccountPage myAccountObject ; 
	String oldPassword = "12345678" ; 
	String newPassword = "123456789000" ; 
	String firstName = "Moataz" ; 
	String lastName = "Nabil" ; 
	String email = "testn@gmail.com" ; 
	

	@Test(priority=1)
	public void UserCanRegisterSuccssfully() 
	{
		homeObject = new HomePage(driver); 
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver); 
		registerObject.userRegistration(firstName, lastName, email, oldPassword);
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
	}
	
	@Test(priority=2)
	public void RegisteredUserCanChangePassword() 
	{
		myAccountObject = new MyAccountPage(driver) ; 
		registerObject.openMyAccountPage();
		myAccountObject.openChangePasswordPage();
		myAccountObject.ChangePassword(oldPassword, oldPassword);
		Assert.assertTrue(myAccountObject.resultLbl.getText().contains("Password was changed"));
	}
	
	@Test(priority=3)
	public void RegisteredUserCanLogout() 
	{
		registerObject.userLogout();
	}
	
	@Test(priority=4)
	public void RegisteredUserCanLogin() 
	{
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver); 
		loginObject.UserLogin(email, oldPassword);
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
	}
	
	@Test(priority=5)
	public void UserLogout() 
	{
		registerObject.userLogout();
	}
	
}
