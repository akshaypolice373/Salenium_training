package TestNg;

import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class CreateLead extends CommonCode {
 
	@Test
	public void createLead() {
		System.out.println("first");
		
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Hari");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("R");
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("99");
		driver.findElement(By.name("submitButton")).click();
		driver.close();
}
	
	@Test
	@Parameters({"URL"})
	public void acceptParameter(String urlname) {
		System.out.println("Second");
		System.out.println("This is the urlname I login "+ urlname);
	}
}







