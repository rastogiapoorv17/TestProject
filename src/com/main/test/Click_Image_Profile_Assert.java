package com.main.test;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

//import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.main.pages.HomePage;
import com.main.pages.LoginPage;

import utilities.BaseTest;
import utilities.CommonExcelRead;


public class Click_Image_Profile_Assert extends BaseTest {
	
	@BeforeTest
	public void initiate_launch() {
		super.logger_Method("LoginTest");
	}
	
	@Test(priority=1,dataProvider = "DataShare")
	public void navigatetoScoll(String login, String password)
	{
		
		logger.info("Opening LoginPage");
		LoginPage lp = new LoginPage(driver);
		lp.loginField(login);
		lp.passwordField(password);
		logger.info("Submitting Login Button");
		lp.loginsubmit();
		
		logger.info("Opening HomePage");
		HomePage hp = new HomePage(driver);
		/*
		 * WebElement sp1= driver.findElement(HomePage.spinner);
		 * super.explicitVisible(sp1);
		 */

		//hp.click_Element();
		
		String expectedText= "My Profile";
		logger.info("Hover On Profile");
		hp.hoverProfile();
		String actualText= hp.myProfile();
		logger.info("Verifying Test Match");
	org.testng.Assert.assertEquals(actualText, expectedText);
	}
	@Test(priority=2,dataProvider = "DataShare")
	public void clickTest(String login, String password) throws InterruptedException, IOException
	{
		logger.info("Opening LoginPage");
		LoginPage lp = new LoginPage(driver);
		lp.loginField(login);
		lp.passwordField(password);
		logger.info("Submitting Login Button");
		lp.loginsubmit();
		logger.info("Successfully Login");
		
		logger.info("Opening HomePage");
		HomePage hp = new HomePage(driver);
		
		/*
		 * WebElement sp1= driver.findElement(HomePage.scroll); hp.explicitVisible(sp1);
		 */
		 Thread.sleep(20000);
		String current_url=driver.getCurrentUrl();
		driver.get(current_url);
		 
		Thread.sleep(20000);
		logger.info("Clicking on Scroll Button");
		hp.imageComparisonScrollClick();
		
		logger.info("Installing Image Compare Addon");
		hp.image_Comapre_Install();
		String install_actual_message= hp.install_message();
		String install_expected_message ="Succeeded to install \"Image Comparison\" addon!";
		Assert.assertEquals(install_actual_message, install_expected_message);
		logger.info("UnInstalling Image Compare Addon");
		hp.image_Comapre_UnInstall();
		hp.image_Comapre_UnInstall_Confirm();
		logger.info("UnInstalled Image Compare Addon");
	}
	@DataProvider(name="DataShare")
	public Object[][] getData() {
		
		CommonExcelRead er= new CommonExcelRead("./TestAppProject.xlsx");
		int rowc=er.getrowcount(0);
		Object[][] data= new Object[rowc][2];
		for(int i=0;i<rowc;i++)
		{
			data[i][0]= er.getExcelData(0, i, 0);
			data[i][1]= er.getExcelData(0, i, 1);
		}
		return data;
		
		 
		
	}
	
	 @AfterMethod
	 public void close() 
	 { 
		 driver.close(); 
		 }
	 
	 
}
