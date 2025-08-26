package com.example.project.App;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Mousemove {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://demoqa.com/droppable");

		WebElement drag = driver.findElement(By.id("draggable")); 
		WebElement drop =driver.findElement(By.id("droppable"));
		WebElement accept =driver.findElement(By.xpath("//a[@id='droppableExample-tab-accept']"));
//click()
//moveToElement(accept).click()	using Actions
//Robot class
		Actions act = new Actions(driver);
		act.dragAndDrop(drag, drop).build().perform();
		act.moveToElement(accept).click().build().perform();
		driver.quit();

	}
}
