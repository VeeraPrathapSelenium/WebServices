package com.ReadingExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static void main(String[] args) throws IOException {
		
		
		
		File f=new File("C:\\Users\\tm\\Desktop\\New Microsoft Office Excel Worksheet.xlsx");
		
		FileInputStream fis=new FileInputStream(f);
		
		
		XSSFWorkbook wrkbook=new XSSFWorkbook(fis);
		
		
		XSSFSheet sht=wrkbook.getSheet("Testdata");
		
	
		
		int rowcount=sht.getLastRowNum();
		
		for(int i=0;i<=rowcount-1;i++)
		{
			
			int columncnt=sht.getRow(i).getLastCellNum();
			
				XSSFCell cell=sht.getRow(i).getCell(0);
				
			
				
				switch (cell.getCellTypeEnum()) {
				case STRING:
					System.out.println(cell.getStringCellValue());
					break;
					
				case NUMERIC:
					System.out.println(cell.getNumericCellValue());
					break;
		
		
				default:
					break;
				}
		
		}	

	}

}
