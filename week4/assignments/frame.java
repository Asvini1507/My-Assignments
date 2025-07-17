package week4.assignments;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class frame
{
	public static void main(String[] args)
	{
		EdgeDriver driver = new EdgeDriver(); 
        driver.manage().window().maximize(); 
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Load the URL
        driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");

        // frame
        driver.switchTo().frame("iframeResult");

        WebElement tryButton = driver.findElement(By.xpath("//button[text()='Try it']"));
        tryButton.click();

        // Switch to the alert
        Alert alert = driver.switchTo().alert();
        alert.accept();
          
        // Get result
         WebElement result= driver.findElement(By.id("demo"));
         System.out.println(result.getText());

        driver.quit(); // Close the browser
        }
   }
