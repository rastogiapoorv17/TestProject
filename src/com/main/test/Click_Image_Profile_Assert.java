package com.main.test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
//import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.main.pages.HomePage;
import com.main.pages.LoginPage;

import utilities.BaseTest;
import utilities.CommonExcelRead;


public class Click_Image_Profile_Assert extends BaseTest {
	
	
	
	@Test(priority=1,dataProvider = "DataShare")
	public void navigatetoScoll(String login, String password)
	{
		driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
		LoginPage lp = new LoginPage(driver);
		lp.loginField(login);
		lp.passwordField(password);
		lp.loginsubmit();
		
		HomePage hp = new HomePage(driver);
		WebElement sp1= driver.findElement(HomePage.spinner);
		super.explicitVisible(sp1);

		//hp.click_Element();
		
		String expectedText= "My Profile";
		hp.hoverProfile();
		String actualText= hp.myProfile();
		
	org.testng.Assert.assertEquals(actualText, expectedText);
	}
	@Test(priority=2,dataProvider = "DataShare")
	public void clickTest(String login, String password) throws InterruptedException, IOException
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		LoginPage lp = new LoginPage(driver);
		lp.loginField(login);
		lp.passwordField(password);
		lp.loginsubmit();
		
		 HomePage hp = new HomePage(driver);
		/*
		 * WebElement sp1= driver.findElement(HomePage.scroll); hp.explicitVisible(sp1);
		 */
		
		  Thread.sleep(25000); 
		  String current_url=driver.getCurrentUrl();
		  driver.get(current_url);
		 
		  Thread.sleep(10000); 
		hp.imageComparisonScrollClick();
		
		hp.image_Comapre_Install();
		hp.image_Comapre_UnInstall();
		hp.image_Comapre_UnInstall_Confirm();
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
	public void close() {
		driver.close();
	}
}
