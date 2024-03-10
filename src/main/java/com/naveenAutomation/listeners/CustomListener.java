package com.naveenAutomation.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.naveenAutomation.testBase.TestBase;
import com.naveenAutomation.utilities.CommonUtils;

public class CustomListener extends TestBase implements ITestListener {

	public void onStart(ITestContext context) {
		logger.info("Test suite started: " + context.getName() + "\nNumber of test methods in this suite: "
				+ context.getAllTestMethods().length);
		

	}

	public void onFinish(ITestContext context) {
		logger.info("Number of passed tests: " + context.getPassedTests().size());
		logger.info("Number of failed tests: " + context.getFailedTests().size());
		logger.info("Number of skipped tests: " + context.getSkippedTests().size());

	}

	public void onTestStart(ITestResult result) {
		logger.info("Test Starts : " + result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		logger.info("Test Passed : " + result.getMethod().getMethodName());
	}

	public void onTestFailure(ITestResult result) {
		logger.info("Test Failed !!!!! Taking Screenshot : " + result.getMethod().getMethodName());
		CommonUtils.takeFailedTestScreenShot(result.getMethod().getMethodName());
	}

	public void onTestSkipped(ITestResult result) {
		logger.info("Test Skipped : " + result.getMethod().getMethodName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

}