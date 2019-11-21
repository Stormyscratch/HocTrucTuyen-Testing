package Package;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class UploadTest {
	WebDriver driver;
	String baseURL = "https://hoctructuyen.vanlanguni.edu.vn";
	@BeforeSuite
  public void init() {
  System.setProperty("webdriver.gecko.driver", "E:\\geckodriver-v0.25.0-win64\\geckodriver.exe");
  driver = new FirefoxDriver();
  driver.get(baseURL);
  }
	
	@BeforeTest
	public void login() {
		String user = "t177225";
		String password = "t177225";
		driver.findElement(By.xpath("//a[@href='https://hoctructuyen.vanlanguni.edu.vn/login/index.php']")).click();
	  //Insert Username and Password
	  driver.findElement(By.xpath("//input[@id='username']")).sendKeys(user);
	  
	  driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
	  
	  driver.findElement(By.xpath("//input[@id='loginbtn']")).click();
	}
	
  @Test
  public void uploading() {
	  WebElement element = driver.findElement(By.xpath("//span[text()='My Dashboard']"));
	  Actions action = new Actions(driver);
	  action.moveToElement(element);
	  action.perform();
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  driver.findElement(By.xpath("//span[text()=' Private files']")).click();
  }
  
  @AfterSuite
	public void driverQuit() {
		driver.quit();
	}
}
