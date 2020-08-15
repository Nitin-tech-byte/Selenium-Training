package seleniumTraining;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchingApplication {

	public static void main(String[] args) throws InterruptedException {
		
		
		//set up ChromeDriver
		WebDriverManager.chromedriver().setup();
		
		//WebDriverManager.firefoxdriver().setup();
		//WebDriver driver = new FirefoxDriver();
		
		//Launch ChromeBrowser
		WebDriver driver = new ChromeDriver();
		
		
		//Launch URL
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		
		//Login to Website
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.id("menu_admin_viewAdminModule")).click();
		driver.findElement(By.id("//*[@id=\"menu_admin_UserManagement\"]")).click();
		driver.findElement(By.id("//*[@id=\"menu_admin_viewSystemUsers\"]")).click();
		//Navigate to Users
		
		
		//Navigate to Add User
		//driver.findElement(By.id("btnAdd")).click();
		
		//Enter User details
		/*driver.findElement(By.id("systemUser_employeeName_empName")).sendKeys("Fiona Grace");
		driver.findElement(By.id("systemUser_userName")).sendKeys("ni3ti");
		driver.findElement(By.id("systemUser_status")).sendKeys("Disabled");
		driver.findElement(By.id("systemUser_password")).sendKeys("nitin@123");
		driver.findElement(By.id("systemUser_confirmPassword")).sendKeys("nitin@123");
		Thread.sleep(3000);
		driver.findElement(By.id("btnSave")).click();*/
		
		Thread.sleep(4000);
		
		/*List<WebElement> totalRowCount = driver.findElements(By.xpath("//*[@id=\"resultTable\"]/tbody/tr"));
		
		System.out.println(totalRowCount.size());	
		String username = driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr[2]/td[2]/a")).getText();
		System.out.println(username);
		
		for (int i = 1; i < totalRowCount.size(); i++)
		{
			String username1 = driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr[i]/td[2]/a")).getText();
			if (username.equals("steven.edwards"))
			{
				System.out.println("username steven.edwards is present");
			}
		}*/
		
		WebElement usertable = driver.findElement(By.id("resultTable"));
		
		List <WebElement> row = usertable.findElements(By.tagName("tr"));
		
		List <WebElement> cols = usertable.findElements(By.tagName("td"));
		
		
		for (int r = 0; r<cols.size(); r++)
		{
			String username = cols.get(r).getText();
			System.out.println(username);
					
		}
	 	
		//Logout from the Website
		driver.findElement(By.id("welcome")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"welcome-menu\"]/ul/li[2]/a")).isEnabled();
		
				
		
		Thread.sleep(3000);
		
		//WebDriver driver = new WebDriver();
		driver.quit();
		
		
	}

}
