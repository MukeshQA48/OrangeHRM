package com.org.TestUtil;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils 
{

	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static int getRowCount(String xlfile,String xlSheet) throws IOException
	{
		fi=new  FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		sheet=wb.getSheet(xlSheet);
		int rowCount=sheet.getLastRowNum();
		fi.close();
		wb.close();
		return rowCount;
	}
	
	public static int getCellCount(String xlfile,String xlSheet,int rownum) throws IOException
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		sheet=wb.getSheet(xlSheet);
		row=sheet.getRow(rownum);
		int cellCount=row.getLastCellNum();
		wb.close();
		fi.close();
		return cellCount;
	}
	
	public static String getCellData(String xlfile,String xlSheet,int rownum,int colnum) throws IOException
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		sheet=wb.getSheet(xlSheet);
		row=sheet.getRow(rownum);
		cell=row.getCell(colnum);
		String data;
		DataFormatter dataformatter=new DataFormatter();
	    String cellData=dataformatter.formatCellValue(cell);
	    wb.close();
	    fi.close();
	    return cellData;
	}
	
	public static void setCellData(String xlfile,String xlSheet,int rownum,int colnum,String data) throws IOException
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		sheet=wb.getSheet(xlSheet);
		row=sheet.getRow(rownum);
		cell=row.createCell(colnum);
		fo=new FileOutputStream(xlfile);
		wb.write(fo);
		fi.close();
		fo.close();
	}
}
