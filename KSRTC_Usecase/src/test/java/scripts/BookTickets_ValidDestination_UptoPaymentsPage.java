package scripts;

//import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

//import generic.AutoConst;
//import generic.Excel;
import pom.BookTickets_DestinationValid;
//import pom.BookTickets_DestinationValid;
import pom.LoginPage_ValidUser_Login;

public class BookTickets_ValidDestination_UptoPaymentsPage{
@Test
	
	public void test_BookTickets_ValidDestination_UptoPaymentsPage() throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://ksrtc.in/oprs-web/login/show.do");
		driver.manage().timeouts().implicitlyWait(65, TimeUnit.SECONDS);
		
		//creating the object to reuse the Page objects and Methods from the POM class//
		LoginPage_ValidUser_Login L=new LoginPage_ValidUser_Login(driver);
		PageFactory.initElements(driver, L);
	  
		BookTickets_DestinationValid Book=new BookTickets_DestinationValid(driver);
		//PageFactory.initElements(driver, Book);
		
		//scripts to pass valid login credentials and click submit for successful login//
		L.get_UserName("reply2vencatraz@gmail.com");
		L.get_Password("Hannish@50");
		L.click_Submit();
		
		//script to select a valid Source and Destination to book tickets//
		Book.getFromPlace("PUTTUR ANDHRA PRADESH");
		Book.getToPlace("BENGALURU");
		
				
		//Calling the methods for select Journey date, select seat, enter Passenger name, gender, age and Concession type//
		Book.selectJourneyDate();
		Book.clickSearchButton();
		Book.clickSelectSeats();
		Book.selectSeat();
		Book.get_PassengerName("Venkatraja P");
		Book.selectGender();
		Book.getAge("40");
		Book.select_Concession();
		//script to click on Payment button//
		Book.clickPayment_Button();

}
}
