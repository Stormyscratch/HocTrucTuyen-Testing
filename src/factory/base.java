package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class base {
	public WebDriver driver;

	@BeforeClass
  public void init() throws Exception {
  String baseURL = "https://hoctructuyen.vanlanguni.edu.vn";
  System.setProperty("webdriver.gecko.driver", "E:\\geckodriver-v0.25.0-win64\\geckodriver.exe");
  FirefoxProfile profile = new FirefoxProfile();
  profile.setPreference("browser.download.folderList",2);
  profile.setPreference("browser.download.dir","C:\\Users\\Stormy-PC\\Downloads");
  profile.setPreference("browser.download.manager.showWhenStarting",false);
  profile.setPreference("browser.helperApps.neverAsk.saveToDisk","application/vnd.openxmlformats-officedocument.wordprocessingml.document");
  FirefoxOptions options = new FirefoxOptions();
  options.setProfile(profile);
  driver = new FirefoxDriver(options);
  driver.get(baseURL);
  }
	
	@AfterClass
	public void quit() {
		driver.quit();
	}
}