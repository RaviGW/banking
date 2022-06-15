package com.EBanking.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class eBanking_LogIn_002 
{
	WebDriver driver;
	
	@FindBy (name="uid")
	private WebElement UserId;
	
	@FindBy (xpath="//input[@name='password']")
	private WebElement Password;
	
	@FindBy (xpath ="//input[@name='btnLogin']")
	private WebElement LoginButton;
	
	@FindBy (xpath ="//a[text()='Log out']")
	private WebElement LogoutButton;
	
	public eBanking_LogIn_002(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void setUserName(String uname)
	{
		UserId.sendKeys(uname);
	}
	
	public void setPassword(String pass)
	{
		Password.sendKeys(pass);
	}
	
	public void clickLoginButton()
	{
		LoginButton.click();
	}
	
	public void clickLogoutButton()
	{
		LogoutButton.click();
	}
}
