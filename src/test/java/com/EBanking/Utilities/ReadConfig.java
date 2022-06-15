package com.EBanking.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig 
{
	Properties pro;
	public ReadConfig()
	{
		File src = new File("./Configuration\\config.properties");
		
		try
		{
			FileInputStream file= new FileInputStream(src);
			pro = new Properties();
			pro.load(file);
		}
		catch (Exception e)
		{
			System.out.println("Exception is" +e.getMessage());
		}	
	}
	
	public String getApplicationURL()
	{
		String URL= pro.getProperty("ApplicationUrl");
		return URL;
	}
	
	public String getUserName()
	{
		String UserName=pro.getProperty("UserId");
		return UserName;
	}
	
	public String getPassword()
	{
		String Password = pro.getProperty("Password");
		return Password;
	}
	
	public String getChromePath()
	{
		String chromePath = pro.getProperty("ChromePath");
		return chromePath;
	}
	
	public String getMsEdgePath()
	{
		String edgePath = pro.getProperty("EdgePath");
		return edgePath;
	}
	
	public String getFirefoxPath()
	{
		String firefoxPath = pro.getProperty("FirefoxPath");
		return firefoxPath;
	}
}
