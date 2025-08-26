package com.example.project.App;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Iframe {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

        driver.get("https://jqueryui.com/droppable/");
        driver.manage().window().maximize();
        
        //0,1,2

        // Switch to iframe
        WebElement iframe = driver.findElement(By.cssSelector(".demo-frame"));
       driver.switchTo().frame(iframe);
       //driver.switchTo().frame

        // Interact with elements inside iframe
        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));

        System.out.println("Text before drop: " + droppable.getText());

        // Perform drag and drop (using Actions class)
        new org.openqa.selenium.interactions.Actions(driver)
            .dragAndDrop(draggable, droppable)
            .build()
            .perform();

        System.out.println("Text after drop: " + droppable.getText());

        // Switch back to main content
        driver.switchTo().defaultContent();
        driver.quit();
	}
}
