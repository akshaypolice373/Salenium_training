package April_6;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.SendKeysAction;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContactAssignment {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://leaftaps.com/opentaps/control/login");		
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.xpath("//a[contains(text(), 'CRM/SFA')]")).click();
		driver.findElement(By.xpath("//a[contains(text(), 'Contacts')]")).click();
		driver.findElement(By.xpath("//a[contains(text(), 'Merge Contacts')]")).click(); 
		driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iterate = windows.iterator();
		String parentId = iterate.next();
		String childId = iterate.next();
		driver.switchTo().window(childId);
		driver.findElement(By.xpath("//a[contains(text(), '10301')]")).click();
		driver.switchTo().window(parentId);		
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		Set<String> windows1 = driver.getWindowHandles();
		Iterator<String> iterate1 = windows1.iterator();
		String parentId1 = iterate1.next();
		String childId1 = iterate1.next();
		driver.switchTo().window(childId1);
		driver.findElement(By.xpath("//a[contains(text(), '10303')]")).click();
		driver.switchTo().window(parentId1);
		driver.findElement(By.className("buttonDangerous")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		System.out.println(driver.getTitle());	
	}
}
