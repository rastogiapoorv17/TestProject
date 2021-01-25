package com.main.test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.main.pages.LoginPage;

import Test.BaseTest;

public class LoginTest extends BaseTest {
	
	@Test
	public void loginTest()
	{
		LoginPage lp = new LoginPage(driver);
		lp.loginField();
		lp.passwordField();
		lp.loginsubmit();
		
	}
	@AfterTest
	public void close() {
		driver.close();
	}
}
