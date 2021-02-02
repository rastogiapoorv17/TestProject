package com.main.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUp {
	
	WebDriver driver;
	
	By fname=  By.id("first-name");
	By lname= By.id("last-name");
	By email= By.id("email");
	By password= By.id("password");
	By check = By.xpath("//div/label/span[@class='tp-checkbox-input-view']");
	By signup = By.xpath("//div[@class='tp-submit-wrapper']");
	
	
	public SignUp(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	public void fname_Enter()
	{
		driver.findElement(fname).sendKeys("Raj");
	}
	public void lname_Enter()
	{
		driver.findElement(lname).sendKeys("Sharma");
	}
	public void email_Enter(String mail)
	{
		driver.findElement(email).sendKeys(mail);
	}
	public void password_Enter()
	{
		driver.findElement(password).sendKeys("Welcome123");
	}
	public void check_Select()
	{
		driver.findElement(check).click();
	}
	public void submit_Click()
	{
		driver.findElement(signup).click();
	}

}
