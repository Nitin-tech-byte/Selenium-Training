package seleniumTraining;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

//Actions class is built in feature and it is used to handle mouse and keyboard events
public class ActionsDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		
		Actions actions = new Actions(driver);
		
		Action seriesofaction = actions.moveToElement(driver.findElement(By.id("txtUsername"))).click().keyDown(Keys.SHIFT).sendKeys("admin").keyUp(Keys.SHIFT).doubleClick().build();
		seriesofaction.perform();
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		
				
		
		
		actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"menu_admin_viewAdminModule\"]/b"))).build().perform();
		actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"menu_admin_UserManagement\"]"))).build().perform();
		Thread.sleep(4000);
		actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"menu_admin_viewSystemUsers\"]"))).build().perform();
		
		
	}

}
