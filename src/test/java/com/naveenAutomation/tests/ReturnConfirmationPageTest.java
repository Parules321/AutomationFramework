package com.naveenAutomation.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenAutomation.pages.AccountLoginPage;
import com.naveenAutomation.pages.ReturnConfirmationPage;
import com.naveenAutomation.pages.ReturnPage;
import com.naveenAutomation.testBase.TestBase;
import com.naveenAutomation.utilities.DataProviderUtils;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class ReturnConfirmationPageTest extends TestBase {
	AccountLoginPage loginPage;
	ReturnPage returnPage;
	ReturnConfirmationPage confirmationPage;

	@BeforeMethod
	public void launchBrowser() {
		intialization();
		loginPage = new AccountLoginPage();
	}

	@Severity(SeverityLevel.CRITICAL)
	@Epic("Product Management")
	@Feature("Product Return")
	@Test(dataProvider = "validReturnData", dataProviderClass = DataProviderUtils.class)
	public void validateSubmitReturnRequest(String firstName, String lastName, String email, String phone,
			String orderId, String expectedMonthWithYear, String expectedDate, String productName, String productCode) {
		returnPage = loginPage.clickProductReturnsBtn();
		confirmationPage = returnPage.submitReturnRequest(firstName, lastName, email, phone, orderId,
				expectedMonthWithYear, expectedDate, productName, productCode);
		String returnConfirmationText = confirmationPage.getReturnConfirmationText();
		Assert.assertEquals(returnConfirmationText,
				"Thank you for submitting your return request. Your request has been sent to the relevant department for processing.");

	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}

}