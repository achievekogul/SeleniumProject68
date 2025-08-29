package com.example.project.App;

import org.testng.annotations.AfterMethod;
import java.io.IOException;

public class TestCases extends WrapperClass{



	public void Login() throws IOException {

		try {
			sendKeys("xpath", WrapperClass.prop.getProperty("userNameField"), WrapperClass.prop.getProperty("username"), "To enter userName");

			fluentWait("id",WrapperClass.prop.getProperty("passWordField"));
			sendKeys("id", WrapperClass.prop.getProperty("passWordField"), WrapperClass.prop.getProperty("password"), "To enter password");

			explicitWait("xpath", WrapperClass.prop.getProperty("loginBtnField"));
			//click("xpath",WrapperClass.prop.getProperty("loginBtnField"));
			javaScriptExecutor("xpath",WrapperClass.prop.getProperty("loginBtnField"));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}




}
