package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;





public class LoginTest {	
	WebDriver driver;
	String baseURL = "https://hoctructuyen.vanlanguni.edu.vn";
	@BeforeSuite
  public void init() {
  System.setProperty("webdriver.gecko.driver", "E:\\geckodriver-v0.25.0-win64\\geckodriver.exe");
  driver = new FirefoxDriver();
  driver.get(baseURL);
  }
	

	
	@Test(priority = 7)
  public void login() {
		String user = "t177225";
		String password = "t177225";
		driver.findElement(By.xpath("//a[@href='https://hoctructuyen.vanlanguni.edu.vn/login/index.php']")).click();
	  //Insert Username and Password
	  driver.findElement(By.xpath("//input[@id='username']")).sendKeys(user);
	  
	  driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
	  
	  driver.findElement(By.xpath("//input[@id='loginbtn']")).click();
	  
	  String actualResult = driver.findElement(By.xpath("//a[@title='View profile']")).getText();
	  String expectedResult = "T177225 - NGUYỄN VĨNH TR�? - K23T01";
	  Assert.assertEquals(actualResult, expectedResult);
	  
	  driver.findElement(By.xpath("//a[text()='Log out']")).click();
  }
	
	@Test(priority = 6)
	public void guestLogin() throws InterruptedException {
		//Login as guest
		driver.findElement(By.xpath("//input[@value='Log in as a guest']")).click();
		//getting actual result
		String actual = driver.findElement(By.xpath("//div[@class='logininfo']")).getText();
		//checking if it's true or not
		
		Assert.assertTrue(actual.contains("You are currently using guest access"));
		
		Thread.sleep(5000);
	}
	@Test (priority = 1)
	public void invalidUser() throws InterruptedException {
		String user = "t17";
		String password = "t177225";
		
		driver.findElement(By.xpath("//a[@href='https://hoctructuyen.vanlanguni.edu.vn/login/index.php']")).click();
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(user);
		  
		  driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		  
		  driver.findElement(By.xpath("//input[@id='loginbtn']")).click();
		  
		  String actualResult = driver.findElement(By.xpath("//span[@class='error']")).getText();
		  String expectedResult = "Invalid login, please try again";
		  
		  Assert.assertEquals(actualResult, expectedResult);
		  Thread.sleep(2000);
	}
	
	@Test(priority = 2)
	public void invalidPassword() throws InterruptedException {
		String user = "t177225";
		String password = "ABCXYZ";
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(user);
		  
		  driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		  
		  driver.findElement(By.xpath("//input[@id='loginbtn']")).click();
		  
		  String actualResult = driver.findElement(By.xpath("//span[@class='error']")).getText();
		  String expectedResult = "Invalid login, please try again";
		  
		  Assert.assertEquals(actualResult, expectedResult);
		  
		  Thread.sleep(2000);
	}
	
	@Test(priority = 3)
	public void invalidLogin() throws InterruptedException {
		String user = "t17";
		String password = "ABCXYZ";
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(user);
		  
		  driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		  
		  driver.findElement(By.xpath("//input[@id='loginbtn']")).click();
		  
		  String actualResult = driver.findElement(By.xpath("//span[@class='error']")).getText();
		  String expectedResult = "Invalid login, please try again";
		  
		  Assert.assertEquals(actualResult, expectedResult);
		  Thread.sleep(2000);
	}
	
	@Test(priority = 3)
	public void emptyPassword() throws InterruptedException {
		String user = "t177225";
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(user);
		  
		  
		  driver.findElement(By.xpath("//input[@id='loginbtn']")).click();
		  
		  String actualResult = driver.findElement(By.xpath("//span[@class='error']")).getText();
		  String expectedResult = "Invalid login, please try again";
		  
		  Assert.assertEquals(actualResult, expectedResult);
		  Thread.sleep(2000);
	}
	
	@Test(priority = 4)
	public void emptyUsername() throws InterruptedException {
		String password = "t177225";
		
		  driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		  
		  driver.findElement(By.xpath("//input[@id='loginbtn']")).click();
		  
		  String actualResult = driver.findElement(By.xpath("//span[@class='error']")).getText();
		  String expectedResult = "Invalid login, please try again";
		  
		  Assert.assertEquals(actualResult, expectedResult);
		  Thread.sleep(2000);
	}
	
	@Test(priority = 5)
	public void emptyLogin() throws InterruptedException {
		  
		  driver.findElement(By.xpath("//input[@id='loginbtn']")).click();
		  
		  String actualResult = driver.findElement(By.xpath("//span[@class='error']")).getText();
		  String expectedResult = "Invalid login, please try again";
		  
		  Assert.assertEquals(actualResult, expectedResult);
		  Thread.sleep(2000);
	}
	
	@AfterSuite
	public void driverQuit() {
		driver.quit();
	}
}
