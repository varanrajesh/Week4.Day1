package week4.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class W3Schools 

{
	public static void main(String[] args)
	
	{
		WebDriverManager.chromedriver().setup();

		/* Disable Popup Notifications on the browser */
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		/* Trigger the Browser */
		ChromeDriver driver = new ChromeDriver(options);

		// Maximize Window and Set the timeout to 30seconds
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Rajeshwaran");
		alert.accept();
		String text = driver.findElement(By.id("demo")).getText();
		if(text.contains("Rajeshwaran"))
		{
			System.out.println("Name mAtched");
		}
			else 
			{
			System.out.println("Name not mAtched");	
		}
		
	}

}
