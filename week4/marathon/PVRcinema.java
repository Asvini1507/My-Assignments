package marathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class PVRcinema 
{
	public static void main(String[] args) 
	throws InterruptedException
		{
				EdgeDriver driver=new EdgeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
			//load URL
	        driver.get("https://www.pvrcinemas.com/");
	        
	       /* //select city
	        driver.findElement(By.xpath("//span[@class='sc-cMqPwU hDkxdu pointer']")).click();
	        Thread.sleep(2000);*/
	        
	        //click cinema
	        //driver.findElement(By.className("cinemas-inactive")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//span[text()='Cinema']")).click();
	        Thread.sleep(2000);
	        
	        //choose your cinema e.g first one
	        driver.findElement(By.xpath("//span[text()='Select Cinema']")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//li[@class='p-dropdown-item'][1]")).click();
	        
	        //select date as tomorrow
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//li[@class='p-dropdown-item'][3]")).click();
	        
	        //select your movie
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//li[@class='p-dropdown-item'][2]")).click();
	        
	        //select your timings
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//li[@class='p-dropdown-item'][2]")).click();
	        
	        //click book button
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//button[@class='p-button p-component sc-gNZgCX hrwxnG bgColor filter-btn']")).click();
	        
	        //click accept t&c
	        driver.findElement(By.xpath("//button[text()='Accept']")).click();
	        Thread.sleep(2000);
	        
	        //select seat
	        driver.findElement(By.xpath("//span[@id='SL.SILVER|I:26']")).click();
	        
	        //click proceed
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//button[@class='sc-dJkDXt bWYhCG btn-proceeded']")).click();
	        
	        //print seat info
	        Thread.sleep(2000);
	        WebElement seatinfo = driver.findElement(By.xpath("//div[@class='seat-info']"));
	        System.out.println("Seat Info: " + seatinfo.getText());
	        
	        //print total
	        Thread.sleep(2000);
	        WebElement grandtotal = driver.findElement(By.xpath("//div[@class='grand-tota col-md-3']"));
	        System.out.println("Grand Total: " + grandtotal.getText());
	        
	        //click proceed button
	        driver.findElement(By.xpath("//button[@class='fb-added-btndesk']")).click();
	        
	        //close pop-up
	        Thread.sleep(2000);
	        //driver.findElement(By.xpath("//div[@class='cross-icon mx-2'][2]")).click();
	        
	        //print current page
	        System.out.println(driver.getTitle());
	        Thread.sleep(2000);
	        
	        //close the browser
	        //driver.close();
		}
}
