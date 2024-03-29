package com.naveenAutomation.listeners;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.naveenAutomation.dateFormats.DateFormat;

public class ExtentReportListener extends TestListenerAdapter {

	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;

	@Override
	public void onStart(ITestContext testContext) {
		// Generate TimeStamp
		String timeStamp = new SimpleDateFormat(DateFormat.LONG_DATE.getFormat()).format(new Date());
		// Name of the report
		String repName = "Report_" + timeStamp + ".html";
		// Save the report

		htmlReporter = new ExtentHtmlReporter("./Reports\\" + repName);

		htmlReporter.config().setDocumentTitle("QA Report");
		htmlReporter.config().setReportName(repName);
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setProtocol(Protocol.HTTPS);
		htmlReporter.config().setTimeStampFormat(timeStamp);
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		//htmlReporter.flush();

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter); // attach extent to htmlrepoter becuase extend builds html reprort

		// extent report configurations
		extent.setSystemInfo("Name of tester: ", "Parul");
		extent.setSystemInfo("Environment", "Testing");
		extent.setSystemInfo("Website", "https://naveenautomationlabs.com");

	}

	@Override
	public void onTestSuccess(ITestResult tr) {
		test = extent.createTest(tr.getMethod().getMethodName());
		test.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
	}

	@Override
	public void onTestFailure(ITestResult tr) {

		test = extent.createTest(tr.getMethod().getMethodName());
		test.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));

	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		test = extent.createTest(tr.getMethod().getMethodName());
		test.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));

	}

	@Override
	public void onFinish(ITestContext testContext) {
		extent.flush();
	}
}
