package com.ecshopnew.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.ecshopnew.utils.Config;
import com.ecshopnew.utils.DriverUtils;

import net.sourceforge.htmlunit.corejs.javascript.serialize.ScriptableInputStream;

public class TestBase {
	  public WebDriver driver;
	  @BeforeSuite
	  public void beforeSuite() {
		  DriverUtils.initService();
		
	  }
	  @BeforeMethod
	  public void beforeMethod() {
		    driver=DriverUtils.getDriver();
	  }    
	  @AfterMethod
	  public void afterMethod() {
		  DriverUtils.driverQuit();
	  }
	 @AfterSuite
	  public void afterSuite() {
		 DriverUtils.stopService();
	  }
	  
//	  public static void splitStr(String str) {
//		  String[] split_str=str.split(",");
//		  
//		  
//	  }

}
