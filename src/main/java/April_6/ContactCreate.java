package April_6;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ContactCreate {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://leaftaps.com/opentaps/control/login");		
		driver.findElement(By.id("usernam")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.xpath("//a[contains(text(), 'CRM/SFA')]")).click();
		driver.findElement(By.xpath("//a[contains(text(), 'Contacts')]")).click();
		driver.findElement(By.xpath("//a[contains(text(), 'Create Contact')]")).click();
		driver.findElement(By.id("firstNameField")).sendKeys("Akshay");
		driver.findElement(By.id("lastNameField")).sendKeys("Kumar");
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("Akshay");
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("Kumar");
		driver.findElement(By.id("createContactForm_departmentName")).sendKeys("SDET");
		driver.findElement(By.id("createContactForm_description")).sendKeys("Akshay kumar is assigned to the SDET competency");
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("akshaypolice373@gmail.com");
		WebElement d = driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
		Select options = new Select(d);
		options.selectByVisibleText("New York"); 
		driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
		driver.findElement(By.xpath("//a[contains(text(), 'Edit')]")).click();
		driver.findElement(By.id("updateContactForm_description")).clear();
		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("This is Important");
		driver.findElement(By.xpath("//input[@value='Update']")).click();
//		System.out.println(driver.getTitle());
		System.out.println(driver.findElement(By.tagName("title")).getText());
	}

}
