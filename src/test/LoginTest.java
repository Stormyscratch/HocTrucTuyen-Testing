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
	public final int EXPECTED_COL = 5;
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
	
	@Test(priority = 2)
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
		
		Assert.assertEquals(objLogin.getLoginStatus(), ExcelUtils.getCellData(SUCCESS_DATA_ROW, EXPECTED_COL));
		
		objLogin.logoutClick();
		
  }
	
	@Test(priority = 1)
public void guestLogin() throws Exception {
		objLogin = new loginPage(driver);
		objService = new serviceFactory(driver);
				
		objService.waitForElementToClickable(objLogin.getLoginLink());
		objLogin.loginLinkClick();
		
		objService.waitForElementToClickable(objLogin.getLoginGuestBtn());
		objLogin.loginGuestClick();
		//checking if it's true or not
		
		Assert.assertTrue(objLogin.getProfileText().contains("You are currently using guest access"));
	}	
	
	@Test(priority = 3)
public void failedLogin() throws Exception {
		objLogin = new loginPage(driver);
		objService = new serviceFactory(driver);
		
		ExcelUtils.setExcelFile(FILEPATH, SHEET);
		ExcelUtils.setrowcolumn(ROW, COL);
		
		objService.waitForElementToClickable(objLogin.getLoginLink());
		objLogin.loginLinkClick();
		
		for(int i = 3;i < ExcelUtils.getrow();i++) {
			
			username = ExcelUtils.getCellData(i, USERNAME_COL);
			password = ExcelUtils.getCellData(i, PASSWORD_COL);
			
			objService.waitForElementToClickable(objLogin.getLoginBtn());
			
			objLogin.login(username, password);
			
			Thread.sleep(2000);
			
			objService.waitForElementToClickable(objLogin.getLoginBtn());
			
			Assert.assertEquals(objLogin.getLoginFailedMsg(), ExcelUtils.getCellData(i, EXPECTED_COL));
			
			driver.navigate().refresh();
			
		}
	}
}
