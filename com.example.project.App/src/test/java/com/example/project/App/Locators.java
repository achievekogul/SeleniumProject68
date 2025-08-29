package com.example.project.App;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Locators{
	WebElement element = null;
	public WebElement locators(WebDriver driver, String typelocators, String valuepath) {


		try {
			switch (typelocators.toLowerCase()) {
			case "id":
				element = driver.findElement(By.id(valuepath));
				break;
			case "xpath":
				element = driver.findElement(By.xpath(valuepath));
				break;
			case "name":
				element = driver.findElement(By.name(valuepath));
				break;
			case "css":
				element = driver.findElement(By.cssSelector(valuepath));
				break;
			default:
				System.out.println("Invalid locator type: " + typelocators);
			}
		} catch (Exception e) {
			System.out.println("Element not found: " + typelocators + " = " + valuepath);
		}

		return element;
	}	
	
	public By getLocator(String type, String valuePath) {
	    By locator = null;

	    switch(type.toLowerCase()) {
	        case "id":
	            locator = By.id(valuePath);
	            break;
	        case "name":
	            locator = By.name(valuePath);
	            break;
	        case "xpath":
	            locator = By.xpath(valuePath);
	            break;
	        case "css":
	            locator = By.cssSelector(valuePath);
	            break;
	        case "classname":
	            locator = By.className(valuePath);
	            break;
	        case "linktext":
	            locator = By.linkText(valuePath);
	            break;
	        case "partiallinktext":
	            locator = By.partialLinkText(valuePath);
	            break;
	        case "tagname":
	            locator = By.tagName(valuePath);
	            break;
	        default:
	            throw new IllegalArgumentException("Invalid locator type: " + type);
	    }
	    return locator;
	}

}


