package com.example.project.App;

import org.testng.annotations.AfterMethod;
import java.io.IOException;

public class TestCases extends WrapperClass{



	public void Login() throws IOException {

		sendKeys("xpath", WrapperClass.prop.getProperty("userNameField"), WrapperClass.prop.getProperty("username"), "To enter userName");
		sendKeys("id", WrapperClass.prop.getProperty("passWordField"), WrapperClass.prop.getProperty("password"), "To enter password");
		click("xpath",WrapperClass.prop.getProperty("loginBtnField"));
	}




}
