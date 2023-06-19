package org.kd.core;

import java.lang.reflect.Method;

import org.kd.constants.Constants;
import org.kd.keyword.ActionKeyword;
import org.kd.utlits.ExcelUtilites;
import org.kd.utlits.Locaters;
import org.openqa.selenium.By;

public class Engine 
{
	
	ActionKeyword action;
	Method[] mets;//java reflection method
	public static By locater;

	public  Engine()
	{
		action=new ActionKeyword();
		mets=action.getClass().getMethods();// using java reflection api- get all the actionkeyword class methods
	}

	public void keywordexection() throws Exception
	{
		for(int i=0;i<mets.length;i++)
		{
			if(mets[i].getName().equalsIgnoreCase(ExcelUtilites.keywordcolumnValue))
			{
				mets[i].invoke(action);// invokes method called action call methods
			}
		} 
	}

	public static void main(String[] args) throws Exception 
	{

		ExcelUtilites xlut=new ExcelUtilites();
		xlut.readExcelFile(Constants.EXCEL_LOCATION);
		Engine en=new Engine();// while create object call Engine()constructor -> get all the actionkeyword methods name
		
		for(int row=1;row<=ExcelUtilites.lastRow ;row++)
		{

			xlut.getLocatersKeywordsAndData(row,Constants.LOCATERCOLUMN,Constants.ACTKEYWORDCOLUMN,Constants.DATACOLUMN);
			en.findWebElementTobeUsed();
			en.keywordexection();
		}

	}
	public void findWebElementTobeUsed()
	{
		switch (ExcelUtilites.locaterName) {
		case Constants.ID: 
			locater= Locaters.getId(ExcelUtilites.locaterValue);
			break;

		case Constants.CLASS_NAME: 
			locater=Locaters.getClassName(ExcelUtilites.locaterValue);
			break;
		case Constants.XPATH: 
			locater=Locaters.getXpath(ExcelUtilites.locaterValue);
			break;
		case Constants.CSS_SELECTOR: 
			
			break;
	case Constants.LINK_TEXT: 
			
			break;
		default:
			System.out.println("selectors not found");
			break;
		}
	}

}
