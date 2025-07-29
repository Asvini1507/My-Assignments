package week5.Assignment2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class Actionclass_Snapdeal 
{
	public static void main(String[] args) 
			throws IOException, InterruptedException 
	{
		    EdgeDriver driver = new EdgeDriver();
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	        //Load Snapdeal
	        driver.get("https://www.snapdeal.com/");

	        Actions actions = new Actions(driver);
	       // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	        //Go to Men's Fashion
	        WebElement mensFashion = driver.findElement(By.xpath("//span[text()=\"Men's Fashion\"]"));
	        actions.moveToElement(mensFashion).perform();

	        //Click Sports Shoes
	        WebElement sportsShoes = driver.findElement(By.xpath("//span[text()='Sports Shoes']"));
	        sportsShoes.click();

	        //Get the count of sports shoes
	        WebElement count = driver.findElement(By.className("category-count"));
	        System.out.println("Number of sports shoes: " + count.getText());

	        //Click Training Shoes
	        driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();

	        //Sort Low to High
	        driver.findElement(By.className("sort-selected")).click();
	        driver.findElement(By.xpath("//li[@data-sorttype='plth']")).click();
	        Thread.sleep(3000); 

	        //Verify sorted order (check for first 2 items)
	        List<WebElement> prices = driver.findElements(By.className("product-price"));
	        if (prices.size() >= 2) 
	        {
	        	int price1 = Integer.parseInt(prices.get(0).getText().replaceAll("[^0-9]", ""));
	            int price2 = Integer.parseInt(prices.get(1).getText().replaceAll("[^0-9]", ""));
	            if (price1 <= price2) 
	            {
	                System.out.println("Sorted correctly");
	            } else
	            {
	                System.out.println("Sorting incorrect");
	            }
	        }

	        //Select price range
	        driver.findElement(By.name("fromVal")).clear();
	        driver.findElement(By.name("fromVal")).sendKeys("500");
	        driver.findElement(By.name("toVal")).clear();
	        driver.findElement(By.name("toVal")).sendKeys("700");
	        driver.findElement(By.xpath("//div[contains(@class,'price-go-arrow')]")).click();

	        Thread.sleep(3000);

	        //Filter color
	        driver.findElement(By.xpath("//label[contains(., 'White') and contains(., 'Blue')]")).click();
	        Thread.sleep(3000);

	        //Verify all filters applied
	        List<WebElement> filters = driver.findElements(By.xpath("//div[@class='filters']/div/a"));
	        System.out.println("Applied Filters:");
	        for (WebElement filter : filters) 
	        {
	            System.out.println("*" + filter.getText());
	        }

	        //Mouse hover on first result
	        WebElement firstShoe = driver.findElement(By.xpath("(//picture[@class='picture-elem'])[1]"));
	        actions.moveToElement(firstShoe).perform();

	        //Click Quick View
	        WebElement quickViewBtn = driver.findElement(By.xpath("(//div[contains(text(),'Quick View')])[1]"));
	        quickViewBtn.click();

	        // 13. Print cost and discount
	        WebElement price =driver.findElement(By.className("payBlkBig"));
	        WebElement discount = driver.findElement(By.className("percent-desc"));
	        System.out.println("Price: ₹" + price.getText());
	        System.out.println("Discount: " + discount.getText());

	        //Take screenshot
	        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        FileUtils.copyFile(src, new File("snapdeal_product.png"));

	        //Close windows
	        driver.close(); // Closes product pop-up
	        driver.quit();  // Closes main window
	   	}

}
