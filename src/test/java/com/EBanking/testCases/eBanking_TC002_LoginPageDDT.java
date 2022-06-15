package com.EBanking.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.EBanking.BaseSetup.BrowserSetup;
import com.EBanking.PageObjects.eBanking_LogIn_002;
import com.EBanking.Utilities.ReadConfig;
import com.EBanking.Utilities.XLUtils;

public class eBanking_TC002_LoginPageDDT extends BrowserSetup
{

	ReadConfig configuration= new ReadConfig();
	WebDriver driver;
	Logger log;
	@Parameters("browser")	
	@BeforeClass
	public void browserLaunch(String browser) throws InterruptedException 
	{		
		if(browser.equals("ChromeBrowser"))
		{
			driver = openChromeDriver();
		}
		
		if(browser.equals("EdgeBrowser"))
		{
			driver = openMicrosoftEdgeDriver();
		}
		
		if(browser.equals("FirefoxBrowser"))
		{
			driver = openFirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		log = Logger.getLogger("EBanking DDT");
		PropertyConfigurator.configure("log4j.properties");
		log.info("Browser launched successfully");
	}
	
	@BeforeMethod
	public void launchApplication() throws InterruptedException
	{
		driver.get(configuration.getApplicationURL());
		
		log.info("application launched succesfully");
	}
	
	@Test (dataProvider="LoginData")
	public void loginToEBanking(String user, String pass) throws InterruptedException 
	{
		eBanking_LogIn_002 login = new eBanking_LogIn_002(driver);
		login.setUserName(user);
	
		login.setPassword(pass);

		login.clickLoginButton();
	
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
		}
		else
		{
			Assert.assertTrue(true);
			login.clickLogoutButton();
			
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}			
	}
	
	public boolean isAlertPresent()
	{
		try 
		{
			driver.switchTo().alert();
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	@DataProvider (name="LoginData")
	String[][]getData() throws IOException
	{
		String path = System.getProperty("user.dir")+"/src/test/java/com/EBanking/TestData/Student_Detail.xlsx";
		int rownum=XLUtils.getRowCount(path,"login_details"); 
		int cellnum=XLUtils.getCellCount(path,"login_details",1);
		
		String loginData[][] = new String[rownum][cellnum];
		for(int i=2;i<=rownum;i++)
		{
			for(int j=0;j<cellnum;j++)
			{
				loginData[i-2][j]=XLUtils.getCellData(path,"login_details",i,j);
			}
		}
		return loginData;
	}
	
	@AfterMethod
	public void getStatus()
	{	
		driver.getTitle();
		log.info("window title verified");
	}
	
	@AfterClass
	public void closeApplication()
	{
		driver.close();
		log.info("driver is closed");
	
	}

}
