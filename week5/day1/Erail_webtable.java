package week5.day1;

import java.time.Duration;
//import java.util.HashSet;
import java.util.List;
//import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Erail_webtable {

	public static void main(String[] args) 
			throws InterruptedException
	{
			EdgeDriver driver=new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
		 //load URL
        driver.get("https://erail.in/");
        
        //locate the table
       // WebElement locate=driver.findElement(By.xpath("//table[@id='tableTopMenu']/tbody"));
        
        //Enter MAS from station
        WebElement fromStation = driver.findElement(By.xpath("//input[@id='txtStationFrom']"));
        fromStation.clear();
        fromStation.sendKeys("Mgr Chennai Ctr",Keys.ENTER);

        //Enter MDU To station
        WebElement toStation = driver.findElement(By.xpath("//input[@id='txtStationTo']"));
        toStation.clear();
        toStation.sendKeys("Maddur",Keys.ENTER);

        //check Sort on Date
        WebElement sortOnDate = driver.findElement(By.xpath("//input[@id='chkSelectDateOnly']"));
        if (sortOnDate.isSelected())
        {
            sortOnDate.click();
        }
        Thread.sleep(2000);
        
        //train names from table
        List<WebElement> trainElements = driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader stickyTrainListHeader']//tr/td[2]"));
        System.out.println("Total trains found: " + trainElements.size());
        for (WebElement train : trainElements) 
       {
          System.out.println(train.getText());
              }
             
        //Close browser
        //driver.quit();
    }
	}
