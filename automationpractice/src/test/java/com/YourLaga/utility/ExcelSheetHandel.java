
package com.YourLaga.utility;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;



import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



/*@Authore:P Sugyani Achary
 *@Descraption:her we handle excel sheet file.this file support to geting data from excel sheet and send data to the 
 *excel sheet.  
 * 
 * 
 * */

public class ExcelSheetHandel 
{
	//load logger file
	private static Logger Log = Logger.getLogger(ExcelSheetHandel.class.getName());
	//copy data to copy input excel  sheet to output excel sheet.
	public void copyData(){
		try {
			//load file of excel sheet.
			FileInputStream file = new FileInputStream(new File(PropertyHandler.getProperty("InPutDataFile")));
			//Get the workbook instance for XLS file 
			HSSFWorkbook workbook = new HSSFWorkbook(file);
			//Get first sheet from the workbook
			HSSFSheet sheet = workbook.getSheetAt(0);
			//Iterate through each rows from first sheet
			Iterator<Row> rowIterator = sheet.iterator();
			while(rowIterator.hasNext()) {
				Row row = rowIterator.next();
				//For each row, iterate through each columns
				Iterator<Cell> cellIterator = row.cellIterator();
				while(cellIterator.hasNext()) {

					Cell cell = cellIterator.next();

					switch(cell.getCellType()) {
					case Cell.CELL_TYPE_BOOLEAN:

						break;
					case Cell.CELL_TYPE_NUMERIC:

						break;
					case Cell.CELL_TYPE_STRING:

						break;
					}
				}
			}
			file.close();
			FileOutputStream out =new FileOutputStream(new File(PropertyHandler.getProperty("OutPutDataFile")));
			workbook.write(out);
			out.close();
		} catch (FileNotFoundException e) {
			Log.info("exception in reading  data from list");
		} catch (IOException e) {
			Log.info("exception in reading  data from list");
		}
	}
	//set the data in excel sheet
	public void setExcelStringData(String PathOFExcel,String  sheetName, int rowNum , int columeNum , String data) throws IOException {
		//Property   file add
		//out put data set
		FileInputStream fis = new FileInputStream(PathOFExcel);
		HSSFWorkbook workbook = new HSSFWorkbook(fis);
		Sheet sh = workbook.getSheet(sheetName);
		Row r = sh.getRow(rowNum);
		Cell c = r.createCell(columeNum);
		c.setCellType(Cell.CELL_TYPE_STRING);
		c.setCellValue(data);
		//set the value in out put data(OutPutDataFile)
		FileOutputStream fos = new FileOutputStream(PathOFExcel);
		workbook.write(fos);
		//fis.close();
	}
	public void setErrorMessage(String  sheetName, int rowNum , int columeNum , String data) throws IOException{
		// Create Workbook and Worksheet
		FileInputStream fis = new FileInputStream("../LCECAutomation/testdata/TestData.xls"); 
		HSSFWorkbook my_workbook = new HSSFWorkbook(fis);
		HSSFSheet my_sheet = my_workbook.getSheet(sheetName);
		// Get access to HSSFCellStyl
		HSSFCellStyle my_style = my_workbook.createCellStyle();
		// We will now specify a background cell color */
		my_style.setFillPattern(HSSFCellStyle.FINE_DOTS );
		my_style.setFillForegroundColor(new HSSFColor.BLUE_GREY().getIndex());
		my_style.setFillBackgroundColor(new HSSFColor.PINK().getIndex());

		//Create a row in the sheet */
		Row row = my_sheet.getRow(rowNum);
		//Create a cell
		Cell cell = row.createCell(columeNum);
		cell.setCellValue(data);
		//Attach the style to the cell
		cell.setCellStyle(my_style);
		//Write changes to the workbook
		FileOutputStream out = new FileOutputStream(new File("../LCECAutomation/testdata/TestData.xls"));
		my_workbook.write(out);
	}

