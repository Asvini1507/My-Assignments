package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class ListCollection_amazon 
{
	public static void main(String[] args)
	throws InterruptedException
	{
			EdgeDriver driver=new EdgeDriver();
			driver.get("https://www.amazon.in");		
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			// Search for phones
	        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("mobile phones");
	        driver.findElement(By.id("nav-search-submit-button")).click();
	        Thread.sleep(3000);

	        // Find all price 
	        List<WebElement> priceElements = driver.findElements(By.xpath("//span[@class='a-price-whole']"));

	        // Store integer prices in a list
	        List<Integer> priceList = new ArrayList<>();
	        for (WebElement priceElement : priceElements) 
	        {
	            String pricetext = priceElement.getText();
	            String replaceall= pricetext.replaceAll(",","");
	            int price = Integer.parseInt(replaceall);
	            priceList.add(price);
	                }
	                
	        // Print all prices
	        System.out.println("All phone prices found on page:");
	        for (int price : priceList)
	        {
	            System.out.println("₹" + price);
	        }

	        // Sort and print the lowest price
	            
	        Collections.sort(priceList);
	        System.out.println("\nLowest Price:" + priceList.get(0));
	       
	        // Close the browser
	        //driver.quit();
	   	}

}
