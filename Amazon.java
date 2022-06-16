package week4.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
public class Amazon
{

	public static void main(String[] args) throws InterruptedException, IOException
	{
		
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		String parentwindow = driver.getWindowHandle();
		driver.get("https://www.amazon.in");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro 5g mobile 12gb 256gb");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		
		List<WebElement> Desc = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		List<WebElement> price = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		List<WebElement> ratings = driver.findElements(By.xpath("//span[contains(@class,'a-size-base')]"));
		System.out.println("Description is    : " + Desc.get(0).getText());
		System.out.println("Price of the product is     : " + price.get(0).getText());
		System.out.println("Customer Ratings : " + ratings.get(0).getText());
		String phoneprice = price.get(0).getText();
		File source = driver.getScreenshotAs(OutputType.FILE);
		File destination = new File("./AmazonScreenshot.png");
		FileUtils.copyFile(source, destination);
		Desc.get(0).click();
		Thread.sleep(5000);
		Set<String> handles = driver.getWindowHandles();
		List<String> windowslist = new ArrayList<String>(handles);
		
		System.out.println("No.of Windows : " + windowslist.size());
		driver.switchTo().window(windowslist.get(1));
		System.out.println("New Window Title: " + driver.getTitle());
		driver.findElement(By.id("add-to-cart-button")).click();
		Thread.sleep(3000);
		
		String cart = driver.findElement(By.xpath("//span[@id='attach-accessory-cart-subtotal']")).getText();
		System.out.println("Cart Value = " + cart);
		System.out.println("Phone Value = " + phoneprice);
		
		if (cart.contains(phoneprice))
			System.out.println("Phone & Cart Value are Matching ");
		else
			System.out.println("Phone & Cart Value is not matching");
		
		driver.close(); 
		driver.switchTo().window(parentwindow);
		driver.close();
	}

}