package scripts;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import pom.RegistrationPage_CreateValidAccount;

public class RegistrationPage_CreateValid_UserAccount {
	@Test
	
		public void CreateValidUserAccount_RegistrationPage() throws InterruptedException, IOException {
			//script to instantiate the web browser and launch the URL// 
		    System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://ksrtc.in/oprs-web/user/add.do");
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			
			//New object is created to call the methods created in the POM class//
			RegistrationPage_CreateValidAccount R=new RegistrationPage_CreateValidAccount(driver);
			PageFactory.initElements(driver, R);
			
			//Passing the values for the elements//
			R.getUserName_Email("reply2vencatraz@gmail.com","Venkatraja", "7406750669");
			
			//clicks on Add button//
			R.clickAddButton();
						
			//Wait statement is implemented to check the success message//
			WebDriverWait wait=new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='successmsg']")));
			String text=driver.findElement(By.xpath("//div[@id='successmsg']")).getText();
			Reporter.log(text, true);
			
			//script to capture the screenshot evidence that the new user account is created//
			File scrFile1=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile1, new File("./screenshots/CaptureNewUserAccountSuccess.png"));
			
			//quits the browser session//
			driver.quit();
}
			
		}
	

