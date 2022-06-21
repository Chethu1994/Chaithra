package com.crm.comcast.genericutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * it is developed  using Apache Poi libraries ,which is used to handle microsoft excel sheet
 * @author chethu
 *
 */


public class ExcelUtility {
	/**
	 * it is used to read the data from excel-workbook based on below 
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum 
	 * @return String data
	 * @throws Throwable
	 */
	public  String ReadDataFromExcelFile(String sheetName,int rownum,int cellnum) throws Throwable 
	{
		FileInputStream fis= new FileInputStream("./src/test/resources/Testdata.xlsx");
		Workbook book= WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(sheetName);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		String data = cell.toString();
		return data;
	}
	/**
	 * it is used to write the data into excel   file
	 * @throws Throwable 
	 * 
	 */
	public void WriteDataIntoExcel(String sheetName,int rownum,int cellnum,String data) throws Throwable {
	FileInputStream fis= new FileInputStream("./src/test/resources/Testdata.xlsx");
	Workbook book= WorkbookFactory.create(fis);
	Sheet sheet = book.getSheet(sheetName);
	Row row = sheet.getRow(rownum);
	Cell cell = row.getCell(cellnum);
	cell.setCellValue(data);
	FileOutputStream fis1=new FileOutputStream("./src/test/resources/Testdata.xlsx");
	book.write(fis1);
	
}
	
	public  String ReadIntDataFromExcelFile(String sheetName,int rownum,int cellnum) throws Throwable 
	{
		FileInputStream fis= new FileInputStream("./src/test/resources/Testdata.xlsx");
		Workbook book= WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(sheetName);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		DataFormatter formater=new DataFormatter();
		String data = formater.formatCellValue(cell);
		
		return data;
	}
	public  double ReadIntegerDataFromExcelFile(String sheetName,int rownum,int cellnum) throws Throwable 
	{
		FileInputStream fis= new FileInputStream("./src/test/resources/Testdata.xlsx");
		Workbook book= WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(sheetName);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		double data = cell.getNumericCellValue();
		return data;



}}
