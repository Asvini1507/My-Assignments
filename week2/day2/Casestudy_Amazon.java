package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Casestudy_Amazon 
{
	public static void main(String[] args) throws InterruptedException
	{
		EdgeDriver driver=new EdgeDriver();		
		driver.get("https://www.amazon.in");		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//product search
		WebElement searchbox= driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		searchbox.sendKeys("T-Shirt");
		
		WebElement searchbutton= driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
		searchbutton.click();
		
		//select the product
		WebElement firstproduct= driver.findElement(By.xpath("//h2[@class='a-size-base-plus a-spacing-none a-color-base a-text-normal']"));
		firstproduct.click();
		Thread.sleep(1000);
		
		//click add to cart
		WebElement addcart= driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
		addcart.click();
		
		//validate add to cart
		WebElement validatecount= driver.findElement(By.xpath("//span[@id='nav-cart-count']"));
		String count= validatecount.getText();
		if(!count.equals(0))
		{
			System.out.println("the product is successfully added to cart:" +count);
		}
		else
		{
			System.out.println("failed to add cart");
		}
	}
}
