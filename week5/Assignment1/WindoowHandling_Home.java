package week5.Assignment1;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class WindoowHandling_Home 
{
	public static void main(String[] args) 
			throws InterruptedException
	{
		EdgeOptions options=new EdgeOptions();
		options.addArguments("guest");
		EdgeDriver driver=new EdgeDriver(options);
		driver.get("http://leaftaps.com/opentaps/control/main");		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");		
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
        driver.findElement(By.partialLinkText("CRM/SFA")).click();
        driver.findElement(By.linkText("Contacts")).click();
        driver.findElement(By.linkText("Merge Contacts")).click();
        driver.findElement(By.xpath("//input[@id='partyIdFrom']/following-sibling::a")).click();
        Thread.sleep(2000);

        //Switch to new window and select first contact
        Set<String> windowHandles1 = driver.getWindowHandles();
        String mainWindow1 = driver.getWindowHandle();
        for (String window : windowHandles1) 
        {
            if (!window.equals(mainWindow1)) 
            {
                driver.switchTo().window(window);
                break;
            }
        }
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//a[@class='linktext'])[1]")).click();
        
        //back to main
        driver.switchTo().window(mainWindow1); 

        //Click widget for To Contact
        driver.findElement(By.xpath("//input[@id='partyIdTo']/following-sibling::a")).click();
        Thread.sleep(2000);

        //Switch to new window and select To contact
        Set<String> windowHandles2 = driver.getWindowHandles();
        for (String window : windowHandles2) 
        {
            if (!window.equals(mainWindow1)) 
            {
                driver.switchTo().window(window);
                break;
            }
        }
        driver.findElement(By.xpath("//a[text()='EuroCustomer']")).click();
        Thread.sleep(2000);
 
        //back to main
        driver.switchTo().window(mainWindow1);

        //Click Merge
        driver.findElement(By.linkText("Merge")).click();
        Thread.sleep(1000);

        //Accept Alert
        Alert alert = driver.switchTo().alert();
        alert.accept();

        //Verify result
        String result= driver.getTitle();
        System.out.println("Page Title after Merge: " + result);
        if (result.contains("View Contact")) 
        {
            System.out.println("Merge successful");
        } 
        else 
        {
            System.out.println("Merge failed");
        }

        // Close browser
        driver.quit();
    }
		}
