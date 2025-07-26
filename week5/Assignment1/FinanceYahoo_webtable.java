package week5.Assignment1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class FinanceYahoo_webtable
{
	public static void main(String[] args) 
	throws InterruptedException
		{
				EdgeDriver driver=new EdgeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				
			 //load URL
	        driver.get("https://finance.yahoo.com/");
	        Thread.sleep(3000);
	        
	        // Click on the Crypto
	        WebElement more = driver.findElement(By.className("_yb_98mz12"));
	        Actions action = new Actions(driver);
	        action.moveToElement(more).perform();
	        Thread.sleep(3000);
	        driver.findElement(By.xpath("//a[@aria-label='Finance: Crypto']")).click();
	        Thread.sleep(3000);
	        
	        //locate the table
	        WebElement table= driver.findElement(By.xpath("//table[@class='yf-ao6als bd']/tbody"));
	        Thread.sleep(3000);
	        
	        // Get all the rows of the table
	        List<WebElement> rows = table.findElements(By.tagName("tr"));
	        System.out.println("Cryptocurrency:");
	        Thread.sleep(3000);

	        // Loop for rows starts from 1
	        for (int i = 1; i < rows.size(); i++)
	        {
	            List<WebElement> column = rows.get(i).findElements(By.tagName("td"));
	            
	            if (column.size() >= 2)
	            {
	                // First column 
	                String cryptosymbol= column.get(0).getText();
	                // Second column 
	                String cryptonames = column.get(1).getText();
	                
	                System.out.println("SYMBOL: " + cryptosymbol + ", NAME: " + cryptonames);
	            }
	        }

	        // Close the browser
	        driver.quit();
	    	}
}
