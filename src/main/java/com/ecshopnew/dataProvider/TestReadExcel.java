package com.ecshopnew.dataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.gargoylesoftware.htmlunit.javascript.host.dom.Text;

public class TestReadExcel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputStream is = null;
		XSSFWorkbook xwb = null;
		try {
			// InputStream is = new FileInputStream("c:\\ecshopTestCase.xlsx");
			is = ReadExcel.class.getClassLoader().getResourceAsStream("ecshopTestCase.xlsx");
			xwb = new XSSFWorkbook(is);
			// XSSFSheet sheet = xwb.getSheetAt(0);
			XSSFSheet sheet = xwb.getSheet("regTest");
			int lastRowNum = sheet.getLastRowNum();// row=4 从0开始有5行记录
			int lastCellNum = sheet.getRow(lastRowNum).getLastCellNum();// cell=3
			for (int i = 1; i < lastRowNum + 1; i++) {// 从1开始就是从第二行开始读测试数据
				System.out.print("第" + (i + 1) + "行：");
				for (int k = 0; k < lastCellNum; k++) {
					if (sheet.getRow(i).getCell(k).getCellType() == XSSFCell.CELL_TYPE_NUMERIC)
						System.out.print(Long.parseLong(sheet.getRow(i).getCell(k).getRawValue(),10));
					else
						System.out.print(sheet.getRow(i).getCell(k));
					System.out.print("\t");
				}
				System.out.println("");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

	}

}
