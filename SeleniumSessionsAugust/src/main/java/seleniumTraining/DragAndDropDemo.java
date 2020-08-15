package seleniumTraining;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDropDemo {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://demoqa.com/droppable");
		
		Actions actions = new Actions(driver);
		
		/*Drag the source as you want to drag and drop at the target
		 * 1. Identify the source element
		 * 2. Identify the destination element
		 * 3. Create an object of an Actions class
		 * 4. User drandAndDrop method
		 * 
		 * 
		 */
		actions.dragAndDrop(driver.findElement(By.id("draggable")), driver.findElement(By.id("droppable"))).build().perform();
			
	}

}
