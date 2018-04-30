package com.ecshopnew.utils;

import java.io.File;
import java.io.IOException;
import java.sql.Driver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.service.DriverService;

import com.ecshopnew.tests.WrappedRemoteWebDriver;

public class DriverUtils {
	private static DriverService service;
	private static String browser = "firefox";
	private static WebDriver driver = null;
	private static Logger logger = LogManager.getLogger();

	public static void  initService(){
		 Config config=new Config("config.properties");
		 String firefoxPath=config.getConfig("firefoxPath");
		 browser=config.getConfig("browser.type");
		 logger.info("获取配置文件中的firefox的路径为："+firefoxPath);
		if ("firefox".equalsIgnoreCase(browser)) {
			service = new GeckoDriverService.Builder()
					.usingFirefoxBinary(
							new FirefoxBinary(new File(firefoxPath)))
					.usingAnyFreePort().usingDriverExecutable(new File("c:/driver/geckodriver.exe")).build();
		} else if ("chrome".equalsIgnoreCase(browser)) {
			service = new ChromeDriverService.Builder().usingDriverExecutable(new File("c:/driver/chromedriver.exe"))
					.usingAnyFreePort().build();
		} else if ("ie".equalsIgnoreCase(browser)) {
			service = new InternetExplorerDriverService.Builder().usingDriverExecutable(new File("c:/driver/IEDriverServer.exe"))
					.usingAnyFreePort().build();
		}else {
			logger.error("未支持浏览器类型！");
			throw new RuntimeException("未支持浏览器类型！");
		}
		try {
			service.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static WebDriver getDriver() {
		 Config config=new Config("config.properties");
		 browser=config.getConfig("browser.type");
		if ("firefox".equalsIgnoreCase(browser)) {
//			driver = new RemoteWebDriver(service.getUrl(), DesiredCapabilities.firefox());
			//为了输出日志，WrappedRemoteWebDriver类继承类RemoteWebDriver
			driver = new WrappedRemoteWebDriver(service.getUrl(), DesiredCapabilities.firefox());
		} else if ("chrome".equalsIgnoreCase(browser)) {
//			driver = new RemoteWebDriver(service.getUrl(), DesiredCapabilities.chrome());
			driver = new WrappedRemoteWebDriver(service.getUrl(), DesiredCapabilities.chrome());
		} else if ("ie".equalsIgnoreCase(browser)) {
//			driver = new RemoteWebDriver(service.getUrl(), DesiredCapabilities.internetExplorer());
			driver = new WrappedRemoteWebDriver(service.getUrl(), DesiredCapabilities.internetExplorer());
		}
		return driver;
	}
	public static void driverQuit() {
		driver.quit();
		
	}

	public static void stopService() {
//		driver.quit();
		service.stop();
	}

}
