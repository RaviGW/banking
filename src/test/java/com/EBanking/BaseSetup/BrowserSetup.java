package com.EBanking.BaseSetup;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

import com.EBanking.Utilities.ReadConfig;

public class BrowserSetup 
{
	ReadConfig configuration = new ReadConfig();
	WebDriver driver;
	
	public WebDriver openChromeDriver()
	{
		System.setProperty("webdriver.chrome.driver", configuration.getChromePath());
		driver = new ChromeDriver();
		return driver;
	}
	
	public WebDriver openMicrosoftEdgeDriver()
	{
		System.setProperty("webdriver.edge.driver", configuration.getMsEdgePath());
		driver = new EdgeDriver();
		return driver;
	}
	
	public WebDriver openFirefoxDriver()
	{
		System.setProperty("webdriver.edge.driver", configuration.getFirefoxPath());
		driver = new FirefoxDriver();
		return driver;
	}
	
	public static void takeScreenshot(WebDriver driver, String tname) throws IOException, InterruptedException
	{
		TakesScreenshot s =(TakesScreenshot)driver;
		File source = s.getScreenshotAs(OutputType.FILE);
		File dest = new File("./ScreenShots\\img"+125+".jpeg");
		FileHandler.copy(source, dest);
	}
}
