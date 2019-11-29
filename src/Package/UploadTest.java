package Package;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
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
  public void uploading() throws InterruptedException {
	  WebElement element = driver.findElement(By.xpath("//span[text()='My Dashboard']"));
	  Actions action = new Actions(driver);
	  action.moveToElement(element);
	  action.perform();
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  driver.findElement(By.xpath("//span[text()=' Private files']")).click();
	  
	  Thread.sleep(10000);
	  
	  driver.findElement(By.xpath("//div[@class='fp-toolbar']//a[@title='Add...']")).click();
	  
//	  WebDriverWait wait = new WebDriverWait(driver, 5000);
//	  WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@tabindex='0']//h3[contains(text(), 'File picker')]")));
//	  
//	  Actions action_2 = new Actions(driver);
//	  action_2.moveToElement(element1);
//	  action_2.perform();
	  
//	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  
	  Thread.sleep(3000);
//	  driver.findElement(By.xpath("//input[@name='repo_upload_file']/../../div")).sendKeys(org.openqa.selenium.Keys.ENTER);
//	  driver.findElement(By.xpath("//input[@name='repo_upload_file']/../../div")).submit();
	 //driver.findElement(By.xpath("//input[@name='repo_upload_file']")).submit();
	  driver.findElement(By.xpath("//input[@name='repo_upload_file']")).sendKeys("E:\\Testing.txt");
	  Thread.sleep(5000);
	  driver.findElement(By.xpath("//button[text()='Upload this file']")).click();
	 // driver.findElement(By.xpath("//input[@name='repo_upload_file']")).sendKeys(org.openqa.selenium.Keys.ENTER);

	  String expectedResult = "Testing.txt";
	  String actualResult= driver.findElement(By.xpath("//div[text()='Testing.txt']")).getText();
	  
	  Assert.assertEquals(actualResult, expectedResult);
	  
	  
//	  Point location = e.getLocation();
//	  int x_offset = location.getX();
//	  int y_offset = location.getY();
//	  Actions action_2 = new Actions(driver);
//	  action_2.moveToElement(e,150,10).click().build().perform();
//	  Thread.sleep(3000);
	  
	  
  }
    
  @AfterSuite
	public void driverQuit() {
		driver.quit();
	}
}
