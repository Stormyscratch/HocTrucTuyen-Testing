package test;

import org.testng.annotations.Test;
import factory.base;
import factory.serviceFactory;
import pageFactory.downloadPage;
import pageFactory.loginPage;
import java.io.File;
import org.testng.Assert;

  public class DownloadTest extends base {
		public static String downloadPath = "E:\\Eclipse-Projects\\HocTrucTuyen-Testing\\downloads";
		public static String fileName = "Setting up Wget.docx";
		
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
		  objService.waitForDownload(downloadPath, fileName);
		  
//		  Compare to latest file
		  File getLatestFile = objService.getLatestFilefromDir(downloadPath);
		     String nameFile = getLatestFile.getName();
		     Assert.assertTrue(nameFile.equals(fileName),
		    		 "Downloaded file name is not matching with expected file name");
		     getLatestFile.deleteOnExit();
	  }
	  
  }
