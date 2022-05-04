package facebookCreateAccount;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateAccount {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.linkText("Create New Account")).click();
		driver.findElement(By.name("firstname")).sendKeys("Akshay");
		driver.findElement(By.name("lastname")).sendKeys("Kumar");
		driver.findElement(By.name("reg_email__")).sendKeys("9036736074");
		driver.findElement(By.name("reg_passwd__")).sendKeys("@Akshay99");
		
//		Select Birthday Date
		WebElement dropdownHandle_1 = driver.findElement(By.name("birthday_day"));
		Select s1 = new Select(dropdownHandle_1);
		s1.selectByValue("23");
		
//		Select Birthday Month
		WebElement dropdownHandle_2 = driver.findElement(By.id("month"));
		Select s2 = new Select(dropdownHandle_2);
		s2.selectByIndex(2);

//		Select the Birthday Year
		WebElement dropdownHandle_3 = driver.findElement(By.id("year"));
		Select s3 = new Select(dropdownHandle_3);
		s3.selectByValue("1999");
		
		WebElement radioBtn = driver.findElement(By.name("sex"));
		Actions act1 = new Actions(driver);
		act1.moveToElement(radioBtn).click().perform();
		
		WebElement radioBtn_1 = driver.findElement(By.xpath("(//input[@class='_8esa'])[2]"));
		Actions act2 = new Actions(driver);
		act2.moveToElement(radioBtn_1).click().perform();
		
		
		driver.findElement(By.name("websubmit")).click();
		
	}
}
