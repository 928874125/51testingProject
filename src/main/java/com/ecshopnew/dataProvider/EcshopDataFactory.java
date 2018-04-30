package com.ecshopnew.dataProvider;

import org.testng.annotations.DataProvider;

public class EcshopDataFactory {
	@DataProvider(name="loginTestData")
	public static Object[][] loginTestData(){
//		return new Object[][] {
//			new Object[] {"zhangsan","12345678","��¼�ɹ�"},
//			new Object[] {"lisi","12345678","�û������������"},
//			new Object[] {"","12345678","�û�������Ϊ��"},
//			new Object[] {"lisi","","��¼���벻��Ϊ��"}
//		};
		return ReadExcel.readDataFromExcel("ecshopTestCase.xlsx", "loginTest");
	}
	@DataProvider(name="regTestData")
	public static Object[][] regTestData(){
		return ReadExcel.readDataFromExcel("ecshopTestCase.xlsx", "regTest");
	}

}
