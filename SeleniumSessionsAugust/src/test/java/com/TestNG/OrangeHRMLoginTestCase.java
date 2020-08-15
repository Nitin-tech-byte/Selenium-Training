package com.TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRMLoginTestCase {

	WebDriver driver;
	@BeforeMethod
	public void launchApp() {
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");

	}
	@Test(description = "oragngeHRMLogin")
	public void loginToApp() throws InterruptedException {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(3000);
	}
	@Test(description = "AdminPage")
	public void Admin() {
		driver.findElement(By.id("menu_admin_viewAdminModule")).click();
		driver.findElement(By.id("//*[@id=\"menu_admin_UserManagement\"]")).click();
		driver.findElement(By.id("//*[@id=\"menu_admin_viewSystemUsers\"]")).click();
		
		driver.findElement(By.id("btnAdd")).click();
		
	}



	@AfterMethod
	public void closeApp() {
		driver.close();
	}
}
