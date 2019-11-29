package test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import factory.ExcelUtils;
import factory.base;
import factory.serviceFactory;
import pageFactory.loginPage;

import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends base {
	
	//Creating Excel path and Sheet
	public final String FILEPATH = "E:\\Eclipse-Projects\\HocTrucTuyen-Testing\\dataTestCase_Login.xlsx";
	public final String SHEET = "Login";
	
	
	//Rows and Collumns
	public final int ROW = 8;
	public final int COL = 6;
  	public final int USERNAME_COL =3;
	public final int PASSWORD_COL =4;
	public final int EXPECTED_COL = 6;
	public final int SUCCESS_DATA_ROW=2;
	
	//POM related
	loginPage objLogin;
	serviceFactory objService;
	
	//URL
	public final String homeURL = "https://hoctructuyen.vanlanguni.edu.vn";
	public final String loginURL = "https://hoctructuyen.vanlanguni.edu.vn/login/index.php";
	
	//Login data instance
	public String username;
	public String password;
	
	@Test(priority = 1)
  public void login() throws Exception {
		//POM applied
		objLogin = new loginPage(driver);
		objService = new serviceFactory(driver);
		
		ExcelUtils.setExcelFile(FILEPATH, SHEET);
		ExcelUtils.setrowcolumn(ROW, COL);
		
		objService.waitForElementToClickable(objLogin.getLoginLink());
		objLogin.loginLinkClick();
		
		objService.waitForElementToClickable(objLogin.getLoginBtn());
		
		username = ExcelUtils.getCellData(SUCCESS_DATA_ROW, USERNAME_COL);
		password = ExcelUtils.getCellData(SUCCESS_DATA_ROW, PASSWORD_COL);
		
		objLogin.login(username, password);
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(3000);
		
		if(driver.getCurrentUrl().equals(homeURL)) {
			Assert.assertEquals(objLogin.getProfileText(), ExcelUtils.getCellData(SUCCESS_DATA_ROW, EXPECTED_COL));
			objLogin.logoutClick();
		}
		
  }
	
//	@Test(priority = 1)
//	public void guestLogin() {
//		driver.findElement(By.xpath("//a[@href='https://hoctructuyen.vanlanguni.edu.vn/login/index.php']")).click();
//		//Login as guest
//		driver.findElement(By.xpath("//input[@value='Log in as a guest']")).click();
//		//getting actual result
//		String actual = driver.findElement(By.xpath("//div[@class='logininfo']")).getText();
//		//checking if it's true or not
//		
//		Assert.assertTrue(actual.contains("You are currently using guest access"));
//	}
//	@Test (priority = 3)
//	public void invalidUser() {
//		String user = "t177813";
//		String password = "t177225";
//		
//		driver.findElement(By.xpath("//a[@href='https://hoctructuyen.vanlanguni.edu.vn/login/index.php']")).click();
//		
//		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(user);
//		  
//		  driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
//		  
//		  driver.findElement(By.xpath("//input[@id='loginbtn']")).click();
//		  
//		  String actualResult = driver.findElement(By.xpath("//span[@class='error']")).getText();
//		  String expectedResult = "Invalid login, please try again";
//		  
//		  Assert.assertEquals(actualResult, expectedResult);
//	}
	
//	@Test(priority = 4)
//	public void invalidPassword() {
//		String user = "t177225";
//		String password = "ABCXYZ";
//		
//		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(user);
//		  
//		  driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
//		  
//		  driver.findElement(By.xpath("//input[@id='loginbtn']")).click();
//		  
//		  String actualResult = driver.findElement(By.xpath("//span[@class='error']")).getText();
//		  String expectedResult = "Invalid login, please try again";
//		  
//		  Assert.assertEquals(actualResult, expectedResult);
//	}
//	
	
}
