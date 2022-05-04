package april_23;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UpdateExistingIncident {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub //INC0010001
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://dev119688.service-now.com/login.do");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
		
		String urgencyTab = "1 - High";
		String stateTab = "In Progress";
		String priority = "3 - Moderate";
		
		/*
		 * // 2. Check for frame WebElement frame =
		 * driver.findElement(By.id("gsft_main")); driver.switchTo().frame(frame);
		 */
		 
		 // 2. Enter username 
		 driver.findElement(By.id("user_name")).sendKeys("admin");
		 
		 // 3. Enter password 
		 driver.findElement(By.id("user_password")).sendKeys("Newpass@123");
		 
		 // 4. Enter login
		 driver.findElement(By.id("sysverb_login")).click();		 
		 Thread.sleep(3000);
		 
		 // 5. Search “incident “ Filter Navigator
		 driver.findElement(By.id("filter")).sendKeys("incident",Keys.ENTER);
		 
		 // 6. Click “All”
		 driver.findElement(By.xpath("(//div[text()='All'])[2]")).click();
		 
		 // Switch to frame
		 driver.switchTo().frame(0);
		 
		 //7.Search for the existing incident click on the incident
		 driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys("INC0010001",Keys.ENTER);
		 
		 //8.click on incident
		 driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		
		 //9.Update the incidents with Urgency as High
		 WebElement findElement = driver.findElement(By.xpath("//select[@id='incident.urgency']"));
		 Select op=new Select(findElement);
		 op.selectByVisibleText(urgencyTab);
		 
		 //10.State as In Progress
		 WebElement findElement2 = driver.findElement(By.xpath("//select[@id='incident.state']"));
		 Select op1=new Select(findElement2);
		 op1.selectByVisibleText(stateTab);
		 
			
		//11.save
	    driver.findElement(By.xpath("//button[@id='sysverb_update_bottom']")).click();
	    
	  //12.Verify the priority and state 
	    String priorityVariable = driver.findElement(By.xpath("//table/tbody/tr/td[7]")).getText();
	    
//	    System.out.println(priorityVariable + " = " + priority);
	    
	    String stateVariable = driver.findElement(By.xpath("//table/tbody/tr/td[8]")).getText();
	    
//	    System.out.println(stateVariable + " = " + stateTab);
	    
	    if(priorityVariable.equals(priority) && stateVariable.equals(stateTab)) {
	    	System.out.println("Verified");
	    } else {
	    	System.out.println("Priority or state columns are not as expected, Please update");
	    }
	    
	    System.out.println("done");
			 
		 
		
		
	    // Close the Web Page
		 Thread.sleep(2000);
//		 driver.close();		
		
		
		
		
	}

}