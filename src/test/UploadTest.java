package test;

import org.testng.annotations.Test;

import factory.base;
import factory.serviceFactory;

import pageFactory.loginPage;
import pageFactory.uploadPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class UploadTest extends base {
	
//Username and Password
public String username = "t177225";
public String password = "t177225";
public String input = "E:\\Testing.txt";
	
//POM
public serviceFactory objService;
public loginPage objLogin;
public uploadPage objUpload;

public void creatingPOM() {
	objLogin = new loginPage(driver);
	objService = new serviceFactory(driver);
	objUpload = new uploadPage(driver);
}

public void autoLogin() {
	objLogin.loginLinkClick();
	objLogin.login(username, password);
}
	
  @Test
  public void uploading() throws InterruptedException {
	  creatingPOM();
	  autoLogin();
	  //Hovering to the dashboard
	  objUpload.hoverToElement(objUpload.getMyDashBoard());
	  
	  //Click on Private Files
	  objService.waitForElementPresented(objUpload.getPrivateFiles());
	  objUpload.privateFileClick();
	  
	  //Click on Add to add / upload new file
	  objService.waitForElementToClickable(objUpload.getAdd());
	  objUpload.addClick();
	  
	  //Input the path of the upload file and upload
	  objService.waitForElementPresented(objUpload.getUploadInput());
	  objUpload.uploadInputSendText(input);
	  
	  //It's time Mr.Krab
	  objService.waitForElementPresented(objUpload.getUploadBtn());
	  objUpload.uploadBtnClick();
	  
	  //Commercial break
	  Thread.sleep(1000);
//	  objService.waitForPageReload();
	  
	  
	  //ASSert area
	  WebElement actualEle = driver.findElement(By.xpath("//div[text()='Testing.txt']"));
	  String expectedResult = "Testing.txt";
	  String actualResult= actualEle.getText();
	  Assert.assertEquals(actualResult, expectedResult);
  }

}
