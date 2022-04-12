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

import generic.AutoConst;
import generic.Excel;
import pom.LoginPage_ValidUser_Login;

public class LoginPage_Login_InvalidUsers implements AutoConst{
@Test
	
	public void test_LoginPage_Login_InvalidUsers() throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://ksrtc.in/oprs-web/login/show.do");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		//creating the object to reuse the Page objects and Methods from the POM class//
		LoginPage_ValidUser_Login L=new LoginPage_ValidUser_Login(driver);
		PageFactory.initElements(driver, L);
		
		//script implemented to test multiple invalid users login from the excel sheet using data-driven approach//
		int rc=Excel.getRowCount(INPUT_PATH, "Sheet1");
		for(int i=1;i<=rc;i++){
		
		//statements/functions to be validated
		String Email=Excel.getCellValue(INPUT_PATH,"Sheet1",i,0);
		L.get_UserName(Email);
		
		String Password=Excel.getCellValue(INPUT_PATH,"Sheet1",i,1);
		L.get_Password(Password);
		   
		L.click_Submit();
		
		//script to capture the screenshot evidence for unsuccessful login//
		File scrFile2=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(scrFile2, new File("./screenshots/Capture_UnSuccessful_Login.png"));
		
		}
}
}

