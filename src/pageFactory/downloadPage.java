package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class downloadPage {
	WebDriver driver;
	
	//My course dashboard
	@FindBy(xpath="//span[text()='My Courses']")
	WebElement myCourse;
	public WebElement getMyCourse() {
		return this.myCourse;
	}
	
	//Link of the course
	@FindBy(xpath="//a[@href='https://hoctructuyen.vanlanguni.edu.vn/course/view.php?id=1256']")
	WebElement courseLink;
	public WebElement getCourseLink() {
		return this.courseLink;
	}
	public void clickCourseLink() {
		getCourseLink().click();
	}
	
	//Link of the slides
	@FindBy(xpath="//a[@href='https://hoctructuyen.vanlanguni.edu.vn/mod/folder/view.php?id=39205']")
	WebElement slideLink;
	public WebElement getslideLink() {
		return this.slideLink;
	}
	
	public void clickSliderLink() {
		getslideLink().click();
	}
	
	//Download target file
	@FindBy(xpath="//span[text()='Setting up Wget.docx']")
	WebElement targetFile;
	public WebElement getTargetFile() {
		return this.targetFile;
	}
	public void downloadTargetLink() {
		getTargetFile().click();
	}
	
	public void hovertoMyCourse() {
		Actions action = new Actions(driver);
		  action.moveToElement(getMyCourse());
		  action.perform();
	}
	
	public downloadPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
