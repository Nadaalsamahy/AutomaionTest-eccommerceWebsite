
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.ComparePage;
import Pages.HomePage;
import Pages.ProductDetailsPage;
import Pages.SearchPage;
import test.TestBase;

public class AddProductToCompareTest extends TestBase {

	String firstProductName = "Apple MacBook Pro 13-inch";
	String secondProductName = "Asus N551JK-XO076H Laptop";
	//1-search product number1
	//2-search product number2
	//3-Add to compare
	//4-clear list
	ProductDetailsPage detailsObject;
	HomePage hopmeObject;
	SearchPage serchObject;
	ComparePage compareObject ;
	
	@Test(priority = 1)
		public void UserCanCompareProducts() throws InterruptedException {
			serchObject = new SearchPage(driver);
			detailsObject = new ProductDetailsPage(driver);
			compareObject = new ComparePage(driver);

			serchObject.ProductNameAutoSuggest("MacB");
			//Assert.assertTrue(detailsObject.productNameBreadCrumb.getText().contains(firstProductName));
            detailsObject.openSendEmail();
			detailsObject.AddProductToCompare();

			serchObject.ProductNameAutoSuggest("Asus");
			Assert.assertTrue(detailsObject.productNameBreadCrumb.getText().contains(secondProductName));
			
			detailsObject.AddProductToCompare();
			Thread.sleep(1000);

			driver.navigate().to("http://demo.nopcommerce.com" + "/compareproducts");
			Assert.assertTrue(compareObject.firstProductName.getText().equals("Asus N551JK-XO076H Laptop"));
			Assert.assertTrue(compareObject.secodProductName.getText().equals("Apple MacBook Pro 13-inch"));
			compareObject.compareProducts();
		
	}
	@Test(priority = 2)
	public void userCanClearComparList(){
		compareObject.clearCompareList();
	}
}
