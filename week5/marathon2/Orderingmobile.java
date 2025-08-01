package marathon2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.sukgu.Shadow;

public class Orderingmobile 
{
	public static void main(String[] args) 
			throws InterruptedException 
	{
        EdgeDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Launch ServiceNow
        driver.get("https://dev209663.service-now.com/");

        //Login
        driver.findElement(By.id("user_name")).sendKeys("admin");
        driver.findElement(By.id("user_password")).sendKeys("qy/Q6A=vOM3x"); 
        driver.findElement(By.id("sysverb_login")).click();

        //Handle Shadow DOM using Shadow Library
        Shadow shadow = new Shadow(driver);
        shadow.setImplicitWait(10);

        //Click All
        shadow.findElementByXPath("//div[text()='All']");
        Thread.sleep(2000);
        shadow.findElementByXPath("//input[@id='filter']").sendKeys("Service Catalog");
        WebElement serviceCatalog = shadow.findElementByXPath("//mark[text()='Service Catalog']");
        serviceCatalog.click();
        Thread.sleep(2000);
        
        //Switch to iframe
        WebElement iframe = shadow.findElementByXPath("//iframe[@id='gsft_main']");
        driver.switchTo().frame(iframe);

        //Click Mobiles
        driver.findElement(By.xpath("//h2[contains(text(),'Mobiles')]")).click();

        //Click Apple iPhone 13 Pro
        driver.findElement(By.xpath("//table[@class='no_underline_table']//tbody/tr/td")).click();

        //Select Yes for lost or broken
        driver.findElement(By.xpath("//label[text()='Yes']")).click();

        //Enter original phone number
        driver.findElement(By.xpath("//input[@class='cat_item_option sc-content-pad form-control']")).sendKeys("99");

        //Select Monthly Data Allowance: Unlimited
        WebElement dropdown = driver.findElement(By.xpath("//select[@class='form-control cat_item_option ']"));
        Select sel=new Select(dropdown);
    	sel.selectByVisibleText("Unlimited [add $4.00]");

        //Set color and storage
        driver.findElement(By.xpath("//label[text()='Blue']")).click();
        driver.findElement(By.xpath("//label[text()='512 GB [add $300.00]']")).click();

        //Click Order Now
        driver.findElement(By.xpath("//button[@id='oi_order_now_button']")).click();

        //Get request number
        String requestNumber = driver.findElement(By.id("requesturl")).getText();
        System.out.println("Order placed successfully. Request Number: " + requestNumber);

        //Close
        driver.quit();
	
	}
}
