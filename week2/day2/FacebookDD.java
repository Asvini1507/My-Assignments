package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.Select;

public class FacebookDD {

	public static void main(String[] args)
	{
		EdgeOptions options=new EdgeOptions();
		options.addArguments("guest");		
		EdgeDriver driver=new EdgeDriver(options);		
		driver.get("https://en-gb.facebook.com/");		
		driver.manage().window().maximize();
		
		driver.findElement(By.partialLinkText("Create new account")).click();	
		driver.findElement(By.name("firstname")).sendKeys("Asvini");
		driver.findElement(By.name("lastname")).sendKeys("Kalirajan");
		driver.findElement(By.name("reg_email__")).sendKeys("kasvinibe1992@gmail.com");
		driver.findElement(By.name("reg_passwd__")).sendKeys("Kavin2620!)");
		driver.findElement(By.id("sex")).click();
		
		WebElement day= driver.findElement(By.id("day"));
		Select obj=new Select(day);
		obj.selectByValue("1");
		
		WebElement month= driver.findElement(By.id("month"));
		Select obj1=new Select(month);
	    obj1.selectByVisibleText("Oct");
	    
		WebElement year= driver.findElement(By.id("year"));
		Select obj2=new Select(year);
		obj2.selectByValue("1982");
		
		driver.findElement(By.name("websubmit")).click();
		System.out.println(driver.getTitle());
		//driver.close();

	}

}