	public String getExcelData(String Sheetname,int rowno,int collno) throws IOException
	{
		FileInputStream fis = new FileInputStream("../Catalyst/testdata/TestData.xls"); 
		HSSFWorkbook my_workbook = new HSSFWorkbook(fis);
		HSSFSheet sheet = my_workbook.getSheet(Sheetname);
		Row row = sheet.getRow(rowno);
		String Data=row.getCell(collno).getStringCellValue();
		return Data;
	}

	public int RowCount(String Sheetname) throws IOException
	{
		FileInputStream fis = new FileInputStream("../Catalyst/testdata/TestData.xls"); 
		Workbook book = new HSSFWorkbook(fis);
		Sheet sheet = book.getSheet(Sheetname);
		int setRowNumber=sheet.getLastRowNum();
		System.out.println(sheet.getLastRowNum());
		return setRowNumber;





		// FileInputStream fis = new FileInputStream("../Catalyst/testdata/TestData.xls");
		// Workbook workbook = new HSSFWorkbook(fis);
		//Sheet sheet = workbook.getSheet("Sheet");
		//Row Row = sheet.getRow(row);
		//int colNum = row.getLastCellNum();
		// System.out.println("Total Number of Columns in the excel is : "+colNum);
		//int setRowNumber = Row.getLastCellNum();

		//return setRowNumber;
	}

	/*public void editExcelSheet(String PathOFExcel,String  sheetName, int rowNum , int columeNum , String data) throws IOException 
	{

		FileInputStream inputStream = new FileInputStream(PathOFExcel);
		Workbook workbook = null;
		//String fileExtensionName = PathOFExcel.substring(PathOFExcel.indexOf("."));
		if(PathOFExcel.endsWith("xlsx"))
		{
			workbook = new XSSFWorkbook(inputStream);
		}
		else if(PathOFExcel.endsWith("xls"))
		{
			workbook = new HSSFWorkbook(inputStream);
		}

		Sheet sheet = workbook.getSheet(sheetName);
		Row r = sheet.getRow(rowNum);
		Cell c = r.createCell(columeNum);
		c.setCellType(Cell.CELL_TYPE_STRING);
		c.setCellValue(data);
		//set the value in out put data(OutPutDataFile)
		FileOutputStream fos = new FileOutputStream(PathOFExcel);
		workbook.write(fos);
	}*/
	public static void editExcelSheet(String username,String Date) throws IOException 
	{

		for(int i=1;i<=4;i++)
		{
			editExcelSheet("../LCECAutomation/KCReportExpected.xlsx", "Sheet0", 35+i, 0, username+i);
			editExcelSheet("../LCECAutomation/KCReportExpected.xlsx", "Sheet0", 35+i, 13, Date);
		}
	}

	public static void  editExcelSheet(String PathOFExcel,String  sheetName, int rowNum , int columeNum , String data) throws IOException
	{
		try {
			FileInputStream inputStream = new FileInputStream(new File(PathOFExcel));
			Workbook workbook;

			workbook = WorkbookFactory.create(inputStream);



			Sheet sheet = workbook.getSheet(sheetName);
			Row r = sheet.getRow(rowNum);
			Cell c = r.createCell(columeNum);
			c.setCellType(Cell.CELL_TYPE_STRING);
			c.setCellValue(data.toUpperCase());
			//set the value in out put data(OutPutDataFile)
			FileOutputStream fos = new FileOutputStream(PathOFExcel);
			workbook.write(fos);

		} catch (InvalidFormatException e) {

			Assert.fail("Expected KC Report failed to be updated with user");
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}
	private HSSFSheet getHssfSheet(String  sheetNumber) {
		HSSFSheet hssfSheet = null;	

		try {
			FileInputStream file = new FileInputStream(new File(PropertyHandler.getProperty("TESTDATA")));
			HSSFWorkbook hssfWorkbook = new HSSFWorkbook(file);
			hssfSheet = hssfWorkbook.getSheet(sheetNumber);
		} catch (FileNotFoundException e) {		
			Log.info("exception in reading  data from list");
		} catch (IOException e) {
			Log.info("exception in reading  data from list");
		}
		return hssfSheet;
	}
	

}
