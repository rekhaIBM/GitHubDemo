package com.uitest.rmt.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadFromExcel {

	List<HashMap<String, String>> excelData = new ArrayList<HashMap<String, String>>();

//	static HashMap<String, String> rowDataGBG = new HashMap<>();

	public List<HashMap<String, String>> ReadFromExcelfile(String sheetName) throws IOException {

		String excelFilePath = "./excelSheet/CTGUISheet.xlsx";

		FileInputStream fis = new FileInputStream(excelFilePath);

		XSSFWorkbook workbook = new XSSFWorkbook(fis);
//		XSSFSheet sheet = workbook.getSheetAt(0);
		XSSFSheet sheet = workbook.getSheet(sheetName);

//		Iterator iterator = sheet.iterator();

//		while (iterator.hasNext()) {
//			XSSFRow row = (XSSFRow) iterator.next();

//			Iterator cellIterator = row.cellIterator();

//			while (cellIterator.hasNext()) {
//				XSSFCell cell = (XSSFCell) cellIterator.next();
//
//				switch (cell.getCellType()) {
//				case STRING:
//					System.out.print(cell.getStringCellValue());
//					break;
//				case NUMERIC:
//					System.out.print(cell.getNumericCellValue());
//					break;
//				case BOOLEAN:
//					System.out.print(cell.getBooleanCellValue());
//					break;
//				default:
//					break;
//				}
//				System.out.print(" | ");
//			}
//			System.out.println();
//		}

//		for (int i = 1; i <= 1; i++) {
//			Row row = sheet.getRow(0);
//			for (int j = 0; j < row.getLastCellNum(); j++) {
//				String key = row.getCell(j).getStringCellValue();
//				String value = sheet.getRow(i).getCell(j).getStringCellValue();
//				rowDataGBG.put(key, value);
//			}
//		}

		int rowCount = sheet.getLastRowNum();

		for (int i = 1; i <= rowCount; i++) {
			Row row = sheet.getRow(0);
			HashMap<String, String> rowData = new HashMap<>();
			for (int j = 0; j < row.getLastCellNum(); j++) {
				String key = row.getCell(j).getStringCellValue();
				String value = sheet.getRow(i).getCell(j).getStringCellValue();
				rowData.put(key, value);
			}
			excelData.add(rowData);
		}

		return excelData;

	}

}
