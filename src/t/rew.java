package t;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class rew 
{
	public static void main(String[] args) throws IOException, InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Chrome\\chromedriver2.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		System.out.println("Browser is launched");
		
		driver.get("https://www.redbus.in/");
		System.out.println("URL is opened");
		
		//source
		driver.findElement(By.xpath("(//input[@autocomplete='off'])[1]")).sendKeys("mumbai");
		
		String exp="Borivali, Mumbai";
		List<WebElement>src=driver.findElements(By.xpath("//div[2]//section//div[1]//div[2]//section[1]//div[1]//div[1]//div[1]//li"));
		
		for(int i=0; i<src.size(); i++)
		{
			String q1 = src.get(i).getText();
			if(q1.equalsIgnoreCase(exp))
			{
				src.get(i).click();
				break;
			}
		}
		System.out.println("source is entered");
		Thread.sleep(2000);
		
		//destination
		driver.findElement(By.xpath("//input[@id='dest']")).sendKeys("Aurangabad");
				
		String exp1="Bhagyanagar, Aurangabad";
	
		List<WebElement> dest=driver.findElements(By.xpath("//div//main//section//div//div//section//div//li"));
		
		for(int i=0; i<dest.size(); i++)
		{
			String q2 = dest.get(i).getText();
			System.out.println(q2);
			if(q2.equalsIgnoreCase(exp1))
			{
				dest.get(i).click();
				break;
			}
		}
		System.out.println("destination is entered");
		
		//date
		
		String my="Apr 2023";
		while(true)
		{
			String we2 = driver.findElement(By.xpath("(//table//tbody//tr//td)[2]")).getText();
			if(we2.equalsIgnoreCase(my))
			{
				break;
			}
			else
			{
				driver.findElement(By.xpath("(//table//tbody//tr//td)[3]")).click();
			}
		}
		System.out.println("Month is selected");
		
		String day="17";
		List<WebElement> wwe3=driver.findElements(By.xpath("(//table//tbody//tr//td)"));
		
		for(int i=0; i<wwe3.size(); i++)
		{
			String s2 = wwe3.get(i).getText();
			if(s2.equalsIgnoreCase(day))
			{
				wwe3.get(i).click();
				break;
			}
		}
		System.out.println("Date is selected");
		
		driver.findElement(By.xpath("//section//div//div[2]//section//div//button")).click();
		System.out.println("clicked on search button");
		Thread.sleep(2000);
		
		System.out.println(driver.getTitle());
		
	}
		
		
		
		


}
