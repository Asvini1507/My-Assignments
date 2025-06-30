package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.Select;

public class Dropdown {

	public static void main(String[] args) {
		 EdgeOptions options=new EdgeOptions();
			options.addArguments("guest");		
			EdgeDriver driver=new EdgeDriver(options);		
			driver.get("http://leaftaps.com/opentaps/control/main");		
			driver.manage().window().maximize();
			
			driver.findElement(By.id("username")).sendKeys("demosalesmanager");		
			driver.findElement(By.id("password")).sendKeys("crmsfa");
			driver.findElement(By.className("decorativeSubmit")).click();
	        driver.findElement(By.partialLinkText("CRM/SFA")).click();
			driver.findElement(By.linkText("Leads")).click();
			driver.findElement(By.linkText("Create Lead")).click();
			driver.findElement(By.id("createLeadForm_companyName")).sendKeys("selenium");
			driver.findElement(By.id("createLeadForm_firstName")).sendKeys("asvini");
			driver.findElement(By.id("createLeadForm_lastName")).sendKeys("k");
			
			WebElement source= driver.findElement(By.id("createLeadForm_dataSourceId"));
			Select obj=new Select(source);
			obj.selectByIndex(4);
			
			WebElement industry= driver.findElement(By.id("createLeadForm_industryEnumId"));
			Select obj1=new Select(industry);
			obj1.selectByValue("IND_FINANCE");
			
			WebElement ownership= driver.findElement(By.id("createLeadForm_ownershipEnumId"));
			Select obj2=new Select(ownership);
			obj2.selectByVisibleText("S-Corporation");
			
			driver.findElement(By.name("submitButton")).click();
			System.out.println(driver.getTitle());
			//driver.close();

		}
		}
