package com.example.project.App;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import io.github.bonigarcia.wdm.WebDriverManager;


public class WindowHandle {
	
	public static void main(String[] args) throws InterruptedException {
		
		 WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();

	        // Load the HTML file (update path)
	        driver.get("file:///home/pingu/Documents/windowhandle.html");

	        // Store the current (parent) window handle
	        String parentWindow = driver.getWindowHandle();
	        System.out.println(parentWindow);

	        // Click link to open Example.com
	        driver.findElement(By.linkText("Open Example.com in New Tab")).click();
	        Thread.sleep(2000);

	        // Click button to open Wikipedia
	        driver.findElement(By.xpath("//button[contains(text(),'Wikipedia')]")).click();
	        Thread.sleep(2000);

	        // Click button to open Google
	        driver.findElement(By.xpath("//button[contains(text(),'Google')]")).click();
	        Thread.sleep(2000);

	        // Get all open window handles
	        Set<String> allWindows = driver.getWindowHandles();

	        // Loop through each window
	        for (String windowHandle : allWindows) {
	            if (!windowHandle.equals(parentWindow)) {
	                driver.switchTo().window(windowHandle);
	                System.out.println("Title of child windows: " + driver.getTitle());
	                Thread.sleep(2000);
	                driver.close(); // Close the child window
	            }
	        }

	        // Switch back to parent window
	        driver.switchTo().window(parentWindow);
	        System.out.println("Back to parent window: " + driver.getTitle());

	        // Cleanup
	        driver.quit();
	}

}
