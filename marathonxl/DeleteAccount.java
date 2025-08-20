package marathonxl;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteAccount extends Baseclass
{
	
	@Test(dataProvider="fetchData")
	 public void runDelete(String accountname, String billingstr, String shippingstr)
	 	 throws InterruptedException  
	 {
	        driver.findElement(By.xpath("//input[@placeholder='Search this list...']")).sendKeys(accountname+ Keys.ENTER);
	        Thread.sleep(3000);
	        
	        String noOfItems = driver.findElement(By.xpath("//span[@aria-label='Recently Viewed']")).getText();
	        String[] s = noOfItems.split(" ");
	        int countBeforeDelete = Integer.parseInt(s[0]);
	        
	        driver.findElement(By.xpath("//table/tbody/tr[1]/td[6]")).click();
	        driver.findElement(By.xpath("//a[@title='Delete']")).click();
	        driver.findElement(By.xpath("//button[@title='Delete']")).click();
	        Thread.sleep(3000);
	        
	        noOfItems = driver.findElement(By.xpath("//span[@aria-label='Recently Viewed']")).getText();
	        s = noOfItems.split(" ");
	        int countAfterDelete = Integer.parseInt(s[0]);
	        System.out.println("confirmed");
	        Assert.assertTrue(countBeforeDelete==(countAfterDelete+1),"Verify the account has deleted");

	    }
	}


