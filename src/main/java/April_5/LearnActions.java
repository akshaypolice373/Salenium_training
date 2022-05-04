package April_5;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnActions {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		
//		Example 1 of MouseHover on object 
//		driver.get("https://www.myntra.com/");
//		WebElement mensfashion = driver.findElement(By.className("desktop-main"));
//		Actions builder=new Actions(driver);
//		builder.moveToElement(mensfashion).perform();
		
//		Example 2 of MouseHover on object
		
		driver.get("https://www.amazon.in/");
		Actions a = new Actions(driver);
		
//		composite Element
		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
		
//		Moves to specific element
		WebElement move = driver.findElement(By.cssSelector("a[id='nav-link-accountList']"));
		a.moveToElement(move).contextClick().build().perform();
		
	}

}
