package week4.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Flipkart 
{
	public static void main(String[] args)
			throws InterruptedException
	{
			EdgeDriver driver=new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
		 //Open Flipkart
        driver.get("https://www.flipkart.com/");

        //Search bags
        driver.findElement(By.xpath("//input[@class='Pke_EE']")).sendKeys("bags",Keys.ENTER);
        Thread.sleep(1000);
        
        //Click Men under Gender 
        driver.findElement(By.xpath("//label[@class='tJjCVx _3DvUAf']")).click();
        Thread.sleep(1000);
        
        //Click Fashion Bags under Category 
        driver.findElement(By.xpath("//a[text()='Gym Bags']")).click();
        Thread.sleep(1000);
        
       //click black colour
        driver.findElement(By.xpath("//div[@class='_6i1qKy']")).click();
        Thread.sleep(1000);
            
        // print count items
        WebElement itemcount = driver.findElement(By.className("BUOuZu"));
        String Text = itemcount.getText();
        System.out.println("Total number of products: " +Text);

        //list of all brand names
        List<WebElement> brandlist = driver.findElements(By.className("syl9yP"));
        List<String> brand = new ArrayList<String>();
        for (WebElement total: brandlist) 
        {
        	String names= total.getText();
            brand.add(names);
        }
        System.out.println("\nList of Brands:" +brand);
        
        //list of bag names
        List<WebElement> baglist = driver.findElements(By.className("WKTcLC"));
        List<String> bag= new ArrayList<String>();
        for (WebElement all : baglist)
        {
            String names= all.getText();
            bag.add(names);
        System.out.println("\nList of Bag Names:" +bag);
        }

        // Close the browser
        //driver.quit();
    }
	}

