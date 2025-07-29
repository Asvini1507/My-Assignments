package week5.Assignment2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class Actionclass_Amazon 
{
	  public static void main(String[] args)
			  throws IOException, InterruptedException 
	  {
	        //Initialize EdgeDriver
	        EdgeDriver driver = new EdgeDriver();
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	        //Load the URL
	        driver.get("https://www.amazon.in/");

	        //Search oneplus 9 pro
	        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
	        searchBox.sendKeys("oneplus 9 pro mobile");
	        searchBox.submit();

	        //print the price of the first product
	        WebElement firstProductPrice = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]"));
	        System.out.println("Price of first product: ₹" + firstProductPrice.getText());

	        //Get number of customer ratings for first product
	        WebElement ratings = driver.findElement(By.xpath("(//span[@class='a-size-base s-underline-text'])[1]"));
	        System.out.println(" No.of Customer ratings: " + ratings.getText());
	        
	        //Click Add to Cart button
	        WebElement addtocart =driver.findElement(By.xpath("(//button[text()='Add to cart'])[1]"));
	        addtocart.click();
	        Thread.sleep(2000);
	        
	        //Click first text link of the first image
	        WebElement firstProductLink = driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-fixed-height'])[1]"));
	        Actions actions = new Actions(driver);
	        actions.moveToElement(firstProductLink).click().perform();

	        //Switch to new tab
	        for (String handle : driver.getWindowHandles())
	        {
	            driver.switchTo().window(handle);
	        }

	        //Take a screenshot
	        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        File destFile = new File("OnePlus9Pro_Screenshot.png");
	        FileUtils.copyFile(srcFile, destFile);
	        System.out.println("Screenshot taken.");
	        Thread.sleep(2000);     
	              
	        //print cart total
	        driver.findElement(By.xpath("//div[@id='nav-cart-count-container']")).click();
	        WebElement cartSubtotal = driver.findElement(By.id("sc-subtotal-amount-activecart"));
	        System.out.println("Cart subtotal: " + cartSubtotal.getText());

	        //Close browser
	        driver.quit();
	    }
	}
	

