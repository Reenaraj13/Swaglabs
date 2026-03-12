package com.teck.swaglabs.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExcelUtility {

	
	public String getDataFromExcel(String sheetName,int rowNum,int cellNum) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis=new FileInputStream("./TestscriptData/TestData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		String data=wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		wb.close();
		
		return data;
		
	}
	
	public int getRowcount(String sheetName) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis=new FileInputStream("./TestscriptData/TestData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		int rowcount=wb.getSheet(sheetName).getLastRowNum();
		wb.close();
		
		return rowcount;
	}
	
	public void setDataIntoExcel(String sheetname,int rownum,int cell,String data) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis=new FileInputStream("./TestscriptData/TestData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		wb.getSheet(sheetname).getRow(rownum).getCell(cell);
		
		FileOutputStream fiso=new FileOutputStream("./TestscriptData/TestData.xlsx");
		wb.write(fiso);
		wb.close();
			
	}
	
	
	
	
		
	

}
