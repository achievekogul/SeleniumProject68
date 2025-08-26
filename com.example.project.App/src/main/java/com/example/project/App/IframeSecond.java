package com.example.project.App;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;

public class IframeSecond {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("file:///home/pingu/Documents/iframe.html");
		driver.manage().window().maximize();

		// 1. Locate by WebElement
		WebElement webElement = driver.findElement(By.xpath("//iframe[1]"));
		driver.switchTo().frame(webElement);
		String text1 = driver.findElement(By.xpath("//p")).getText();
		System.out.println("Text extracted using WebElement: " + text1);
		driver.switchTo().defaultContent();

	
		driver.switchTo().frame("frameTwo");
		String text2 = driver.findElement(By.xpath("//p")).getText();
		System.out.println("Text extracted using name/ID: " + text2);
		driver.switchTo().defaultContent();

		// 3. Locate by index
		driver.switchTo().frame(2); // index starts from 0
		String text3 = driver.findElement(By.xpath("//p")).getText();
		System.out.println("Text extracted using index: " + text3);
		driver.switchTo().defaultContent();

		driver.quit();


	}

}
