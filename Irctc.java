package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Irctc {

	public static void main(String[] args) throws InterruptedException
	
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

		
		driver.get("https://www.irctc.co.in");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		driver.findElement(By.linkText("FLIGHTS")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowlist = new ArrayList<String>(windowHandles);
		
		driver.switchTo().window(windowlist.get(1));
		String title = driver.getTitle();
		System.out.println(title);
		driver.close();
		
		

	}

}
