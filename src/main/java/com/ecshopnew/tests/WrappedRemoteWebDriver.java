package com.ecshopnew.tests;

import java.io.File;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
/*
 * ���°�װRemoteWebDriver���̳�RemoteWebDriver����дfindElement��findElements����Ԫ�ط�����ʵ��Ԫ�ز���ʱ����־��¼
 * 
 * 
 */

public class WrappedRemoteWebDriver extends RemoteWebDriver {
	private static Logger logger = LogManager.getLogger();

	public WrappedRemoteWebDriver(URL remoteAddress, Capabilities capabilities) {
		super(remoteAddress, capabilities);
	}

	@Override
	protected WebElement findElement(String by, String using) {
		// TODO Auto-generated method stub
		WebElement element = null;
		try {
			element = super.findElement(by, using);
			logger.info("ͨ��" + by + "��������" + using + "Ԫ��,���ҵ�");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info("ͨ��" + by + "��������" + using + "Ԫ���쳣��ԭ����" + e.getMessage());

			// e.printStackTrace();
		}
		return element;
	}

	@Override
	protected List<WebElement> findElements(String by, String using) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		List<WebElement> elements = null;
		try {
			elements = super.findElements(by, using);
			logger.info("ͨ��" + by + "��������" + using + "Ԫ��,���ҵ�Ԫ��" + elements.size() + "��");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info("ͨ��" + by + "��������" + using + "Ԫ���쳣��ԭ����" + e.getMessage());

		}
		return elements;
	}

	public void takeScreenShot(String fileName) {
		File screenShot = ((TakesScreenshot) this).getScreenshotAs(OutputType.FILE);
		File shotDir = new File("screenshots");
		if (!shotDir.exists() || !shotDir.isDirectory()) {
			logger.info("screenshotsĿ¼ �����ڣ�,������Ŀ¼ ");
			shotDir.mkdirs();
		}
		File file = new File(shotDir, fileName);
		screenShot.renameTo(file);
		logger.info("�����ѳɹ��������·�� Ϊ��" + file.getAbsolutePath());
	}

}
