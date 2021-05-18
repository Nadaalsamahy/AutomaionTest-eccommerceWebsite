package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import uilities.Helper;

public class TestBase {
	public static WebDriver driver;
	//FirefoxDriver driver;
	String fireFoxPath= "/home/nadaeewa/Downloads/geckodriver-v0.29.0-linux64/geckodriver/";

	@BeforeSuite
	@Parameters({"browser"})
	public void startDriver(@Optional("Firefox") String browserName) {

		if(browserName.equalsIgnoreCase("Firefox")) {

			System.setProperty("webdriver.gecko.driver", fireFoxPath);
			driver = new FirefoxDriver();

			driver.navigate().to("https://demo.nopcommerce.com/");


		}




	}
	//@AfterSuite
	//public void stopDriver() {

		//driver.quit();
	//}

	@AfterMethod
	public void screenShotOnFailure(ITestResult result) {

		if(	result.getStatus() == ITestResult.FAILURE)
		{
			System.out.println("Failed");
			System.out.println("Taking Screenshot");
			Helper.captureScreenShot(driver, result.getName());
		}
		// TODO Auto-generated method stub

	}
}
