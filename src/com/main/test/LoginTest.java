package com.main.test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.main.pages.LoginPage;

import utilities.BaseTest;
import utilities.CommonExcelRead;

public class LoginTest extends BaseTest {
	
	@Test(dataProvider = "DataShare")
	public void loginTest(String login, String password)
	{
		LoginPage lp = new LoginPage(driver);
		lp.loginField(login);
		lp.passwordField(password);
		lp.loginsubmit();
		
	}
	@DataProvider(name="DataShare")
	public Object[][] getData() {
		
		
		CommonExcelRead er= new CommonExcelRead("C:\\Users\\apoorv.r\\eclipse-workspace\\TestAppProject\\TestAppProject.xlsx");
		int rowc=er.getrowcount(0);
		System.out.println(rowc);
		Object[][] data= new Object[rowc][2];
		for(int i=0;i<rowc;i++)
		{
			data[i][0]= er.getExcelData(0, i, 0);
			data[i][1]= er.getExcelData(0, i, 1);
		}
		return data;
		
		 
		
	}
	@AfterTest
	public void close() {
		driver.close();
	}
}
