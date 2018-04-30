package com.ecshopnew.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestLog4j {
	private static final Logger logger = LogManager.getLogger();

	public static void main(String[] args) {
		logger.info("helloword");
	}

}
