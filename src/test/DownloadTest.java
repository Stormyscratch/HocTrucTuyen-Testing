package test;

import org.testng.annotations.Test;

import factory.base;
import factory.serviceFactory;
import pageFactory.downloadPage;
import pageFactory.loginPage;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

  public class DownloadTest extends base {
		public static String downloadPath = "C:\\Users\\Stormy-PC\\Downloads";
		
		public String user = "t177225";
		public String password = "t177225";
		
	public serviceFactory objService;
	public loginPage objLogin;
	public downloadPage objDown;
	
	public void createPOM() {
		objLogin = new loginPage(driver);
		objService = new serviceFactory(driver);
		objDown = new downloadPage(driver);
	}
	public void autoLogin() {
		objLogin.loginLinkClick();
		objLogin.login(user, password);
	}
		
	  @Test
	  public void downloadTest() throws InterruptedException, Exception {
		  firefoxProfile();
		  createPOM();
		  autoLogin();
		//Login sequence
		  
		  //navigate to download page sequence
		  objService.waitForElementPresented(objDown.getMyCourse());
		  objDown.hovertoMyCourse();
		  Thread.sleep(3000);
		  //Click on the Course
		  objDown.clickCourseLink();
		  //Click on Slide
		  objDown.clickSliderLink();


//		  Download file
		  objService.waitForElementToClickable(objDown.getTargetFile());
		  objDown.downloadTargetLink();
		  Thread.sleep(5000);
		  
//		  Compare to latest file
		  File getLatestFile = objService.getLatestFilefromDir(downloadPath);
		     String fileName = getLatestFile.getName();
		     Assert.assertTrue(fileName.equals("Setting up Wget.docx"),
		    		 "Downloaded file name is not matching with expected file name");
		     getLatestFile.deleteOnExit();
	  }
	  
	  public static FirefoxProfile firefoxProfile() throws Exception {

		  FirefoxProfile firefoxProfile = new FirefoxProfile();
		  firefoxProfile.setPreference("browser.download.folderList",2);
		  firefoxProfile.setPreference("browser.download.manager.showWhenStarting",false);
		  firefoxProfile.setPreference("browser.download.dir",downloadPath);
		  firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk","application/docx");

		  return firefoxProfile;
		 }
  }
