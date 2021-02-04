package com.main.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class HomePage  {
	WebDriver driver;
	By scrolltoElements= By.xpath("//div[@title='Scroll to Element']");
	By profile= By.id("my-profile-link");
	By hoverprofile= By.xpath("//div[@class='user-default-avatar ng-scope']");
	By logout= By.xpath("//div[@class='user-popup-panel-footer-logout']");
    public static By spinner= By.xpath("//div[@class='top-bar-container ng-scope']");
    public static By scroll = By.xpath("//div[@class='carousel-arrow-container'][2]");
    By imageCompare= By.xpath("//div[@title='Image Comparison']");
    public static By imageCompareInstall= By.xpath("//div[@class='addon-info-action addon-info-btn blue ng-binding ng-scope']");
    public static By imageCompareUnInstall= By.xpath("//div[@class='addon-info-action addon-info-link ng-binding ng-scope']");
    By unInstallImageComparisonConfirm= By.xpath("//div[@class='ng-binding ng-scope ng-alert-all-buttons-epic ng-alert-right ng-alert-blue-button']");
    By closeAddOnInfo= By.xpath("//div[@class='addon-info-close-icon']");
    By install_Message= By.xpath("//div[text()='Succeeded to install \"Image Comparison\" addon!']");
    By uninstall_Message= By.xpath("//div[text()='Succeeded to uninstall \"Image Comparison\" addon!']");
    
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
	public void imageComparisonScrollClick() {
		
		for (int i=1;i<=6;i++)
		{
			driver.findElement(scroll).click();
		}
		driver.findElement(imageCompare).click();
	}
	
	public void image_Comapre_Install() {
		driver.findElement(imageCompareInstall).click();
	}
	public void image_Comapre_UnInstall() {
		driver.findElement(imageCompareUnInstall).click();
	}
	public void image_Comapre_UnInstall_Confirm() {
		driver.findElement(unInstallImageComparisonConfirm).click();
	}
	public String install_message()
	{
		String text=driver.findElement(install_Message).getText();
		return text;
	}
	public String uninstall_message()
	{
		String text=driver.findElement(uninstall_Message).getText();
		return text;
	}
}
