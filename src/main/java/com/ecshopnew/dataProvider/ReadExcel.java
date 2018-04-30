package com.ecshopnew.dataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	public static Object[][] readDataFromExcel(String excelName, String sheetName) {
		Object[][] dataObject = null;
		// InputStream is = new FileInputStream(excelFile);
		InputStream is = null;
		XSSFWorkbook xwb = null;
		try {
			is = ReadExcel.class.getClassLoader().getResourceAsStream(excelName);
			xwb = new XSSFWorkbook(is);
			XSSFSheet sheet = xwb.getSheet(sheetName);
			int lastRowNum = sheet.getLastRowNum();// row=4
			int lastCellNum = sheet.getRow(lastRowNum).getLastCellNum();// cell=3
			dataObject = new Object[lastRowNum][lastCellNum];
			for (int i = 1; i <= lastRowNum; i++) {// 从1开始就是从第二行开始读测试数据
				for (int k = 0; k < lastCellNum; k++) {
					String str = "";
					if (sheet.getRow(i).getCell(k).getCellType() == XSSFCell.CELL_TYPE_NUMERIC)
						str = String.valueOf(Long.parseLong(sheet.getRow(i).getCell(k).getRawValue(), 10));
					else
						str = String.valueOf(sheet.getRow(i).getCell(k));
					if (str.equalsIgnoreCase("<empty>")) {
						str = "";
					}
					dataObject[i - 1][k] = str;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				xwb.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return dataObject;
	}

	public static void main(String[] args) throws Exception {
		// Object[][] data=ReadExcel.readDataFromExcel("c:\\\\ecshopTestCase.xlsx");
		Object[][] data = ReadExcel.readDataFromExcel("ecshopTestCase.xlsx", "regTest");
		System.out.println(data[data.length - 1].length);
		for (int i = 0; i < data.length; i++) {
			for (int k = 0; k < data[data.length - 1].length; k++) {
				System.out.println(data[i][k]);
			}
		}
	}

}
