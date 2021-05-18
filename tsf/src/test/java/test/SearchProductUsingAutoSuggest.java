package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.ProductDetailsPage;
import Pages.SearchPage;

public class SearchProductUsingAutoSuggest extends TestBase {

	String productName = "Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	
	@Test
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
}
