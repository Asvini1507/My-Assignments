package marathon2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.sukgu.Shadow;

public class ServiceNowapp {

	public static void main(String[] args) 
			 throws InterruptedException
	{
		
		EdgeDriver driver= new EdgeDriver();
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://dev209663.service-now.com/");

        //Login
        driver.findElement(By.id("user_name")).sendKeys("admin");
        driver.findElement(By.id("user_password")).sendKeys("qy/Q6A=vOM3x"); 
        driver.findElement(By.id("sysverb_login")).click();
        Thread.sleep(2000);
        
      //Handle Shadow DOM using Shadow Library
        Shadow shadow = new Shadow(driver);
        shadow.setImplicitWait(10);

        //Click All
        //shadow.findElementByXPath("//div[text()='All']");
        //Thread.sleep(2000);
        //shadow.findElementByXPath("//input[@id='filter']").sendKeys("Incidents");
        //WebElement incident = shadow.findElementByXPath("//mark[text()='Incidents']");
        //incident.click();
        shadow.findElementByXPath("//div[text()='All']").click();
		shadow.findElementByXPath("//span[text()='Incidents']").click();
		Thread.sleep(2000);
        
        //Switch to iframe
        WebElement iframe = shadow.findElementByXPath("//iframe[@id='gsft_main']");
        driver.switchTo().frame(iframe);
        
        driver.findElement(By.xpath("//button[@id='sysverb_new']")).click();
        String text= driver.findElement(By.xpath("//input[@id='incident.number']")).getAttribute("value");
        System.out.println("Incident Number:"+text);
        
        driver.findElement(By.xpath("//input[@id='incident.short_description']")).sendKeys("created via automation");
        driver.findElement(By.xpath("//button[@id='sysverb_insert']")).click();
        driver.switchTo().defaultContent();
        
        //Verify the newly created incident number
        WebElement iframe1 = shadow.findElementByXPath("//iframe[@title='Main Content']");
        driver.switchTo().frame(iframe1);
        WebElement dropdown = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']"));
        Select sel=new Select(dropdown);
    	sel.selectByVisibleText("Number");
    	driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(text,Keys.ENTER);
        driver.switchTo().defaultContent();
        
        //Verify Exist number
        WebElement iframe2 = shadow.findElementByXPath("//iframe[@id='gsft_main']");
        driver.switchTo().frame(iframe2);
        Thread.sleep(3000);
        String text1=driver.findElement(By.xpath("//a[@class='linked formlink']")).getText();
        System.out.println("the verified incident number is" +text1+ "and both matches");
        
        //close
        driver.close();
        }
}
		

	


