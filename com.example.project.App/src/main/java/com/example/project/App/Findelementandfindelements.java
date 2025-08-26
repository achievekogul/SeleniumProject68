package com.example.project.App;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Findelementandfindelements {

	public static void main(String[] args) throws InterruptedException {

		//Difference between findElement and findElements.
		//find element is used to store one element.
		//find elements are used to store more than one element.

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		Thread.sleep(3000);

		WebElement link = driver.findElement(By.linkText("New Releases"));
		System.out.println("Example of findElement print one link "+ link.getText() );

		List<WebElement> moreThanOneLink = driver.findElements(By.tagName("a"));

		for(WebElement link1 : moreThanOneLink) {

			if(!(link1.getText().isEmpty())) {
				System.out.println(link1.getText());	
			}
			if(link1.getText().equalsIgnoreCase("Amazon Science")) {

				System.out.println("Amazon Science link is detected.");
			}
		}
	}
}
