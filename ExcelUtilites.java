package org.kd.utlits;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilites {
	FileInputStream file;
	XSSFWorkbook book;
	XSSFSheet sheet;
	XSSFCell cell;
	public static String locatercolumnValue;
	public static String locaterName;
	public static String locaterValue;
	public static String keywordcolumnValue;
	public static String datacolumnValue;
	public static int lastRow;

	public void readExcelFile(String location) throws IOException
	{
		file=new FileInputStream(location);//"./data/BoomData.xlsx"
		book=new XSSFWorkbook(file);
		sheet=book.getSheetAt(0);
		lastRow=sheet.getLastRowNum();
	}

	public void getLocatersKeywordsAndData(int row, int locatercolumn,int actkeywordcolumn,int datacolumn )
	{
		locatercolumnValue = sheet.getRow(row).getCell(locatercolumn).toString().trim();
		System.out.println(locatercolumnValue);
		if(!locatercolumnValue.contains("NA"))
		{
			locaterName	= locatercolumnValue.split("=")[0].toString().trim();
			locaterValue	= locatercolumnValue.split("=")[1].toString().trim();
		}else
		{
			locaterName="NA";
			locaterValue="NA";
		}	 
		keywordcolumnValue= sheet.getRow(row).getCell(actkeywordcolumn).toString().trim();

		//datacolumnValue=sheet.getRow(row).getCell(datacolumn).toString().trim();

		cell=sheet.getRow(row).getCell(datacolumn);

		DataFormatter df=new DataFormatter();
		CellType  tpe=cell.getCellType();
		switch (tpe) {
		case NUMERIC:
			double v2=sheet.getRow(row).getCell(datacolumn).getNumericCellValue();
			String v3=df.formatCellValue(cell);
			System.out.println("numeric value "+v3);
			datacolumnValue = v3;
			break;
		case STRING:
			String value=sheet.getRow(row).getCell(datacolumn).getStringCellValue();
			System.out.println("String value"+value);
			datacolumnValue=value;
			break;

		default:
			break;
		}
		
		System.out.println(locaterName +"  : "+locaterValue+";     Keyword:-> "+keywordcolumnValue+" ; data:-> "+datacolumnValue);
	}


}
