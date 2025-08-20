package marathonxl;

import java.io.IOException;
//import java.io.IOException;
//import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.edge.EdgeOptions;
//import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
//import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class Baseclass 
{
	public static EdgeDriver driver; 
	public static EdgeOptions options; 
	@Parameters({"url","username","password"})
	@BeforeMethod
	public void preconditions(String url,String uname,String pwd) throws InterruptedException
	{
		options = new EdgeOptions();
	    options.addArguments("--disable-notifications");
	    driver = new EdgeDriver();	
	driver.manage().window().maximize();
	driver.get(url);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
	 driver.findElement(By.id("username")).sendKeys(uname);
     driver.findElement(By.id("password")).sendKeys(pwd);
     driver.findElement(By.id("Login")).click();
     Thread.sleep(3000);
     
     driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
     Thread.sleep(3000);
     driver.findElement(By.xpath("//button[text()='View All']")).click();
     
     //to click sale
     WebElement sale= driver.findElement(By.xpath("//p[text()='Sales']/ancestor::a"));
     driver.executeScript("arguments[0].click();", sale);
     Thread.sleep(3000);
     
     //to click account
     WebElement account= driver.findElement(By.xpath("(//span[text()='Accounts'])[1]"));
     driver.executeScript("arguments[0].click();", account);
     Thread.sleep(3000);
}
	@DataProvider(name="fetchData")
    public String[][] Data() throws IOException
{
    return Integration.readData();
}
    @AfterMethod
    public void teardown() 
	{
		driver.close();
}
}