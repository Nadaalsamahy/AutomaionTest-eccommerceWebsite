 package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.LogOutPage;
import Pages.LoginPage;
import Pages.UserRegistrationPage;

public class UserRegisterationTest extends TestBase
{
	
	UserRegistrationPage registerObject ; 
	LoginPage loginObject ; 
	LogOutPage logoutObject;
	String firstName = "Nada";
	String lastName = "Alsamahy";
	String phone = "01020080467";
	String email = "mariam1111@gmail.com";
	String password = "Nada123456!";
	
	
	@Test(priority=1,alwaysRun=true)
	public void UserCanRegisterSuccssfully()  
	{
		
		registerObject = new UserRegistrationPage(driver); 
		registerObject.userRegistration(firstName, lastName, phone,email ,password);
		Assert.assertTrue(registerObject.registerSuccessMessage.getText().contains("Hi"));
	}
	

	@Test
	(dependsOnMethods= {"UserCanRegisterSuccssfully"})
	public void UserCanLogOutSuccssfully () throws InterruptedException {

		logoutObject = new LogOutPage(driver);
		Thread.sleep(2000);
		logoutObject.openLogoutPage();
		Assert.assertTrue(logoutObject.logoutSuccessMessage.getText().contains("Login"));

		
	}
	
	
	@Test
	(dependsOnMethods= {"UserCanLogOutSuccssfully"})
	
	public void RegisteredUserCanLogin() 
	{
		loginObject = new LoginPage(driver); 
		//loginObject.openLoginPage();
		loginObject.UserLogin(email, password);
		Assert.assertTrue(loginObject.loginSuccessMessage.getText().contains("Hi"));
	//}
}}