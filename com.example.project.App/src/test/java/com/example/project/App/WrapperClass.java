package com.example.project.App;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WrapperClass extends Locators{

	public static Properties prop;
	public static WebDriver driver;

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
		// Save screenshot with step name and timestamp
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File("screenshot"+"_"+timestamp+"_"+".png"));
		System.out.println("Screenshot saved successfully!");
	}

}
