package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PageBase {

	protected WebDriver driver ; 
	public JavascriptExecutor jse;

	public PageBase(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}
	protected void clickButton(WebElement button) {

		button.click();
	}
	protected void setTextElementText(WebElement textElement , String value) {

		textElement.sendKeys(value);
	}
	
	public void scrollToBottom() {
		
		jse.executeScript("scrollBy(0,2000)");
	}

}
