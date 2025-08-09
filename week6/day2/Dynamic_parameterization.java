package week6.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
//import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Dynamic_parameterization
{
	EdgeDriver driver; 
	EdgeOptions options;
	
	@Test(dataProvider="fetchData")
	@Parameters({"name","company name","description"})	
	public void login(String name, String companyname,String description) 
			throws InterruptedException
	{
		//Initialize EdgeDriver
		EdgeOptions options=new EdgeOptions();
		options.addArguments("guest");		
		EdgeDriver driver=new EdgeDriver(options);	
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Load the URL
        driver.get("https://login.salesforce.com ");

        //login
        driver.findElement(By.id("username")).sendKeys("vidyar@testleaf.com");
        driver.findElement(By.id("password")).sendKeys("Sales@123");
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

        //Click dropdown → New Legal Entity
        //driver.findElement(By.xpath("//div[@title='Legal Entities']")).click();
        driver.findElement(By.xpath("//a[@title='New']")).click();
        Thread.sleep(2000);

        //Fill details
        driver.findElement(By.xpath("//input[@name='Name']")).sendKeys(name);
        driver.findElement(By.xpath("//input[@name='CompanyName']")).sendKeys(companyname);
        driver.findElement(By.xpath("(//textarea[@class='slds-textarea'])[2]")).sendKeys(description);

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
	}
        
	@DataProvider(name="fetchData")
	public String[][] passdata()
	{
		String[][] data = new String[3][3];
		data[0][0] = "Asvini";
		data[0][1] = "TestLeaf";
		data[0][2] = "description1";
		
		data[1][0] = "Jai";
		data[1][1] = "Salesforce";
		data[1][2] = "description2";
		
		data[2][0] = "Kavin";
		data[2][1] = "Selenium";
		data[2][2] = "description3";
		
		return data;
    	 }
	}

