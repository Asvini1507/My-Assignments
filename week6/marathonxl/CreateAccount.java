package week6.marathonxl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccount extends Baseclass
{
	
	@Test(dataProvider="fetchData")
    public void runCreate(String accountname,String billingstr, String shippingstr)
			throws InterruptedException
	{
              
		 // to add new accountname
        driver.findElement(By.xpath("//a[@title='New']")).click();
        driver.findElement(By.xpath("//label[text()='Account Name']/following::input")).sendKeys(accountname);
        
        // to click dropdown
        WebElement ownershipDD = driver.findElement(By.xpath("//button[@aria-label='Ownership']"));
        driver.executeScript("arguments[0].click()",ownershipDD);
        driver.findElement(By.xpath("//span[@title='Public']")).click();
        
        //to save the contact
        driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
        String toastMessage = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
        System.out.println(toastMessage);
        
       Assert.assertTrue(toastMessage.contains(accountname),"Verify the Account name");
    }
	
	}

