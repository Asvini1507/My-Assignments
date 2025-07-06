package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
//import org.openqa.selenium.support.ui.Select;

public class DeleteLead {

	public static void main(String[] args) 
	throws InterruptedException
	{
		EdgeOptions options=new EdgeOptions();
		options.addArguments("guest");
		EdgeDriver driver=new EdgeDriver(options);
		driver.get("http://leaftaps.com/opentaps/control/main");		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");		
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
        driver.findElement(By.partialLinkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.partialLinkText("Find Leads")).click();
		//driver.findElement(By.partialLinkText("Phone")).click();
		//driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("8248148521");
		driver.findElement(By.partialLinkText("Email")).click();
		driver.findElement(By.name("emailAddress")).sendKeys("kasvinibe1992@gmail.com");
		driver.findElement(By.id("ext-gen334")).click();
		
		Thread.sleep(3000);
	
		WebElement lead= driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
		String LeadID= lead.getText();
		System.out.println("LeadID" +LeadID);		
		
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.findElement(By.linkText("Delete")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.name("id")).sendKeys(LeadID);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		Thread.sleep(3000);
		
		WebElement message= driver.findElement(By.xpath("//div[@id='ext-gen437']"));
		String outputmessage= message.getText();
		if(outputmessage.equals("No records to display"))
		{
		   System.out.println("the id is deleted successfully");
		}
		else
		{
			System.out.println("the id is not deleted");
		}
		//driver.close();
	}
}
