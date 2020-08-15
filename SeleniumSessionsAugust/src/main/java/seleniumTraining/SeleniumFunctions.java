package seleniumTraining;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumFunctions {

	public static void main(String[] args) {

/*
 * get - Driver.get and Driver.getcurrenturl, driver.gettitle, driver.getwindowhandle, driver.getwindowhandles
 * locating links - By.linktext and By.partiallinktext
 * Dropdown - to handle drop down we are using Select class. First identify the drop down and then work on individual options 
 * 
 */
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://output.jsbin.com/osebed/2");
		System.out.println(driver.getCurrentUrl());
		//driver.findElement(By.id("btnLogin"));
		WebElement dropdown = driver.findElement(By.id("fruits"));
		
		Select dropdown_select = new Select(dropdown);//we are converting our webelement in Select option
		dropdown_select.selectByIndex(1);
		dropdown_select.selectByIndex(3);
		
		
		//dropdown_select.deselectByVisibleText("Apple");
		dropdown_select.deselectByVisibleText("Grape");
		

	}

}
