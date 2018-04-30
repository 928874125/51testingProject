package com.ecshopnew.tests;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalysis implements IRetryAnalyzer {

	private static final int MAX=1;
	private int count=0;

	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(count<MAX) {
			count++;
			return true;
		}else {
			return false;
		}
		
	}
}
