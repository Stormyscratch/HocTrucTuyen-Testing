package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class uploadPage {
WebDriver driver;	
	
//Elements	

//Thingy make you hover your mouse to it	
@FindBy(xpath="//span[text()='My Dashboard']")
WebElement myDashBoard;
@FindBy(xpath="//span[text()=' Private files']")
WebElement privateFiles;

//Addy Mc.Add
@FindBy(xpath="//div[@class='fp-toolbar']//a[@title='Add...']")
WebElement add;

//Input + button
@FindBy(xpath="//input[@name='repo_upload_file']")
WebElement uploadInput;
@FindBy(xpath="//button[text()='Upload this file']")
WebElement uploadBtn;

//Get Element
public WebElement getMyDashBoard(){
	return this.myDashBoard;
}
public WebElement getPrivateFiles() {
	return this.privateFiles;
}
public WebElement getAdd() {
	return this.add;
}
public WebElement getUploadInput() {
	return this.uploadInput;
}
public WebElement getUploadBtn() {
	return this.uploadBtn;
}


//Clicky
public void addClick() {
	this.add.click();
}
public void uploadInputSendText(String text) {
	this.uploadInput.sendKeys(text);
}
public void uploadBtnClick() {
	this.uploadBtn.click();
}
public void privateFileClick() {
	this.privateFiles.click();
}

public void hoverToElement(WebElement element) {
	Actions action =new Actions(driver);
	action.moveToElement(getMyDashBoard());
	action.perform();
			
} 
public uploadPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
}

}
