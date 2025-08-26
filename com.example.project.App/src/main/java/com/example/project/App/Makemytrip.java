package com.example.project.App;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.*;

public class Makemytrip {

	public static void main(String[] args) {

		// Setup ChromeDriver using WebDriverManager
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		// Maximize the browser window
		driver.manage().window().maximize();
		// Set implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// Navigate to RedBus website
		driver.get("https://www.redbus.in/");
		// Explicit wait for 'From' field and enter source city.
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement fromfield = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//div[@role='button' and //div[text()='From']]")));
		fromfield.click();
		driver.findElement(By.id("srcDest")).sendKeys("Pune");
		// Wait for dropdown options and select matching source
		List<WebElement> fromOptions = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
				By.xpath("//div[@class='searchCategory elice8'][3]")));
		String sourceName = "Swargate, Pune";
		boolean matchFound = false;
		for (WebElement option : fromOptions) {
			String optionText = option.getText().trim();
			if (optionText.contains(sourceName)) {
				option.click();
				matchFound = true;
				break;
			}
		}
		if (!matchFound) {
			System.out.println("No matching option found for: source");
		}
		// Enter destination city
		driver.findElement(By.id("srcDest")).sendKeys("Mumbai");
		// Wait for dropdown options and select matching destination
		List<WebElement> tooptions = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
				By.xpath("//div[@class='searchCategory_e06c68'][1]")));
		String destinName = "Mumbai";
		boolean matchFound1 = false;
		for (WebElement option : tooptions) {
			String optionText = option.getText().trim();
			if (optionText.contains(destinName)) {
				option.click();
				matchFound1 = true;
				break;
			}
		}
		if (!matchFound1) {
			System.out.println("No matching option found for: destination");
		}
		// Date to select on calendar
		// ... (rest of the code)
		// Click on the Search Buses button
		driver.findElement(By.xpath("//button[@class='primaryButton 93544e searchButtomWrapper_Be4b13']")).click();
		// ... (rest of the code)
		// Print total and all operator names
		/*
		 * System.out.println("Total Bus Operators: " + allOperatorsNames.size());
		 * allOperatorsNames.forEach(System.out::println);
		 */
		//Close the browser
		driver.quit();

	}

}
