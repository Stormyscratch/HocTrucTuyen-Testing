package Package;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class DownloadTest {

	WebDriver driver;
	String baseURL = "https://hoctructuyen.vanlanguni.edu.vn";
	@BeforeSuite
	public void init() {
		System.setProperty("webdriver.gecko.driver", "E:\\geckodriver-v0.25.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get(baseURL);
  }
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
	  driver.findElement(By.xpath("//a[@href='//*[@id=\"yui_3_17_2_1_1574849554625_72\"]'")).click();;
	  driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[3]/div/ul/li[1]/a")).click();;
//	  driver.findElement(By.xpath("//img[@role='presentation']")).click();;
//	  H OW TF AM I SUPPO SE TO GET THA T XPATH
//	  Download file
	  driver.findElement(By.xpath(""
	  		+ "html.yui3-js-enabled.uk-notouch.js.textshadow.cssanimations.csstransitions body#page-course-view-topics.format-topics.path-course.path-course-view.gecko.dir-ltr.lang-en.yui-skin-sam.yui3-skin-sam.hoctructuyen-vanlanguni-edu-vn.pagelayout-course.course-1256.context-109982.category-57.theme_uikit.moodle26plus.layout1.has-region-side-pre.used-region-side-pre.has-region-side-post.used-region-side-post.has-region-footer-left.empty-region-footer-left.has-region-footer-middle.empty-region-footer-middle.has-region-footer-right.empty-region-footer-right.jsenabled div#page div#page-content div.uk-grid div#region-bs-main-and-pre.uk-width-1-1.uk-width-medium-1-1.uk-width-large-3-4.uk-width-xlarge-8-10.uk-margin-bottom div#pre-and-content.uk-grid div#region-main-uikit.uk-width-1-1.uk-width-medium-7-10.uk-width-large-7-10.uk-width-xlarge-3-4 section#region-main.uk-margin-bottom div#main-content-box div div.course-content ul.topics li#section-0.section.main.clearfix div.content ul.section.img-text li#module-39205.activity.folder.modtype_folder div div.mod-indent-outer div")
			  ).click();;
	  driver.findElement(By.xpath("//input[@value='Download folder'")).click();
	  
	  Thread.sleep(50000);
  }
  @AfterSuite
  public void driverQuite() {
	  driver.quit();
  }

}
