package week4.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Alert 
{
	public static void main(String[] args)
	{
		EdgeDriver driver = new EdgeDriver(); 
        driver.manage().window().maximize(); 
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Load the URL
        driver.get("https://www.leafground.com/alert.xhtml");
        
        //click alert
        driver.findElement(By.xpath("//button[@id='j_idt88:j_idt104']")).click();
        
        //switch to alert
        org.openqa.selenium.Alert alert= driver.switchTo().alert();
        alert.sendKeys("TestLeaf");
        
        //dismiss the alert
        alert.dismiss();
        
        //print the message
        WebElement message= driver.findElement(By.xpath("//span[@id='confirm_result']"));
        String result= message.getText();
        System.out.println("message displayed after dismiss:" +result);
        
        //verify the message
        if(result.contains(result))
        {
        	System.out.println("alert dismissed successfully");
        }
        else
        {
        	System.out.println("no message is displayed");
        }
    }

}
