package week2.day2;

import java.time.Duration;

//import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.Select;

public class EditLead {

	public static void main(String[] args) 
	{

		EdgeOptions options=new EdgeOptions();
		options.addArguments("guest");
		EdgeDriver driver=new EdgeDriver(options);
		driver.get("http://leaftaps.com/opentaps/control/main");		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");		
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
        driver.findElement(By.partialLinkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.xpath("//input[@id='createLeadForm_companyName']")).sendKeys("test leaf");
		driver.findElement(By.xpath("//input[@id='createLeadForm_firstName']")).sendKeys("asvini");
		driver.findElement(By.xpath("//input[@id='createLeadForm_lastName']")).sendKeys("k");
		driver.findElement(By.xpath("//input[@id='createLeadForm_firstNameLocal']")).sendKeys("vedha");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("sales");
		driver.findElement(By.id("createLeadForm_description")).sendKeys(" Identifying potential buyers (leads)");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("kasvinibe1992@gmail.com");
		
		WebElement state= driver.findElement(By.name("generalStateProvinceGeoId"));
		Select obj=new Select(state);
		obj.selectByVisibleText("New York");
		
		driver.findElement(By.name("submitButton")).click();
		driver.findElement(By.partialLinkText("Edit")).click();
		//driver.findElement(By.id("updateLeadForm_description")).clear();
		//driver.findElement(By.id("updateLeadForm_description")).sendKeys("presenting product service to customer");
		//driver.findElement(By.name("submitButton")).click();
		driver.findElement(By.xpath("//textarea[@id='updateLeadForm_description']")).clear();
		driver.findElement(By.xpath("//textarea[@id='updateLeadForm_description']")).sendKeys("Presenting product/service benefits to customers");
		driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
		System.out.println(driver.getTitle());
		//driver.close();

	}

}
