package com.naveenAutomation.listeners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.naveenAutomation.utilities.CommonUtils;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;

public class AllureReportListener extends TestListenerAdapter

{

	@Attachment(value = "{0}", type = "text")
	public void saveTextLog(String message) {

	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(
				"Test Failed !!!!! Screenshot attached in Allure report " + result.getMethod().getMethodName());
		File screenshot = CommonUtils.takeFailedTestScreenShot(result.getMethod().getMethodName());
		try {
			Allure.addAttachment(result.getMethod().getMethodName() + "Failure Screenshot",
					FileUtils.openInputStream(screenshot));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		saveTextLog("Screenshot of failed test");
	}

}