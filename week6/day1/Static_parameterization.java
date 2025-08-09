package week6.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Static_parameterization 
{
	public EdgeDriver driver; 
	EdgeOptions options;
	@Test
	@Parameters({"url","username","password"})
		public void preconditions(String url,String uname,String pwd)
			throws InterruptedException
	{
		options = new EdgeOptions();
		options.addArguments("--disable-notifications");
	driver = new EdgeDriver(options);
	driver.manage().window().maximize();
	driver.get(url);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
		    /*//Initialize ChromeDriver
	        ChromeDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	        //Load the URL
	        driver.get("https://login.salesforce.com ");*/
	
	//login
	driver.findElement(By.id("username")).sendKeys(uname);
	driver.findElement(By.id("password")).sendKeys(pwd);
	driver.findElement(By.id("Login")).click();
	
	//Click toggle menu
    driver.findElement(By.xpath("//button[@title='App Launcher']")).click();
    Thread.sleep(2000);

    //View All->Legal Entities
    driver.findElement(By.xpath("//button[text()='View All']")).click();
    WebElement legalbutton=driver.findElement(By.xpath("//p[text()='Legal Entities']"));
    Actions legal = new Actions(driver);
	legal.scrollToElement(legalbutton).perform();
	legalbutton.click();
    Thread.sleep(2000);

    //Click dropdown ->New Legal Entity
    driver.findElement(By.xpath("//a[@title='New']")).click();
    Thread.sleep(2000);

    //Fill details
    driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Asvini");
    driver.findElement(By.xpath("//input[@name='CompanyName']")).sendKeys("TestLeaf");
    driver.findElement(By.xpath("(//textarea[@class='slds-textarea'])[2]")).sendKeys("Salesforces");
    
    WebElement status = driver.findElement(By.xpath("//button[@aria-label='Status']"));
	driver.executeScript("arguments[0].click();", status);
    Thread.sleep(2000);
    
    WebElement Active = driver.findElement(By.xpath("//span[text()='Active']"));
	Active.click();

    //Save
    driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
    Thread.sleep(2000);

    //Verify alert message
    WebElement alert = driver.findElement(By.xpath("//span[@data-aura-class='forceActionsText']"));
    if(alert.isDisplayed())
    {
        System.out.println("Alert displayed: " + alert.getText());
    }

    driver.quit();
}

}


