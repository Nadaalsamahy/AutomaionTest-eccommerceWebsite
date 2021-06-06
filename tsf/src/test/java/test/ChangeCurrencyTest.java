package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.ProductDetailsPage;
import Pages.SearchPage;

public class ChangeCurrencyTest extends TestBase {

	HomePage homeObject;
	ProductDetailsPage detailesObject;
	String productName = "Apple MacBook Pro 13-inch" ;
	SearchPage searchObject;
	ProductDetailsPage detailsObject;

	
	@Test(priority = 1)
	public void UserCanChangeCurrency() {
		
		homeObject = new HomePage(driver);
		homeObject.changeCurrency();	
		detailesObject = new ProductDetailsPage(driver);
		
	}
	@Test(priority = 2)

	public void userCanSearchWithAutoSuggest() {
		try {
			searchObject = new SearchPage(driver);
			searchObject.ProductNameAutoSuggest("MacB");
			detailsObject = new ProductDetailsPage(driver);
			
			Assert.assertEquals(detailsObject.productNameBreadCrumb.getText(),productName );
			Assert.assertTrue(detailesObject.productPricelbl.getText().contains("€"));
			System.out.println(detailesObject.productPricelbl.getText());

		} catch (Exception e) {

			System.out.println("error occured " + e.getMessage());
		
		}
}}
