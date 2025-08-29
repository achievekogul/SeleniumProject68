package com.example.project.App;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WrapperClass extends Locators{

	public static Properties prop;
	public static WebDriver driver;
	public static JavascriptExecutor js;
	public static WebDriverWait wait;
	public static By locator;
	public static Wait<WebDriver> fluentWait;
	String projectPath;
	String configPath;

	public WrapperClass(){
		try {
			prop = new Properties();
			configPath = System.getProperty("user.dir")+"/src/test/java/com/example/config/config.properties";
			FileInputStream ip = new FileInputStream(configPath);
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization(){
		String browserName = prop.getProperty("browser"); //chrome

		if(browserName.equals("chrome")){
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(); 
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		}
		else if(browserName.equals("FF")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(); 
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));

	}

	public void sendKeys(String type, String value, String text, String teststep) throws IOException {

		locators(driver, type, value).sendKeys(text);
		// Create timestamp to avoid overwriting
		takescreenshot();
	}

	public void click(String type, String value) throws IOException {
		locators(driver, type, value).click();
		takescreenshot();
	}

	public void quitBrowser() {
		driver.quit();
	}

	public void takescreenshot() throws IOException {
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		// Take screenshot
		// Save screenshot with step name and time_stamp
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File("screenshot"+"_"+timestamp+"_"+".png"));
		System.out.println("Screenshot saved successfully!");
	}

	public void javaScriptExecutor(String type, String valuePath) {
		element = locators(driver, type, valuePath);
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}


	public void explicitWait(String type, String valuePath) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		locator = getLocator(type, valuePath);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	}

	public void fluentWait(String type, String valuePath) {

		fluentWait = new FluentWait<>(driver)
				.withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class);
		locator = getLocator(type, valuePath);
		element = fluentWait.until(driver -> driver.findElement(locator));
	}
}
