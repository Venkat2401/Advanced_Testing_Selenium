package generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage { //creating an Abstract class 'BasePage' for driving POM (Page
	                             //object model//
public WebDriver driver; //Defining global variable WebDriver//

public BasePage(WebDriver driver) {
this.driver=driver;
PageFactory.initElements(driver, this); //Using Selenium class 'PageFactory' to instantiate the
	}                                   //WebElements
}
