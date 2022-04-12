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
import org.testng.Reporter;
import org.testng.annotations.Test;

import pom.LoginPage_ValidUser_Login;

public class LoginPage_Login_ValidUser {

@Test
	
	public void test_LoginPage_Login_ValidUser() throws InterruptedException, IOException {
	//script to instantiate the web browser and launch the URL//	
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://ksrtc.in/oprs-web/login/show.do");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		//creating the object to reuse the Page objects and Methods from the POM class//
		LoginPage_ValidUser_Login L=new LoginPage_ValidUser_Login(driver);
		PageFactory.initElements(driver, L);
		
		//providing valid login user credentials to login//
		L.get_UserName("reply2vencatraz@gmail.com");
		L.get_Password("Hannish@50");
		
		//script to capture the screenshot evidence in the login page for credentials//
		File scrFile1=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(scrFile1, new File("./screenshots/CaptureLoginPage_UserCredentials.png"));
				
		L.click_Submit();
		
		//script implemented to capture the title of the next Home page and print in the console//
		String actual_title=driver.getTitle();
		Reporter.log(actual_title, true);
		
		//script to capture the screenshot evidence post successful login//
		File scrFile2=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(scrFile2, new File("./screenshots/Capture_PostSuccessful_Login.png"));
		
		driver.quit();
	
}
}
