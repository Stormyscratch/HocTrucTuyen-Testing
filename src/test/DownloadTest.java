package test;

import org.testng.annotations.Test;

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

//import System;
//import System.Collections.Generic;
//import System.Linq;
//import System.Text;
//import System.Threading.Tasks;
//import System.IO;

  public class DownloadTest {
		public static String downloadPath = "C:\\Users\\Stormy-PC\\Downloads";
		WebDriver driver;
		String baseURL = "https://hoctructuyen.vanlanguni.edu.vn";
		@BeforeSuite
		public void init() {
			System.setProperty("webdriver.gecko.driver", "E:\\geckodriver-v0.25.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.get(baseURL);
			driver.manage().window().maximize();
	  }
		
//		@BeforeClass
//		 public void testSetup() throws Exception{
//		  driver = new FirefoxDriver(); 
//		  driver.manage().window().maximize();
//		 }
		
	  @Test
	  public void downloadTest() throws InterruptedException {
		//Login sequence
		  String user = "T176033";
		  String password = "Hikari05061999";
		  driver.findElement(By.xpath("//a[@href='https://hoctructuyen.vanlanguni.edu.vn/login/index.php']")).click();
		  //Insert Username and Password
		  driver.findElement(By.xpath("//input[@id='username']")).sendKeys(user);
		  driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		  driver.findElement(By.xpath("//input[@id='loginbtn']")).click();
		  //navigate to download page sequence
		  Thread.sleep(5000);
		  WebElement element = driver.findElement(By.xpath("//span[text()='My Courses']"));
		  Actions action = new Actions(driver);
		  action.moveToElement(element);
		  action.perform();
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("//a[@href='https://hoctructuyen.vanlanguni.edu.vn/course/view.php?id=1256']")).click();;
		  driver.findElement(By.xpath("//a[@href='https://hoctructuyen.vanlanguni.edu.vn/mod/folder/view.php?id=39205']")).click();;
//		  driver.findElement(By.xpath("//img[@role='presentation']")).click();;
//		  H OW TF AM I SUPPO SE TO GET THA T XPATH
//		  Download file
		  driver.findElement(By.xpath("//span[text()='Setting up Wget.docx']")).click();
		  Thread.sleep(5000);
		  
//		  Compare to latest file
		  File getLatestFile = getLatestFilefromDir(downloadPath);
		     String fileName = getLatestFile.getName();
		     Assert.assertTrue(fileName.equals("Setting up Wget.docx"),
		    		 "Downloaded file name is not matching with expected file name");
	  }
	  @AfterClass
	  public void driverQuite() {
		  File dir = new File(downloadPath);
		  File[] dir_contents = dir.listFiles();
		  for (int i = 0; i < dir_contents.length; i++) {
		        if (dir_contents[i].getName().equals("Setting up Wget.docx"))
		            dir_contents[i].delete();
		            }
		  driver.quit();
	  }
	  
	  public static FirefoxProfile firefoxProfile() throws Exception {

		  FirefoxProfile firefoxProfile = new FirefoxProfile();
		  firefoxProfile.setPreference("browser.download.folderList",2);
		  firefoxProfile.setPreference("browser.download.manager.showWhenStarting",false);
		  firefoxProfile.setPreference("browser.download.dir",downloadPath);
		  firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk","application/zip");

		  return firefoxProfile;
		 }
		public boolean isFileDownloaded(String downloadPath, String fileName) {
		 boolean flag = false;
		    File dir = new File(downloadPath);
		    File[] dir_contents = dir.listFiles();

		    for (int i = 0; i < dir_contents.length; i++) {
		        if (dir_contents[i].getName().equals(fileName))
		            return flag=true;
		            }

		    return flag;
		}

		private boolean isFileDownloaded_Ext(String dirPath, String ext){
		 boolean flag=false;
		    File dir = new File(dirPath);
		    File[] files = dir.listFiles();
		    if (files == null || files.length == 0) {
		        flag = false;
		    }

		    for (int i = 1; i < files.length; i++) {
		     if(files[i].getName().contains(ext)) {
		      flag=true;
		     }
		    }
		    return flag;
		}

		private File getLatestFilefromDir(String dirPath){
		    File dir = new File(dirPath);
		    File[] files = dir.listFiles();
		    if (files == null || files.length == 0) {
		        return null;
		    }

		    File lastModifiedFile = files[0];
		    for (int i = 1; i < files.length; i++) {
		       if (lastModifiedFile.lastModified() < files[i].lastModified()) {
		           lastModifiedFile = files[i];
		       }
		    }
		    return lastModifiedFile;
		}
  }