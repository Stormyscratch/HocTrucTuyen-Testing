package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage {
	WebDriver driver;
	
	//Elements
	
	//Input elements
	@FindBy(xpath = "//input[@id='username']")
	WebElement username;
	@FindBy(xpath = "//input[@id='password']")
	WebElement password;
	
	//Button Elements
	@FindBy(xpath = "//input[@id='loginbtn']")
	WebElement loginBtn;
	@FindBy(xpath = "//a[text()='Log out']")
	WebElement logoutBtn;
	@FindBy(xpath = "//a[@href='https://hoctructuyen.vanlanguni.edu.vn/login/index.php']")
	WebElement loginLink;
	
	//Text Element
	@FindBy(xpath = "//div[@class='logininfo']")
	WebElement profile;
	@FindBy(xpath = "//a[@title='View profile']")
	WebElement loginStatus;
	@FindBy(xpath = "//span[@class='error']")
	WebElement loginfailedMsg;
	
	//Get Elements
	public WebElement getLoginLink() {
		return this.loginLink;
	}
	public WebElement getLoginBtn() {
		return this.loginBtn;
	}
	public WebElement getLogoutBtn() {
		return this.logoutBtn;
	}
	public WebElement getProfileText() {
		return this.profile;
	}
	public WebElement getLoginStatus() {
		return this.loginStatus;
	}
	public String getLoginFailedMsg() {
		return this.loginfailedMsg.getText();
	}
		
	//Clicking
	public void loginClick() {
		this.loginBtn.click();
	}
	public void logoutClick() {
		this.logoutBtn.click();
	}
	public void loginLinkClick() {
		this.loginLink.click();
	}
	
	//Set value
	public void setUsername(String Username) {
		username.clear();
		this.username.sendKeys(Username);
	}
	public void setPassword(String Password) {
		password.clear();
		this.password.sendKeys(Password);
	}
	
	//Function
	public void login(String Username, String Password) {
		this.setUsername(Username);
		this.setPassword(Password);
		this.loginBtn.click();
	}
}
