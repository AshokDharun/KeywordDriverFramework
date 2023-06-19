package org.kd.keyword;

import java.util.concurrent.TimeUnit;

import org.kd.constants.Constants;
import org.kd.core.Engine;
import org.kd.utlits.ExcelUtilites;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ActionKeyword 
{
	public  static WebDriver driver;

	//Actions
	//launch broser
	public static void openBroswer()
	{
//		if(ExcelUtilites.datacolumnValue.equalsIgnoreCase("chrome"))
//		{
//			System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
//			driver=new ChromeDriver();
//			System.out.println("driver launch");
//		}else
//		{
//			System.out.println("driver not found");
//		}
		switch (ExcelUtilites.datacolumnValue) {
		case Constants.CHROME:
			System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
			driver=new ChromeDriver();
			break;
		case Constants.FIREFOX:
			driver=new FirefoxDriver();
			break;

		default:
			System.out.println(ExcelUtilites.datacolumnValue+"   driver not found");
			break;
		}
	}
	//goto url

	public static void gotourl()
	{
		driver.get(ExcelUtilites.datacolumnValue);//"http://52.66.129.203:4200/#/auth/login");
		driver.manage().window().maximize();	
	}
	//enter username
	public static void enterUsername()
	{
		driver.findElement(Engine.locater).sendKeys(ExcelUtilites.datacolumnValue);;
	}

	//enter password
	public static void enterPassword()
	{
		driver.findElement(Engine.locater).sendKeys(ExcelUtilites.datacolumnValue);
	}
	//click login
	public static void click()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(Engine.locater).click();		
	}

	public static void enterCustID()
	{
		driver.findElement(Engine.locater).sendKeys(ExcelUtilites.datacolumnValue,Keys.ENTER);
	}

}
