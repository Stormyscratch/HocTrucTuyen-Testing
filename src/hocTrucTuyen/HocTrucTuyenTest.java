package hocTrucTuyen;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HocTrucTuyenTest {
	WebDriver driver;
	String baseURL = "https://hoctructuyen.vanlanguni.edu.vn";
	@BeforeTest
  public void init() {
  System.setProperty("webdriver.gecko.driver", "E:\\geckodriver-v0.25.0-win64\\geckodriver.exe");
  driver = new FirefoxDriver();
  driver.get(baseURL);
  }
	@Test
  public void login(String user, String password) {
		user = "t177225";
		password = "t177225";
		
	  //Clicking the login button
	  driver.findElement(By.xpath("//a[@href='https://hoctructuyen.vanlanguni.edu.vn/login/index.php']")).click();
	  //Insert Username and Password
	  driver.findElement(By.xpath("//input[@id='username']")).sendKeys(user);
	  
	  driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
	  
	  driver.findElement(By.xpath("//input[@id='loginbtn']")).click();
	  
	  String actualResult = driver.findElement(By.xpath("//a[@title='View profile']")).getText();
	  String expectedResult = "T177225 - NGUYỄN VĨNH TR�? - K23T01";
	  Assert.assertEquals(actualResult, expectedResult);
  }
	
	@Test
	public void guestLogin() {
		driver.findElement(By.xpath("//a[@href='https://hoctructuyen.vanlanguni.edu.vn/login/index.php']")).click();
		//Login as guest
		driver.findElement(By.xpath("//input[@value='Log in as a guest']")).click();
		//getting actual result
		String actual = driver.findElement(By.xpath("//div[@class='logininfo']")).getText();
		//checking if it's true or not
		
		assertTrue(actual.contains("You are currently using guest access"));
	}
	
	@Test
	public void invalidLogin() {
		driver.findElement(By.xpath("//a[@href='https://hoctructuyen.vanlanguni.edu.vn/login/index.php']")).click();
		
		driver.findElement(By.xpath("//input[@id='loginbtn']")).click();
		
		String actual =  driver.findElement(By.xpath("//span[@class='error']")).getText();
		
		String expected = "Invalid login, please try again";
		
		Assert.assertEquals(actual, expected);
	}
	@AfterTest
	public void driverQuit() {
		driver.quit();
	}
}
