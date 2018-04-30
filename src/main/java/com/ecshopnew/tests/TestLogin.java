package com.ecshopnew.tests;

import org.testng.annotations.Test;

import com.ecshopnew.pageObjects.IndexPage;
import com.ecshopnew.pageObjects.LoginPage;
import com.ecshopnew.utils.DriverUtils;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class TestLogin extends TestBase{

  @Test
  public void test() {
	 driver.get("http://localhost:5555/ecshop");
	 IndexPage indexPage=new IndexPage(driver);
	 indexPage.click_login_link();
	 LoginPage loginPage=new LoginPage(driver);
	 loginPage.input_username("zhangsan");
	 loginPage.input_pwd("12345678");
	 loginPage.click_submit_btn();
//	 System.out.println(driver.getPageSource());
	 loginPage.assert_result_text("µÇÂ¼³É¹¦");
  }
 
}
