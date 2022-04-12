package pom;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

import generic.BasePage;

public class BookTickets_DestinationValid extends BasePage{

@FindBy(xpath="//input[@id='fromPlaceName']")
//@FindBy(xpath="//a[@class='ui-corner-all'][text()='BENGALURU']")
private WebElement FromPlace;

@FindBy(xpath="//input[@id='toPlaceName']")
private WebElement ToPlace;

@FindBy(id="txtJourneyDate")
private WebElement JourneyDate;

@FindBy(xpath="//*[@id=\"bookingsForm\"]/div[1]/div/div[1]/div/h2")
private WebElement OuterClick;

@FindBy(xpath="//button[@class='btn btn-primary btn-lg btn-block btn-booking']")
private WebElement Click_SearchButton;

@FindBy(xpath="(//input[@id='SrvcSelectBtnForward3'])[2]")
private WebElement Click_SelectSeats;

@FindBy(xpath="//span[@class='seatNumber'][contains(text(),'49')]")
private WebElement clickSeat49;

@FindBy(xpath="//input[@name='passengerName']")
private WebElement PassengerName;

@FindBy(id="genderCodeIdForward0")
private WebElement Gender;

@FindBy(id="passengerAgeForward0")
private WebElement Age;

@FindBy(id="concessionIdsForward0")
private WebElement Concession;

@FindBy(xpath="//input[@id='PgBtn']")
private WebElement Click_MakePayment_Button;

public BookTickets_DestinationValid(WebDriver driver){
	super(driver);
}

public void getFromPlace(String From_Place) throws InterruptedException {
	FromPlace.sendKeys(From_Place);
	FromPlace.click();
	FromPlace.sendKeys(Keys.TAB);
}

public void getToPlace(String To_Place) throws InterruptedException {
	ToPlace.sendKeys(To_Place);
	Thread.sleep(1000);
	ToPlace.click();
	ToPlace.sendKeys(Keys.TAB);
	//Thread.sleep(1000);
}

public void selectJourneyDate() throws InterruptedException {
	//script handled using Javascript executor and selects 10th day of the current month//
	((JavascriptExecutor)driver).executeScript("document.getElementById('txtJourneyDate').removeAttribute('readonly',0);"); 
	WebElement SelectDate= JourneyDate;
	//SelectDate.clear();
	SelectDate.sendKeys("20/04/2022");
	OuterClick.click();
	//SelectDate.sendKeys(Keys.TAB);
	//SelectDate.click();
	Thread.sleep(1000);
}

public void clickSearchButton() throws InterruptedException {
	WebElement ClickCheckout=driver.findElement(By.xpath("//button[@class='btn btn-primary btn-lg btn-block btn-booking']"));
	((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+ClickCheckout.getLocation().x+")");
	ClickCheckout.click();
		//Thread.sleep(6000);

	}

public void clickSelectSeats() {
	WebElement ClickCheckout=driver.findElement(By.xpath("(//input[@id='SrvcSelectBtnForward3'])[2]"));
	((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+ClickCheckout.getLocation().x+")");
	Click_SelectSeats.click();
}

public void selectSeat() {
	clickSeat49.click();
}
public void get_PassengerName(String ePassenger) {
	PassengerName.sendKeys(ePassenger);
}

public void selectGender() {
WebElement selectgender=Gender;
Select select=new Select(selectgender);
select.selectByValue("24");
}

public void getAge(String get_Age) {
	Age.sendKeys(get_Age);
}

public void select_Concession() {
WebElement 	selectConcession=Concession;
Select select2=new Select(selectConcession);
select2.selectByVisibleText("GENERAL PUBLIC");
}

public void clickPayment_Button() throws InterruptedException, IOException {
	WebElement ClickPayment=driver.findElement(By.xpath("//input[@id='PgBtn']"));
	((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+ClickPayment.getLocation().x+")");
	ClickPayment.click();
	Thread.sleep(2000);
	
	//script to capture the screenshot evidence for User navigation till Payments page//
	File scrFile2=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileHandler.copy(scrFile2, new File("./screenshots/Capture_PaymentsPage.png"));
}
}
