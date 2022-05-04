package April_08;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateIncident {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://dev113059.service-now.com/login.do");
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("@Dtc1515016");
		driver.findElement(By.id("sysverb_login")).click();
		driver.findElement(By.cssSelector("#filter")).sendKeys("incident"); 
		
		driver.findElement(By.linkText("Create New")).click();
		driver.switchTo().activeElement().findElement(By.xpath("//a[@id='lookup.incident.short_description']//span[1]")).click();
//		driver.findElement(By.xpath("(/a[@id='lookup.incident.short_description']//span[1]")).click();
//		driver.findElement(By.cssSelector("#sysverb_insert_bottom")).click(); 

	}

}
