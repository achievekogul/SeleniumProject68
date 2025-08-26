package com.example.project.App;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

import org.testng.annotations.AfterTest;

public class AppTest extends TestCases{

	
	@BeforeTest
	public void setUp() {
		initialization();
	}

	@Test
	public void testCase1_Login() throws IOException {
		Login();
		
	}

	@AfterTest
	public void tearDown() {
		quitBrowser();
	}
}