package seleniumTraining;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NavigationDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		////driver.get - Go to URL and waits for the page to load
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		
		//Driver.navigate - go to URL but does not wait till page loads
		//Maintains driver history
		driver.navigate().to("https://www.google.com/");
		Thread.sleep(4000);
		driver.navigate().back();
		Thread.sleep(4000);
		driver.navigate().forward();
		Thread.sleep(4000);
		driver.quit();
	}

}
