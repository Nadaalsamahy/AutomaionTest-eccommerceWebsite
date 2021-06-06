package Pages;

import java.util.List;

import javax.print.attribute.standard.Fidelity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComparePage extends PageBase {

	public ComparePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css="table.compare-products-table")
	WebElement compareTble;

	@FindBy(tagName = "tr")
	 List<WebElement> allRows;

	@FindBy(tagName = "td")
	 List<WebElement> allCouloms;
	@FindBy(css="a.clear-list")
	WebElement clearListLink;
	@FindBy(css = "div.no-data")
	public WebElement noDattalbl;
    @FindBy(linkText="Asus N551JK-XO076H Laptop")
    public WebElement firstProductName; 
    
    @FindBy(linkText="Apple MacBook Pro 13-inch")
    public WebElement secodProductName ;
	public void clearCompareList() {
		clickButton(clearListLink);
	}
	public void compareProducts() {
		//get all rows
		System.out.println(allRows.size());
		//get 
		for(WebElement row: allRows)
		{
			System.out.println(row.getText() + "/t");
			
		}
		for(WebElement col: allCouloms)
		{
			System.out.println(col.getText() + "/t");
			
		}
	}
}

