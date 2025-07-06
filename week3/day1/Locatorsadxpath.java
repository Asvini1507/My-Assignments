package week3.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.Select;

public class Locatorsadxpath {

	public static void main(String[] args)
	{
	    EdgeOptions options=new EdgeOptions();
		options.addArguments("guest");		
		EdgeDriver driver=new EdgeDriver(options);		
		driver.get("http://leaftaps.com/opentaps/control/main");		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));		
		
		driver.findElement(By.xpath("//label[text()='Username']/following-sibling::input")).sendKeys("demosalesmanager");
		driver.findElement(By.xpath("//label[text()='Password']/following-sibling::input")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
		driver.findElement(By.xpath("//div[@id='label']/a")).click();
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		driver.findElement(By.xpath("//a[text()='Create Lead']")).click();
		driver.findElement(By.xpath("//input[@id='createLeadForm_companyName']")).sendKeys("test leaf");
		driver.findElement(By.xpath("//input[@id='createLeadForm_companyName']/following::input")).sendKeys("jai");
		driver.findElement(By.xpath("//input[@id='createLeadForm_firstName']/following::input")).sendKeys("k");
		driver.findElement(By.xpath("//input[@name='parentPartyId']/following::input")).sendKeys("asvini");
		
		WebElement source= driver.findElement(By.xpath("//span[text()='Source']/following::select"));
		Select obj=new Select(source);
		obj.selectByValue("LEAD_EMPLOYEE");
		System.out.println(driver.getTitle());
		}

}
