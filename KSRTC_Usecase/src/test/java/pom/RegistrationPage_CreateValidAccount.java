package pom;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;

import generic.BasePage;

public class RegistrationPage_CreateValidAccount extends BasePage{

//page objects defined for Email, Full Name and Mobile number//
@FindBy(xpath="//*[@id='email']")
private WebElement UserName_Email;

@FindBy(xpath="//*[@id='fullName']")
private WebElement Full_Name;

@FindBy(xpath="//*[@id='mobileNo']")
private WebElement MobileNumber;

@FindBy(xpath="//input[@name='SaveBtn']")
private WebElement AddButton;

public RegistrationPage_CreateValidAccount(WebDriver driver) {
	super(driver);
}

//method to get values for Email, Name and Mobile no//
public void getUserName_Email(String UserName, String FullName, String MobileNo ) {
	UserName_Email.sendKeys(UserName);
	Full_Name.sendKeys(FullName);
	MobileNumber.sendKeys(MobileNo);
	
}

//script to click on Add//
public void clickAddButton() {
	AddButton.click();
}
}



