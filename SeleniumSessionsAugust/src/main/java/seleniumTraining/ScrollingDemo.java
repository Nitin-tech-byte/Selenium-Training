package seleniumTraining;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollingDemo {

	public static void main(String[] args) {


		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		
		//Login to Website
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.id("menu_admin_viewAdminModule")).click();
		driver.findElement(By.id("//*[@id=\"menu_admin_UserManagement\"]")).click();
		driver.findElement(By.id("//*[@id=\"menu_admin_viewSystemUsers\"]")).click();
		
		WebElement target = driver.findElement(By.xpath("//*[@id=\\\"resultTable\\\"]/tbody/tr[10]/td[2]/a"));	
		JavascriptExecutor jscexe = (JavascriptExecutor)driver;
		jscexe.executeScript("window.scrollBy(0, 1000)");//Scroll by 1000 pixels down//first one is X axis and second one is Y axis
		//If X axis value is Negative then it will scroll to left and viceversa
		//If Y axis value is positive then it will scroll down and if it is Negative then it will scroll to up
		jscexe.executeScript("window.scrollTo(0, document.body.scrollHeight)");//This will scroll till the end of page
		
		jscexe.executeScript("arguments[0].scrollIntoView(true);", target);

	}

}
