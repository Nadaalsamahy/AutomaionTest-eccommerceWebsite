package test;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import uilities.Helper;

public class TestBase {
	public static WebDriver driver;
	
	//FirefoxDriver driver
	String fireFoxPath= "/home/nadaeewa/Downloads/geckodriver-v0.29.0-linux64/geckodriver/";
	//GoogleChrome driver 
	String googlechromepath = "/home/nadaeewa/Downloads/chromedriver_linux64/chromedriver/";
	
	

	
	@BeforeSuite
	
	@Parameters({"browser"})
	public void startDriver(@Optional("firefox") String browserName) {

		if(browserName.equalsIgnoreCase("firefox")) {

			System.setProperty("webdriver.gecko.driver", fireFoxPath);
			driver = new FirefoxDriver();
		}else if (browserName.equalsIgnoreCase("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", googlechromepath);
			
			driver = new ChromeDriver(); 
		}
		else if (browserName.equalsIgnoreCase("safari")) {
			driver = new SafariDriver(); 
		}

			driver.navigate().to("https://www.phptravels.net/register/en");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		}




	
	//@AfterSuite
	//public void stopDriver() {

	//	driver.quit();
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
