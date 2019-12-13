package factory;


import java.io.File;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageFactory.loginPage;

public class serviceFactory{
	WebDriver driver;
	@CacheLookup
	@FindBy(tagName = "html")
	public WebElement _document;
	public WebElement __document;
	public loginPage objLogin = new loginPage(driver);

	
	public serviceFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void waitForElementPresented(WebElement elements) {
		WebDriverWait wait = new WebDriverWait(this.driver,100);
		wait.until(ExpectedConditions.visibilityOf(elements));
	}
	
	public void waitForElementToClickable(WebElement elements) {
		WebDriverWait wait = new WebDriverWait(this.driver,100);
		wait.until(ExpectedConditions.elementToBeClickable(elements));
	}
	
	
	public File getLatestFilefromDir(String dirPath){
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
	
	public boolean isFileDownloaded_Exist(String dirPath, String ext){
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
	
	public void waitForDownload(String downloadPath, String fileName) throws InterruptedException {
		while(!isFileDownloaded(downloadPath, fileName)) {
			Thread.sleep(2000);
		}
	}
	
}
