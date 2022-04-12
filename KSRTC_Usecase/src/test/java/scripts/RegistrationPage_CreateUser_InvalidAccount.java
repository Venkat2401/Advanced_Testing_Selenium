package scripts;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pom.RegistrationPage_CreateValidAccount;

public class RegistrationPage_CreateUser_InvalidAccount {

	@Test
	
	public void CreateInValidUserAccount_RegistrationPage() throws InterruptedException, IOException {
		//script to instantiate the web browser and launch the URL// 
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://ksrtc.in/oprs-web/user/add.do");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		//creating the object to reuse the Page objects and Methods from the POM class//
		RegistrationPage_CreateValidAccount R=new RegistrationPage_CreateValidAccount(driver);
		PageFactory.initElements(driver, R);
		
		//providing existing Email id which is already created to test negative scenario//
		R.getUserName_Email("reply2vraja@yahoo.com","Venkatraja", "7189920015");
		
		//script to capture the screenshot evidence for Invalid user account//
		File scrFile1=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(scrFile1, new File("./screenshots/CaptureInvalidUser_WarningMessage.png"));
		
		driver.quit();
		
		}
		
	}

