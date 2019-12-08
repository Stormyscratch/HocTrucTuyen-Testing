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
	  //Dashboard
//	  Actions action = new Actions(driver);
//	  action.moveToElement(element);
//	  action.perform();
	  objUpload.hoverToElement(objUpload.getMyDashBoard());
//	  objService.hoverToElement(objUpload.getMyDashBoard());
	  objService.waitForElementPresented(objUpload.getPrivateFiles());
//	  driver.findElement(By.xpath("//span[text()=' Private files']")).click();
	  objUpload.privateFileClick();
	  objService.waitForElementToClickable(objUpload.getAdd());
//	  driver.findElement(By.xpath("//div[@class='fp-toolbar']//a[@title='Add...']")).click();
	  objUpload.addClick();
	  objService.waitForElementPresented(objUpload.getUploadInput());
//	  driver.findElement(By.xpath("//input[@name='repo_upload_file']")).sendKeys("E:\\Testing.txt");
	  objUpload.uploadInputSendText(input);
	  objService.waitForElementPresented(objUpload.getUploadBtn());
//	  driver.findElement(By.xpath("//button[text()='Upload this file']")).click();
	  objUpload.uploadBtnClick();
	  
	  Thread.sleep(10000);
	  WebElement actualEle = driver.findElement(By.xpath("//div[text()='Testing.txt']"));
	 
	  
	  String expectedResult = "Testing.txt";
	  String actualResult= actualEle.getText();
	  Assert.assertEquals(actualResult, expectedResult);
  }

}
