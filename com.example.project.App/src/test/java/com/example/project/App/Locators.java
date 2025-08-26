package com.example.project.App;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Locators{
	
	public WebElement locators(WebDriver driver, String type, String value) {
	    WebElement element = null;

	    try {
	        switch (type.toLowerCase()) {
	            case "id":
	                element = driver.findElement(By.id(value));
	                break;
	            case "xpath":
	                element = driver.findElement(By.xpath(value));
	                break;
	            case "name":
	                element = driver.findElement(By.name(value));
	                break;
	            case "css":
	                element = driver.findElement(By.cssSelector(value));
	                break;
	            default:
	                System.out.println("Invalid locator type: " + type);
	        }
	    } catch (Exception e) {
	        System.out.println("Element not found: " + type + " = " + value);
	    }

	    return element;
	}	
}