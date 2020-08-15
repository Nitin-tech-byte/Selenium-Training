package seleniumTraining;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Thread.sleep(4000); - this is not recommended
		/* Implicit wait and Explicit wait
		 * Implicit wait is applicable for all the elements
		 * Whenever you define driver declare implicit wait
		 * Explicit wait is specific to element
		 * 
		 * fluent wait - 
		 * Drag And Drop
		 * Calendar
		 */
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement element = driver.findElement(By.id("btnLogin"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("submit"))).click();
		
		/*Fluent wait
		 * Fluent wait is used when we have to define maximum time for the WebDriver to wait for an element
		 * We can also define frequency in fluent wait
		 * There are 3 parts
		 * 1. Timeout - maximum time
		 * 2. Cooling - Frequency
		 * 3. Ignoring exceptions - you have provision where you can ignore some exceptions 
		 * 
		 */
		
		//Wait<WebDriver> fluentwait= new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS);
		//Wait<WebDriver> flueWait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS).pollingevery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException);
		
	
	}
}
