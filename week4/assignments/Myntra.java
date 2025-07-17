package week4.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Myntra {

	public static void main(String[] args) 
	throws InterruptedException
		{
				EdgeDriver driver=new EdgeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
			 //Open myntra
	        driver.get("https://www.myntra.com/");

	        //Search bags
	        driver.findElement(By.xpath("//input[@class='desktop-searchBar']")).sendKeys("bags",Keys.ENTER);
	        Thread.sleep(1000);
	        
	        //Click Men under Gender 
	        driver.findElement(By.xpath("//label[@class='common-customRadio gender-label']")).click();
	        Thread.sleep(1000);
	        
	        //Click Fashion Bags under Category 
	        driver.findElement(By.xpath("//label[@class='common-customCheckbox']")).click();
	        Thread.sleep(1000);
	       	                 
	        // print count items
	        WebElement itemcount = driver.findElement(By.className("title-container"));
	        String Text = itemcount.getText();
	        System.out.println("Total number of products: " +Text);

	        //list of all brand names
	        List<WebElement> brandlist = driver.findElements(By.className("product-brand"));
	        List<String> brand = new ArrayList<String>();
	        for (WebElement total: brandlist) 
	        {
	        	String names= total.getText();
	            brand.add(names);
	        }
	        System.out.println("\nList of Brands:" +brand);
	        
	        //list of bag names
	        List<WebElement> baglist = driver.findElements(By.className("product-product"));
	        System.out.println("\n List of bag names:");
	        for (WebElement bags : baglist)
	        {
	        System.out.println(bags.getText());
	        }
	        // Close the browser
	        //driver.quit();
	    }
			}
