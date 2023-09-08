package com.VtigerFrameWork.GenericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.VtigetFrameWork.ObectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassUtility {

	public WebDriver driver= null;
	public WebDriverUtility wUtil= new WebDriverUtility();
	public ExcelFileUtility eUtil= new ExcelFileUtility();
	public PropertyFileUtility pUtil= new PropertyFileUtility();
	
	
	@BeforeClass
	public void beforeClass() throws IOException
	{
		String browserValue= pUtil.readDataFromPropertyFile("Browser");
		String vTigerUrl= pUtil.readDataFromPropertyFile("BaseUrl");
		
		if(browserValue.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}
		else if(browserValue.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		else if(browserValue.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
		}
		else
		{
			System.out.println("Invalid Browser Value.");
		}
		
		wUtil.implicitWait(driver, 10);
		wUtil.windowMaximize(driver);
		driver.get("vTigerUrl");
	}
	
	@BeforeMethod
	public void beforeMethod() throws IOException
	{
		String userName= pUtil.readDataFromPropertyFile("UserName");
		String password= pUtil.readDataFromPropertyFile("Password");
		String expectedTitle= pUtil.readDataFromPropertyFile("HomePageTitle");
		
		LoginPage lp= new LoginPage(driver);
		lp.loginToVtigerApplication(userName, password);
		
		lp.validateLogin(driver, expectedTitle);
	}
	
	@AfterClass
	public void afterClass()
	{
		driver.quit();
	}
	
	@AfterMethod
	public void afterMethod()
	{
		
	}
}
