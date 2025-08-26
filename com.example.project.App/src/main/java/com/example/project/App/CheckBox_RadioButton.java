package com.example.project.App;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBox_RadioButton {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.selenium.dev/selenium/web/formPage.html");
		
		/*
		 * isSelected() isEnabled() isDisplayed()
		 */
		
				

		WebElement click_CheckBox = driver.findElement(By.id("checky")); 
		WebElement drop_RadioButton =driver.findElement(By.id("peas"));
		WebElement disabled_CheckBox =driver.findElement(By.id("disabledchecky"));

		if(!(click_CheckBox.isSelected())&& click_CheckBox.isDisplayed()) {
			click_CheckBox.click();
			System.out.println("Check box is selected/checked and displayed");
		}
		if(disabled_CheckBox.isEnabled()){
			System.out.println("Button is enabled.");
		}
		else {
			
			System.out.println("Button is disabled.");
		}
		if(drop_RadioButton.isEnabled() && drop_RadioButton.isDisplayed()) {
			drop_RadioButton.click();
		}
	}
}