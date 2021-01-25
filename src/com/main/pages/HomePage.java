package com.main.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage {
	
	WebDriver driver;
	
	By scrolltoElements= By.xpath("//div[@title='Scroll to Element']");
	By profile= By.id("my-profile-link");
	By hoverprofile= By.xpath("//div[@class='user-default-avatar ng-scope']");
	By logout= By.xpath("//div[@class='user-popup-panel-footer-logout']");
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void click_Element() {
		driver.findElement(scrolltoElements).click();
	}
	
	public void hoverProfile()
	{
		Actions act= new Actions(driver);
		WebElement target= driver.findElement(hoverprofile);
		act.moveToElement(target).perform();
	}
	public String myProfile()
	{
		String text=driver.findElement(profile).getText();
		return text;
	}
	public void lOut()
	{
		driver.findElement(logout).click();
	}

}
