package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class base {
	public WebDriver driver;
	@BeforeClass
  public void init() {
	String baseURL = "https://hoctructuyen.vanlanguni.edu.vn";
  System.setProperty("webdriver.gecko.driver", "E:\\geckodriver-v0.25.0-win64\\geckodriver.exe");
  driver = new FirefoxDriver();
  driver.get(baseURL);
  }
	
	@AfterClass
	public void quit() {
		driver.quit();
	}
}