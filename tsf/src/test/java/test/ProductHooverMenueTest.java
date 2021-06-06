package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;

public class ProductHooverMenueTest extends TestBase {

	HomePage homeObject;
	@Test
	private void UserCanSelectSubCategoryFromMainMenue() {
		
		homeObject = new HomePage(driver);
		homeObject.selectNotebooksMenu();
		//Assert.assertTrue(driver.getCurrentUrl().contains("notebooks"));
		
	}
}
