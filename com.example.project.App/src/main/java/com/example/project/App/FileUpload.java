package com.example.project.App;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUpload {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://the-internet.herokuapp.com/upload");

		// Locate the file input element and send the file path
		WebElement uploadElement = driver.findElement(By.id("file-upload"));
		uploadElement.sendKeys("/home/pingu/rest.pptx");

		// Click the upload button
		driver.findElement(By.id("file-submit")).click();

		WebElement ele= driver.findElement(By.xpath("//div[@id='content']/div/h3"));

		//To verify whether File uploaded text is seen on the screen
		if(ele.getText().equalsIgnoreCase("File Uploaded!")) {
		 
			System.out.println("Fileuploaded text is seen on the screen and verified");

		}
		//Close the driver
		driver.quit();
	}
}
