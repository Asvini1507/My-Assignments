package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
//import org.openqa.selenium.support.ui.Select;

public class Checkbox {

	public static void main(String[] args)
    throws InterruptedException
	{
		EdgeOptions options=new EdgeOptions();
		options.addArguments("guest");
		EdgeDriver driver=new EdgeDriver(options);
		driver.get("https://leafground.com/checkbox.xhtml");		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//click basic		
				WebElement Basic= driver.findElement(By.xpath("//span[text()='Basic']"));
		        Basic.click();
		        
		//click Ajax
				WebElement Ajax= driver.findElement(By.xpath("//span[text()='Ajax']"));
				Ajax.click();
				
		//verify Check box message	
				WebElement Checkbox= driver.findElement(By.xpath("//span[@class='ui-growl-title']"));
				if (Checkbox.isDisplayed())
				{
					System.out.println("Expected checkbox message appears");
				}
					else
					{
						System.out.println("Expected checkbox message does not appear");
					}
		//click language			
			    driver.findElement(By.xpath("//label[text()='Java']/preceding-sibling::div")).click();
			    
		//click tristate		
			  	driver.findElement(By.xpath("//div[@id='j_idt87:ajaxTriState']")).click();

		//check tristate option
			  	WebElement stateCheck = driver.findElement(By.xpath("//p[text()='State = 1']"));
			  		if (stateCheck.isDisplayed())
			  		{
			  			System.out.println("The Tri-state option is State 1");
			  		}
						else
				{
					System.out.println("The state option has been changed");
				}
				
		//click toggle switch		
				driver.findElement(By.xpath("//div[@class='ui-toggleswitch-slider']")).click();

		//check the toggle switch status
				WebElement toggleSwitch = driver.findElement(By.xpath("//input[@id='j_idt87:j_idt100_input']"));
				if (toggleSwitch.isSelected())
				{
					System.out.println("The Toggle switch is on");
				} 
				else
				{
					System.out.println("The Toggle switch is off");
				}
							
		//check disable check box is enabled or disabled
				WebElement disablecheckbox=driver.findElement(By.xpath("//input[@id='j_idt87:j_idt102_input']"));
				if (disablecheckbox.isEnabled())
				{
					System.out.println("The checkbox is enabled");
				} 
				else
				{
					System.out.println("The checkbox is disabled");
				}
				
        //select multiple
				driver.findElement(By.xpath("//ul[@data-label='Cities']")).click();
				
				driver.findElement(By.xpath("(//label[text()='Paris'])[2]")).click();
				
				//driver.findElement(By.xpath("//label[text()='Istanbul']")).click();

				//driver.close();
				}
}