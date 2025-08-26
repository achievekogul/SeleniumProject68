package com.example.project.App;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Navigate {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.amazon.in/");
		driver.findElement(By.xpath("//a[normalize-space()='Amazon Pay']")).click();
		WebElement ele=  driver.findElement(By.xpath("//span[contains(text(),'Flights')]"));
		System.out.println(ele.getText());

		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
	}
}
