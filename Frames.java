package week4.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		WebElement iFrame1 = driver.findElement(By.id("frame1"));
		WebElement iFrame2 = driver.findElement(By.id("frame2"));
		driver.switchTo().frame(iFrame1);
		WebElement iFrame3 = driver.findElement(By.id("frame3"));
		driver.findElement(By.xpath("//b[text()='Topic :']/following-sibling::input")).sendKeys("Hello World");
		driver.switchTo().frame(iFrame3);
		driver.findElement(By.id("a")).click();

		driver.switchTo().defaultContent();

		driver.switchTo().frame(iFrame2);

		WebElement dropdownlist = driver.findElement(By.tagName("select"));

		Select drop = new Select(dropdownlist);
		drop.selectByIndex(2);
		Thread.sleep(5000);
		driver.quit();
		
		
	}
}