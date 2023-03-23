/**
 * 
 */
package com.edepoze.utilitifiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author MuraliSeethalam
 *
 */

public class OutputData {
	
//Storing Client And Enterprice Client Details
	public void WriteExcel(String sheetName, String cellvalue, int row, int col) throws Exception {

		String excelPath="./src/main/resources/ExcelData/LoginData.xlsx";
		File file=new File(excelPath);
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet Sheet=wb.getSheet(sheetName);

		Sheet.getRow(0).getCell(0).getStringCellValue();

		Sheet.getRow(row).createCell(col).setCellValue(cellvalue);

		FileOutputStream fos = new FileOutputStream(excelPath);
		wb.write(fos);
		wb.close();
		fos.close();

	}
	public static ArrayList<String> readdatafromexl() throws Exception {

		FileInputStream inputStream = new FileInputStream("./src/main/resources/ExcelData/LoginData.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(inputStream);
		Sheet sheet=wb.getSheetAt(0);
		ArrayList<String> al1=new ArrayList<String>();
		for(int rowIndex= sheet.getFirstRowNum()+1; rowIndex <=sheet.getLastRowNum(); rowIndex++) {

			for(int column=sheet.getRow(rowIndex).getFirstCellNum(); column<sheet.getRow(rowIndex).getLastCellNum();column++) {

				String al=sheet.getRow(rowIndex).getCell(column).getStringCellValue();

				al1.add(al);

			}

		}
		wb.close();
		return al1;


	}
	public static String compare() throws Exception {
		ArrayList<String> al1=	readdatafromexl();
		return al1.get(1);
	}	

	public static String EnterClientUserName() throws Exception {
		ArrayList<String> al1=	readdatafromexl();
		return al1.get(1);
	}	
	public static String EnterClientPassword() throws Exception {
		ArrayList<String> al1=	readdatafromexl();
		return al1.get(3);
	}

	public static String ClientName() throws Exception {
		ArrayList<String> al1=	readdatafromexl();
		return al1.get(5);	
	}
	public static String RegisterEmailId() throws Exception {
		ArrayList<String> al1=	readdatafromexl();
		return al1.get(7);	
	}

	public static String EnterpriseName() throws Exception {
		ArrayList<String> al1=	readdatafromexl();
		return al1.get(15);	
	}
	public static String EnterEnterpriseUserName() throws Exception {
		ArrayList<String> al1=	readdatafromexl();
		return al1.get(11);	
	}
	public static String EnterEnterprisePassword() throws Exception {
		ArrayList<String> al1=	readdatafromexl();
		return al1.get(13);	
	}
	
	public static String ReName() throws Exception {
		ArrayList<String> al1=	readdatafromexl();
		return al1.get(17);	
	}
	public static String ClientPasswordsetuplink() throws Exception {
		ArrayList<String> al1=	readdatafromexl();
		return al1.get(19);	
	}
	public static String EnterprisePasswordsetuplink() throws Exception {
		ArrayList<String> al1=	readdatafromexl();
		return al1.get(21);	
	}
	public static String ExtentReportFileName() throws Exception {
		ArrayList<String> al1=	readdatafromexl();
		return al1.get(23);	
	}
	
	

}

