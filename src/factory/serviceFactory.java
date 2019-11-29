package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class serviceFactory {
	WebDriver driver;
	
	public serviceFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void waitForElementPresented(WebElement elements) {
		WebDriverWait wait = new WebDriverWait(this.driver,100);
		wait.until(ExpectedConditions.visibilityOf(elements));
	}
	
	public void waitForElementToClickable(WebElement elements) {
		WebDriverWait wait = new WebDriverWait(this.driver,100);
		wait.until(ExpectedConditions.elementToBeClickable(elements));
	}
}
