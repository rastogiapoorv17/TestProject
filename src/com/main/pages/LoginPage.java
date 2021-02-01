package com.main.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
	
	By signUpLink = By.id("tp-signup-link");
	By uname= By.id("username");
	By passwordElement= By.id("password");
	By submit= By.xpath("//div[@class='tp-submit-wrapper']/input[@name='login']");
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void loginField(String login) {
		driver.findElement(uname).sendKeys(login);
	}
	
	public void passwordField(String password) {
		driver.findElement(passwordElement).sendKeys(password);
	}
	public void loginsubmit() {
		driver.findElement(submit).click();
	}
	public void signupClick() {
		driver.findElement(signUpLink).click();
	}
	
}
