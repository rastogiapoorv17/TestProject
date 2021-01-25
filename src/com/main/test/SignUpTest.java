package com.main.test;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.main.pages.LoginPage;
import com.main.pages.SignUp;

import Test.BaseTest;

public class SignUpTest extends BaseTest {
	
	
	
	@Test
	public void registerTest() {
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		LoginPage lg= new LoginPage(driver);
		lg.signupClick();
		SignUp sg = new SignUp(driver);
		sg.fname_Enter();
		sg.lname_Enter();
		sg.email_Enter();
		sg.password_Enter();
		sg.check_Select();
		sg.submit_Click();
		
	}
	@AfterTest
	public void close() {
		driver.close();
	}

}
