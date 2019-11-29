package test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import factory.base;
import pageFactory.loginPage;

import org.testng.Assert;
import org.openqa.selenium.By;

public class LoginTest extends base {
	
	loginPage objLogin;
	
	@Test(priority = 2)
  public void login() {
		String user = "t177225";
		String password = "t177225";
		driver.findElement(By.xpath("//a[@href='https://hoctructuyen.vanlanguni.edu.vn/login/index.php']")).click();
	  //Insert Username and Password
	  driver.findElement(By.xpath("//input[@id='username']")).sendKeys(user);
	  
	  driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
	  
	  driver.findElement(By.xpath("//input[@id='loginbtn']")).click();
	  
	  String actualResult = driver.findElement(By.xpath("//a[@title='View profile']")).getText();
	  String expectedResult = "T177225 - NGUYỄN VĨNH TRí - K23T01";
	  Assert.assertEquals(actualResult, expectedResult);
	  
	  driver.findElement(By.xpath("//a[text()='Log out']")).click();
  }
	
	@Test(priority = 1)
	public void guestLogin() {
		driver.findElement(By.xpath("//a[@href='https://hoctructuyen.vanlanguni.edu.vn/login/index.php']")).click();
		//Login as guest
		driver.findElement(By.xpath("//input[@value='Log in as a guest']")).click();
		//getting actual result
		String actual = driver.findElement(By.xpath("//div[@class='logininfo']")).getText();
		//checking if it's true or not
		
		Assert.assertTrue(actual.contains("You are currently using guest access"));
	}
	@Test (priority = 3)
	public void invalidUser() {
		String user = "t177813";
		String password = "t177225";
		
		driver.findElement(By.xpath("//a[@href='https://hoctructuyen.vanlanguni.edu.vn/login/index.php']")).click();
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(user);
		  
		  driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		  
		  driver.findElement(By.xpath("//input[@id='loginbtn']")).click();
		  
		  String actualResult = driver.findElement(By.xpath("//span[@class='error']")).getText();
		  String expectedResult = "Invalid login, please try again";
		  
		  Assert.assertEquals(actualResult, expectedResult);
	}
	
	@Test(priority = 4)
	public void invalidPassword() {
		String user = "t177225";
		String password = "ABCXYZ";
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(user);
		  
		  driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		  
		  driver.findElement(By.xpath("//input[@id='loginbtn']")).click();
		  
		  String actualResult = driver.findElement(By.xpath("//span[@class='error']")).getText();
		  String expectedResult = "Invalid login, please try again";
		  
		  Assert.assertEquals(actualResult, expectedResult);
	}
	
	@AfterSuite
	public void driverQuit() {
		driver.quit();
	}
}
