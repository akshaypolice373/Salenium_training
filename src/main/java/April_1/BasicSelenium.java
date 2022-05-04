package April_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicSelenium {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://www.leaftaps.com/opentaps/control/login/");
		
		
		driver.manage().window().maximize();
		
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		driver.findElement(By.className("decorativeSubmit")).click();
		
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		driver.findElement(By.linkText("Leads")).click();
		
		driver.findElement(By.linkText("Create Lead")).click();
		
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("EY");
		
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Akshay");
		
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Kumar");
		
		
		
		WebElement industry = driver.findElement(By.id("createLeadForm_industryEnumId"));
		Select op = new Select(industry);
		op.selectByValue("IND_SOFTWARE");
		
		WebElement ownership = driver.findElement(By.id("createLeadForm_ownershipEnumId"));
		Select op1 = new Select(ownership);
		op1.selectByValue("OWN_PUBLIC_CORP");
		
		
		
	}
}
