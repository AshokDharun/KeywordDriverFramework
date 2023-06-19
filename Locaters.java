package org.kd.utlits;

import org.openqa.selenium.By;

public class Locaters 
{
	public  static By getId(String locaterValue)
	{
		return By.id(locaterValue);
	}
	public static By getClassName(String locaterValue)
	{
		return By.className(locaterValue);
	}
	public static By getXpath(String locaterValue)
	{
		return By.xpath(locaterValue);
	}
	public static By getTagName(String locaterValue)
	{
		return By.tagName(locaterValue);
	}
	public static By getLinkText(String locaterValue)
	{
		return By.linkText(locaterValue);
	}
	public static By getparticalLinkText(String locaterValue)
	{
		return By.partialLinkText(locaterValue);
	}
}
