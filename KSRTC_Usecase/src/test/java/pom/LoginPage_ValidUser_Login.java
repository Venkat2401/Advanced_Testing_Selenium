package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import generic.BasePage;

public class LoginPage_ValidUser_Login extends BasePage{

//pagw objects defined for Login page//
@FindBy(xpath="//input[@id='userName']")
private WebElement UserName;

@FindBy(xpath="//input[@id='password']")
private WebElement Password;

@FindBy(xpath="//input[@id='submitBtn']")
private WebElement Submit_Button;


public LoginPage_ValidUser_Login(WebDriver driver) {
	super(driver);
}

//method to accept username//
public void get_UserName(String valid_user) {
	UserName.sendKeys(valid_user);
}

//method to accept password//
public void get_Password(String password) {
	Password.sendKeys(password);

}
//method to click on Submit//
public void click_Submit() {
	Submit_Button.click();
}
}
