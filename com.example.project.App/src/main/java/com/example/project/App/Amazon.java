package com.example.project.App;

import java.awt.Robot;

import java.awt.event.KeyEvent;

import java.time.Duration;

import java.util.List;
import org.jspecify.annotations.NonNull;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	static {

		WebDriverManager.chromedriver().setup();

	}

	public static WebDriver chromeDriver;
	public static void main(String[] args) throws Exception {

		chromeDriver = new ChromeDriver();

		chromeDriver.manage().window().maximize();

		WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(10));

		chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		String webURL = "https://www.amazon.in/";

		JavascriptExecutor js = (JavascriptExecutor) chromeDriver;

		chromeDriver.get(webURL);

		Thread.sleep(2000);

		chromeDriver.navigate().refresh();

		/*

		 * if (chromeDriver.findElement(By.xpath("//button[@class='a-button-text']")) != null)

		 * { WebElement continueShopping =

		 * chromeDriver.findElement(By.xpath("//button[@class='a-button-text']"));

		 * continueShopping.click(); } else { chromeDriver.get(webURL); }

		 */

		if (wait.until((ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")))).isEnabled()) {

			System.out.println("Page is loaded");

		} else {

			System.out.println("Page not loaded");

		}

		@NonNull

		String currentUrl = chromeDriver.getCurrentUrl();

		if (currentUrl.contains("amazon")) {

			System.out.println("Page URL : " + currentUrl);

			System.out.println("We are in Amazon page");

		} else {

			System.out.println("check the url");

		}

		WebElement searchbar = wait.until(ExpectedConditions.elementToBeClickable(By.id("twotabsearchtextbox")));

		searchbar.sendKeys("dell laptop");
		Thread.sleep(2000);
		List<WebElement> suggestedProducts = chromeDriver.findElements(By.xpath("//div[@id='nav-flyout-searchAjax']/div/div/div/div/div/div/child::span"));

		System.out.println();
		System.out.println("Suggested Products ");

		for (WebElement webElement : suggestedProducts) {

			String text = webElement.getText();

			System.out.println("dell laptop " + text);
		}
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_DOWN);

		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);

		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		WebElement filter = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@id='p_123/241862']/span/a/div/label/child::i")));
		filter.click();

		Thread.sleep(2000);
		WebElement cart = wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-cart-count")));

		cart.click();
		
		@NonNull
		String title = chromeDriver.getTitle();
		System.out.println(title);
		chromeDriver.quit();

	}

}
