package com.naveenAutomation.listeners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.naveenAutomation.testBase.TestBase;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;

public class AllureReportListener extends TestBase implements ITestListener {

	public static File saveFailureScreenshot(String testCaseName) {
		File screenShotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		return screenShotFile;

	}

	@Attachment(value = "{0}", type = "text")
	public static String saveTextLog(String message) {
		return message;
	}

	public void onTestStart(ITestResult result) {
		System.out.println("Test Starts : " + result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Passed : " + result.getMethod().getConstructorOrMethod().getName());

	}

	public void onTestFailure(ITestResult result) {
		System.out.println(
				"Test Failed !!!!! Screenshot attached in Allure report " + result.getMethod().getMethodName());
		File screenshot = saveFailureScreenshot(result.getMethod().getMethodName());
		try {
			Allure.addAttachment(result.getMethod().getMethodName() + "Failure Screenshot",
					FileUtils.openInputStream(screenshot));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		saveTextLog("Screenshot of failed test");
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Skipped : " + result.getMethod().getMethodName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onStart(ITestContext context) {
		System.out.println("Before running all test methods" + context.getName());

	}

	public void onFinish(ITestContext context) {
		System.out.println("After running all test methods" + context.getName());

	}

}