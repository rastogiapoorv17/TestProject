package com.main.test;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.main.pages.LoginPage;
import com.main.pages.SignUp;

import utilities.BaseTest;

public class SignUpTest extends BaseTest {
	
	@BeforeTest
	public void initiate_launch() {
		super.logger_Method("LoginTest");
	}
	
	@Test
	public void registerTest() {
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		logger.info("Signing Up");
		LoginPage lg= new LoginPage(driver);
		lg.signupClick();
		SignUp sg = new SignUp(driver);
		sg.fname_Enter();
		sg.lname_Enter();
		sg.email_Enter(super.email());
		sg.password_Enter();
		sg.check_Select();
		sg.submit_Click();
		logger.info("Successfully Signup");
		
	}
	@AfterTest
	public void close() {
		driver.close();
	}

}
