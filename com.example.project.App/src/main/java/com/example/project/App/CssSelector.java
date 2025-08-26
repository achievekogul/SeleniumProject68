package com.example.project.App;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

public class CssSelector {

	public static void main(String[] args) throws InterruptedException {

		// Setup ChromeDriver
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		// Open the website
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();

		// 1. Locate username field using ID as CSS selector
		WebElement username = driver.findElement(By.cssSelector("#user-name"));
		username.sendKeys("standard_user");

		WebElement password = driver.findElement(By.cssSelector("input[placeholder='Password']"));
		password.sendKeys("secret_sauce");

		// 4. Select a product using attribute selector
		WebElement productTitle = driver.findElement(By.cssSelector("div.login_logo"));
		System.out.println("First product title: " + productTitle.getText());

		// 5. Locate login button using class
		WebElement loginButton = driver.findElement(By.cssSelector(".btn_action"));
		loginButton.click();
		
		//driver.quit();
	}
}
