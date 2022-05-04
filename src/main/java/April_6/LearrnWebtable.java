package April_6;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearrnWebtable {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://erail.in/");
		WebElement from = driver.findElement(By.id("txtStationFrom"));
		from.clear();
		from.sendKeys("Chennai Beach Jn");
		WebElement to = driver.findElement(By.id("txtStationTo"));
		to.clear();
		to.sendKeys("Mumbai Central");
		//to check the checkbox
		driver.findElement(By.id("chkSelectDateOnly")).click();
		
		 
        //Get the row size
		 List<WebElement> rows = driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr"));
		 int rowsize = rows.size();
		 System.out.println(rowsize);
		 //To print specific data
		WebElement  data = driver.findElement(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr[2]/td[2]"));
	      String text = data.getText();
	      System.out.println(text);
	      //Get the coloumSize
	    //to get the list of data use findElements
	      List<WebElement> coloumn = driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr[1]/td"));
	      int colsize = coloumn.size();
	      System.out.println(colsize);
	      
	      List<String> train =new ArrayList<String>();
	   for (int i = 1; i <rows.size(); i++) {//dynamic value will handle by["+i+"]
		   String trainname = driver.findElement(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr["+i+"]/td[2]")).getText();
				   
		   System.out.println(trainname);
		   if(trainname.contains("EXPRESS")) {
			   System.out.println("The train name with Express:"+trainname);
		   }
		
	}
	     
	      
	}

}
