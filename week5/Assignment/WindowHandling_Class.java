package week5.Assignment;

import java.time.Duration;
//import java.util.ArrayList;
//import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class WindowHandling_Class 
{
	public static void main(String[] args)
			throws InterruptedException
	{
			EdgeDriver driver=new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
	        //load URL
		    driver.get("https://www.irctc.co.in/");

	        //Click FLIGHTS
		    driver.findElement(By.xpath("//button[text()='OK']")).click();
		    Thread.sleep(3000);
		    
		    driver.findElement(By.xpath("//button[@id='iz-optin-wp-btn1Txt']")).click();
		    Thread.sleep(3000);
	
		    WebElement flight= driver.findElement(By.xpath("//span[@class='allcircle circleone']"));
		    flight.click();
	        Thread.sleep(3000);
	        
	        //parent window handle
	        String parentWindow = driver.getWindowHandle();

	        //all window handles
	        Set<String> allWindows = driver.getWindowHandles();

	        for (String window : allWindows) 
	        {
	            if (!window.equals(parentWindow)) 
	            {
	                // Switch to child window
	                driver.switchTo().window(window);

	                // Print title of new window
	                System.out.println("Child Window Title: " + driver.getTitle());
	            }
	        }

	        // Close the parent tab
	        driver.switchTo().window(parentWindow);
	        driver.close();

	   }
	}
	        
	       
	    


