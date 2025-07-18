package marathon;

import java.time.Duration;
//import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Amazon
{
	public static void main(String[] args)
	throws InterruptedException
		{
				EdgeDriver driver=new EdgeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
			 //load URL
	        driver.get("https://www.amazon.in/");
	        
	        //search bag
	        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Bags for boys");
	        driver.findElement(By.id("nav-search-submit-button")).click();

	        //Print total
	        WebElement resultstext = driver.findElement(By.xpath("//h2[@class='a-size-base a-spacing-small a-spacing-top-small a-text-normal']"));
	        System.out.println("Total Results: " + resultstext.getText());

	        //Select the first 2 brands
	        driver.findElement(By.xpath("//li[@id='p_123/648962']//i")).click();
	        driver.findElement(By.xpath("//li[@id='p_123/418063']//i")).click();
	        Thread.sleep(2000);	        

	        //Sort new arrivals
	        WebElement sort = driver.findElement(By.xpath("//span[@class='a-button-text a-declarative']"));
	        sort.click();
	        WebElement newarrival = driver.findElement(By.xpath("//a[text()='Newest Arrivals']"));
	        newarrival.click();

	        //Print first bag brand name and discounted price
	        Thread.sleep(3000); 
	        WebElement Bagname = driver.findElement(By.xpath("//div[@class='a-row a-size-base a-color-secondary']"));
	        WebElement Bagprice = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]"));
	        System.out.println("First Bag Name: " + Bagname.getText());
	        System.out.println("First Bag Price: ₹" + Bagprice.getText());

	        //print page title
	        System.out.println("Page Title: " + driver.getTitle());
	        
	        //driver.close();
	    }
	}

