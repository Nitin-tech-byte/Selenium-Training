package seleniumTraining;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingMultipleWindows {

	public static void main(String[] args) throws InterruptedException {


		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("http://www.seleniumframework.com/Practiceform/");
		
		String mainwindow = driver.getWindowHandle();
		System.out.println(driver.getTitle());
		driver.findElement(By.id("button1")).click();
		Set<String> windows = driver.getWindowHandles();
		
		String childwindow = null;
		for (String string : windows) {
			if (!(string.equalsIgnoreCase(mainwindow)))
			{
				childwindow = string;
			}
			
		}
		System.out.println(driver.switchTo().window(childwindow).getTitle());
		driver.switchTo().window(childwindow);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.close();
		driver.switchTo().window(mainwindow);
		Set<String> windows1 = driver.getWindowHandles();
		
		for (String string : windows1) {
			System.out.println(driver.getTitle());
			
		}
		
		if (windows1.size()>1)
			{
				System.out.println("There are windows opened other than mainwindow");
			}
			else
			{
				if (windows1.equals(mainwindow))
				{
					System.out.println("There is only one mainwindow opened");
				}
				else
				{
					System.out.println("There is new window opened which is not mainwindow");
					
					}
				}
			
			
		
		
		
		driver.findElement(By.xpath("//*[text() = 'New Browser Tab']")).click();
		
		//ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		ArrayList<String> tabs = new ArrayList <String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		System.out.println(driver.getTitle());
		
		Thread.sleep(3000);
		driver.close();
		
		
		
		



	}

}
