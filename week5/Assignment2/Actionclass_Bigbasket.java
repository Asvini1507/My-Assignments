package week5.Assignment2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class Actionclass_Bigbasket
{
	public static void main(String[] args)
			 throws InterruptedException, IOException 
	{
        //Launch Edge browser
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Load URL
        driver.get("https://www.bigbasket.com/");

        //Click Shop by Category
        WebElement Category = driver.findElement(By.xpath("//button[@id='headlessui-menu-button-:Ramkj6:']"));
        Category.click();

        //Mouse over Foodgrains, Oil & Masala
        Actions actions = new Actions(driver);
        WebElement foodgrains = driver.findElement(By.xpath("(//a[@role='none'])[6]"));
        actions.moveToElement(foodgrains).perform();
        Thread.sleep(3000);

        //Mouse over Rice & Products
        WebElement riceproducts = driver.findElement(By.xpath("//a[text()='Rice & Rice Products']"));
        actions.moveToElement(riceproducts).perform();
        Thread.sleep(3000);

        //Click Boiled & Steam Rice
        WebElement rice=driver.findElement(By.xpath("//a[text()='Boiled & Steam Rice']"));
        actions.click(rice).perform();
        Thread.sleep(3000);
                
        //Filter brand bb Royal
        WebElement brand=driver.findElement(By.xpath("(//span[@class='Label-sc-15v1nk5-0 FilterSelection___StyledLabel-sc-1d3okpu-0 gJxZPQ ffRDqB'])[3]"));
        actions.click(brand).perform();
        Thread.sleep(3000);
        
        WebElement brandbb = driver.findElement(By.xpath("//input[@id='i-bbRoyal']"));
        actions.click(brandbb).perform();
        Thread.sleep(3000);

        //Click Tamil Ponni Boiled Rice
        WebElement rice1= driver.findElement(By.xpath("//h3[text()='Tamil Ponni Boiled Rice']"));
        actions.click(rice1).perform();
        Thread.sleep(3000);

        //Switch to the new window
        Set<String> windows = driver.getWindowHandles();
        for (String window : windows)
        {
            driver.switchTo().window(window);
        }
        Thread.sleep(3000);

        //Print the price
        String price = driver.findElement(By.xpath("(//td[text()='₹1699'])[1]")).getText();
        System.out.println("Price of 26kg Tamil Ponni Boiled Rice: " + price);
        Thread.sleep(5000);

        //Click Addcart
        WebElement addButton = driver.findElement(By.xpath("//div[@class='flex flex-col lg:w-60 xl:w-82']/button"));
        actions.click(addButton).perform();
        Thread.sleep(3000);
        
        //verify message
        Thread.sleep(3000);
        WebElement confirmation = driver.findElement(By.xpath("//div[@class='flex flex-col lg:w-60 xl:w-82']//button"));
        if (confirmation.isDisplayed()) 
        {
            System.out.println("Item successfully added to cart");
        }
              
        //Take a snapshot
        Thread.sleep(3000);
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest = new File("BigBasketProductPage.png");
        FileUtils.copyFile(src, dest);
        System.out.println("Screenshot saved");

        //Close current product tab
        driver.close();
        driver.quit();
        
         }
	}
