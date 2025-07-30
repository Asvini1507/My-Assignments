package marathon2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TATACLIQ1 {

	public static void main(String[] args) 
			throws InterruptedException, IOException 
	{
		        // Setup ChromeDriver
		        EdgeDriver driver = new EdgeDriver();
		        driver.manage().window().maximize();
		        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
		        
		        //Load the URL
		        driver.get("https://www.tatacliq.com/");
		        
		        //Hover on Brands
		        Actions action = new Actions(driver);
		        WebElement brandsMenu = driver.findElement(By.xpath("//div[text()='Brands']"));
		        action.moveToElement(brandsMenu).perform();
		        Thread.sleep(2000);

		        //Hover on Watches & Accessories
		        WebElement watches = driver.findElement(By.xpath("//div[text()='Watches & Accessories']"));
		        action.moveToElement(watches).perform();
		        Thread.sleep(2000);

		        //Click first option Featured Brands
		        WebElement firstBrand = driver.findElement(By.xpath("(//div[@class='DesktopHeader__brandsDetails'])[1]"));
		        action.click(firstBrand).perform();
		        Thread.sleep(2000);

		        //Sort by New Arrivals
		        WebElement sortDropdown = driver.findElement(By.xpath("//select[@class='SelectBoxDesktop__hideSelect']"));
		        Select selectSort = new Select(sortDropdown);
		        selectSort.selectByVisibleText("New Arrivals");
		        Thread.sleep(2000);

		        //Choose Men from Category filter
		        WebElement menFilter = driver.findElement(By.xpath("(//div[@class='FilterDesktop__newFilName'])[1]"));
		        menFilter.click();
		        Thread.sleep(3000); 

		        //Print all watch prices
		        List<WebElement> priceList = driver.findElements(By.xpath("//div[@class='ProductDescription__priceHolder']/h3"));
		        System.out.println("Watch Prices:");
		        for (WebElement price : priceList) 
		        {
		            System.out.println("*" + price.getText());
		        }

		        //Click on first watch
		        WebElement firstWatch = driver.findElement(By.xpath("(//div[@class='ProductModule__content'])[1]"));
		        action.click(firstWatch).perform();
		        Thread.sleep(2000);

		        // Switch to new tab
		        Set<String> allWindows = driver.getWindowHandles();
		        ArrayList<String> winList = new ArrayList<>(allWindows);
		        driver.switchTo().window(winList.get(1));

		        //Compare two prices (offer price vs MRP)
		        WebElement actualprice = driver.findElement(By.xpath("//div[@class='ProductDetailsMainCard__price']//h3"));
		        WebElement discountprice = driver.findElement(By.xpath("//span[@class='ProductDescriptionPage__offerprice']"));
		        String MRP = actualprice.getText().replaceAll("[^0-9]", "");
		        String offer = discountprice.getText().replaceAll("[^0-9]", "");
		        System.out.println("MRP: ₹" + MRP);
		        System.out.println("Offer: ₹" + offer);
		        if (MRP.equals(offer)) 
		        {
		            System.out.println("Price is same");
		        } else 
		        {
		            System.out.println("Price is different");
		        }

		        //Take a snapshot
		        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		        FileUtils.copyFile(src, new File("tatacliq_watch.png"));

		        //Click Add to Cart and get count
		        WebElement addToCart= driver.findElement(By.xpath("(//div[@class='ProductDescriptionPage__buttonAddToBag '])[2]"));
		        action.click(addToCart).perform();
		        Thread.sleep(3000); 

		        String cartCount = driver.findElement(By.xpath("//div[@class='DesktopHeader__myBagShow']//span")).getText();
		        System.out.println("Cart Count: " + cartCount);
		        Thread.sleep(3000); 

		        //Click the cart
		        WebElement carticon = driver.findElement(By.xpath("//div[@class='DesktopHeader__myBagShow']//span"));
		        action.click(carticon).perform();
		        Thread.sleep(3000); 

		        //Close all tabs
		        for (String win : driver.getWindowHandles()) 
		        {
		            driver.switchTo().window(win);
		            driver.close();
		        }
	}

}
