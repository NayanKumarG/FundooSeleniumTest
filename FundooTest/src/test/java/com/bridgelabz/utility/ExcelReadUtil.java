package com.bridgelabz.utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadUtil {
	
//	  public static String[][] readExcelInto2DArray(String excelFilePath, String sheetName, int totalCols) {
//
//		    File file = new File(excelFilePath);
//
//		    String[][] tabArray = null;
//
//		    try {
//		      OPCPackage opcPackage = OPCPackage.open(file.getAbsolutePath());
//
//		      Workbook wb = WorkbookFactory.create(opcPackage);
//
//		      Sheet sheet = wb.getSheet(sheetName);
//
//		      int totalRows = sheet.getLastRowNum() + 1;
//
//		      tabArray = new String[totalRows][totalCols];
//
//		      for (int i = 0; i < totalRows; i++) {
//		        for (int j = 0; j < totalCols; j++) {
//		          Cell cell = sheet.getRow(i).getCell(j);
//
//		          if (cell == null)
//		            continue;
//
//		          switch (cell.getCellType()) {
//		          case BOOLEAN:
//		            tabArray[i][j] = String.valueOf(cell.getBooleanCellValue());
//		            break;
//		          case NUMERIC:
//		            tabArray[i][j] = String.valueOf(cell.getNumericCellValue());
//		            break;
//		          case STRING:
//		            tabArray[i][j] = cell.getStringCellValue();
//		            break;
//		          default:
//		            tabArray[i][j] = "";
//		            break;
//		          }
//		        }
//		      }
//		    } catch (Exception e) {
//		      e.printStackTrace();
//		      throw new RuntimeException(e);
//		    }
//
//		    return tabArray;
//		  }
	
	XSSFWorkbook wb;
	XSSFSheet sheet;
	
	public ExcelReadUtil(String excelPath)
	{
		
		try
		{
			File src = new File(excelPath);
			FileInputStream file = new FileInputStream(src);
			wb = new XSSFWorkbook(file);
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}
		
		public String getData(int sheetNumber , int row , int column)
		{
			sheet = wb.getSheetAt(sheetNumber);
			String data = sheet.getRow(row).getCell(column).getStringCellValue();
			return data;
		}
		
		public int getRowCount(int sheetIndex)
		{
			int row = wb.getSheetAt(sheetIndex).getLastRowNum();
			row = row +1;
			return row;
		}
		
	

		}


