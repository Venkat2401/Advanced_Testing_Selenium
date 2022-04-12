package generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class testclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow/");
	driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
	
	WebElement menu=driver.findElement(By.xpath("//select[@title='Number of dependants']"));
	Select select=new Select(menu);
	select.selectByIndex(2);
	
	boolean applicationtype_Single=driver.findElement(By.xpath("//input[@id='application_type_single']")).isSelected();
	if(applicationtype_Single==true) {
		System.out.println("Single is selected");
	}
	else {
		System.out.println("Single is not selected");
	}

	driver.findElement(By.xpath("//input[@aria-labelledby='q2q1']")).sendKeys("50000");
	
	}

	
	
}
