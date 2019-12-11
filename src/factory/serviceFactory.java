package factory;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class serviceFactory {
	WebDriver driver;
	@CacheLookup
	@FindBy(tagName = "html")
	public WebElement _document;
	public WebElement __document;

	
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
	
	public void waitForPageReload() {
		ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(driver, 100);
            wait.until(expectation);
        } 
           catch (Throwable error) {
              System.out.println("Took so long for page to reload");
        }
	}
}
