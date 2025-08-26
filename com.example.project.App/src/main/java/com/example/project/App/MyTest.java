package com.example.project.App;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;


public class MyTest {

	public static Properties prop;
	public static WebDriver driver;

	public static void main(String[] args) {
		try {
			prop = new Properties();
			String projectPath = System.getProperty("user.dir");
			System.out.println(projectPath);
			String configPath = projectPath+"/src/test/java/com/example/config/config.properties";
			System.out.println(configPath);
			FileInputStream ip = new FileInputStream(configPath);
			prop.load(ip);


		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}



}