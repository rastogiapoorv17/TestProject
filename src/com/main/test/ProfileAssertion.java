package com.main.test;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.main.pages.HomePage;
import com.main.pages.LoginPage;

import Test.BaseTest;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class ProfileAssertion extends BaseTest {
	
	
	@Test
	public void navigatetoScoll()
	{
		driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
		LoginPage lp = new LoginPage(driver);
		lp.loginField();
		lp.passwordField();
		lp.loginsubmit();
		
		HomePage hp = new HomePage(driver);
		//hp.click_Element();
		
		String expectedText= "My Profile";
		hp.hoverProfile();
		String actualText= hp.myProfile();
		
	Assert.assertEquals(expectedText, actualText);
	}
	
	@AfterTest
	public void close() {
		driver.close();
	}

}
