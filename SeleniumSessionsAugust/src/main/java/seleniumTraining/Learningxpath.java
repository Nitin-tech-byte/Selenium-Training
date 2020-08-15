package seleniumTraining;

import java.sql.Driver;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Learningxpath {

	public static void main(String[] args) {
		/* 2 types of xpaths - absolute and relative
		 * Always use relative xpath
		 * 
		 * xpath = //HTML tagname[@Attribute='value of the attribute']
		 * //input[@id='txtUsername']   - using id
		 * //input[@name='txtUsername'] - using name
		 * //input[contains(@id, 'Username')] - using contains method for fields without label
		 * //div[@id='divLoginButton' or @id='btnsubmit'] - using or
		 * //div[@id='divLoginButton' and @id='btnsubmit'] - using and - both value should match
		 * //input[starts-with(@id,'txt')]  - starts - with - all the elements starting with same
		 * (//a[text()='linda.anderson'] //parent::td//parent::tr//child::td)[1] - using parent child
		 * //a[text()='linda.anderson'] //ancestor::tr//child::td - using ancestor
		 * Parent will return you immediate parent
		 * Ancestor will return you entire family
		 * 
		 * 
		 */
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");;
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		driver.findElement(By.xpath("//b[text() = 'Admin']")).click();
		
		List<WebElement> users = driver.findElements(By.xpath("//div[@id='tableWrapper']//td[2]"));
		
		String usertofind = "fiona.grace";
		Boolean userstatus = false;
		for (WebElement webElement : users) {
			if ((webElement.getText().equals(usertofind)))
			{
				userstatus = true;
			}
					
		}
		if (userstatus)
		{
			System.out.println("user is present in the list");
		}
		else
		{
			System.out.println("user is not present in the list");
		}
		
		
		

	}

}
