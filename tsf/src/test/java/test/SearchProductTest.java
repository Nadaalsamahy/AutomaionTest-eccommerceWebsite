package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.ProductDetailsPage;
import Pages.SearchPage;

public class SearchProductTest extends TestBase {

	String productName = "Apple MacBook Pro 13-inch" ;
			
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	
	
	
	@Test
	public void userCanSearchForProducts() {
		searchObject = new SearchPage(driver);
		detailsObject = new ProductDetailsPage(driver);
		searchObject.productSearch(productName);
		searchObject.openProductItemDetailsPage();
		Assert.assertTrue(detailsObject.productNameBreadCrumb.getText().equalsIgnoreCase(productName ));
	}
}
