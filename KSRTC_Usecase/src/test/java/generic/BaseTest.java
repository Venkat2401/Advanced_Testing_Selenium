package generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest implements AutoConst{ //abstract class 'BaseTest' is defined//
public WebDriver driver;
	
/*Defining below 'TestNG annotations' for launching the browser and the application URL.
Calling out the Key and Value for Browser executables and implementing the Synchronization
with 'implicitlyWait'condition.

The below scripts is a one time code which will run automatically for all the test scripts
and hence it is a 'Method-driven' framework and leveraging better code optimization.
*/

@BeforeMethod
	public void Lauch_Browser() {
		System.setProperty(CHROME_KEY, CHROME_VALUE);
		driver=new ChromeDriver(); //using Browser class ChromeDriver//
		driver.manage().window().maximize();
		//driver.get(BaseURL);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

@AfterMethod
	public void close_Browser() {
		driver.quit();
	}
}