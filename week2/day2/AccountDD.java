package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.Select;

public class AccountDD
{
     public static void main(String[] args) 
	{
	EdgeOptions options=new EdgeOptions();
	options.addArguments("guest");		
	EdgeDriver driver=new EdgeDriver(options);		
	driver.get("http://leaftaps.com/opentaps/control/main");		
	driver.manage().window().maximize();
	
	driver.findElement(By.id("username")).sendKeys("demosalesmanager");		
	driver.findElement(By.id("password")).sendKeys("crmsfa");
	driver.findElement(By.className("decorativeSubmit")).click();
    driver.findElement(By.partialLinkText("CRM/SFA")).click();
	driver.findElement(By.linkText("Accounts")).click();
	driver.findElement(By.linkText("Create Account")).click();
	driver.findElement(By.id("accountName")).sendKeys("Asvinijai");
	driver.findElement(By.name("description")).sendKeys("Selenium automation tester");
	
	WebElement marketing= driver.findElement(By.id("marketingCampaignId"));
	Select obj=new Select(marketing);
	obj.selectByIndex(6);
	
	WebElement industry= driver.findElement(By.name("industryEnumId"));
	Select obj1=new Select(industry);
    obj1.selectByValue("IND_SOFTWARE");
	
	WebElement ownership= driver.findElement(By.name("ownershipEnumId"));
	Select obj2=new Select(ownership);
	obj2.selectByVisibleText("S-Corporation");
	
	WebElement source= driver.findElement(By.name("dataSourceId"));
	Select obj3=new Select(source);
	obj3.selectByValue("LEAD_EMPLOYEE");
	
	WebElement state= driver.findElement(By.name("generalStateProvinceGeoId"));
	Select obj4=new Select(state);
	obj4.selectByValue("TX");
	
	driver.findElement(By.className("smallSubmit")).click();
	System.out.println(driver.getTitle());
	//driver.close();

}
}

