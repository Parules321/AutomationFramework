package com.naveenAutomation.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenAutomation.pages.AccountLoginPage;
import com.naveenAutomation.pages.ReturnPage;
import com.naveenAutomation.testBase.TestBase;
import com.naveenAutomation.utilities.DataProviderUtils;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class ReturnPageTest extends TestBase {
	AccountLoginPage loginPage;
	ReturnPage returnPage;

	@BeforeMethod
	public void launchBrowser() {
		intialization();
		loginPage = new AccountLoginPage();
	}

	@Severity(SeverityLevel.NORMAL)
	@Epic("Product Management")
	@Feature("Product Return")
	@Test(dataProvider = "returnRequestDataWithInvalidEmail", dataProviderClass = DataProviderUtils.class)
	public void validateReturnRequestWithInvalidEmail(String firstName, String lastName, String invalidEmail,
			String phone, String orderId, String expectedMonthWithYear, String expectedDate, String productName,
			String productCode) {
		returnPage = loginPage.clickProductReturnsBtn();
		returnPage = returnPage.submitReturnRequestWithInvalidEmail(firstName, lastName, invalidEmail, phone, orderId,
				expectedMonthWithYear, expectedDate, productName, productCode);
		String invalidEmailAlertText = returnPage.getInvalidEmailAlertText();
		Assert.assertEquals(invalidEmailAlertText, "E-Mail Address does not appear to be valid!");

	}

	@Severity(SeverityLevel.NORMAL)
	@Epic("Product Management")
	@Feature("Product Return")
	@Test(dataProvider = "returnRequestDataWithoutOrderId", dataProviderClass = DataProviderUtils.class)
	public void validateReturnRequestWithMissingOrderId(String firstName, String lastName, String email, String phone,
			String expectedMonthWithYear, String expectedDate, String productName, String productCode) {
		returnPage = loginPage.clickProductReturnsBtn();
		returnPage = returnPage.submitReturnRequestWithMissingOrderId(firstName, lastName, email, phone,
				expectedMonthWithYear, expectedDate, productName, productCode);
		String missingOrderIdAlertText = returnPage.getMissingOrderIdAlertText();
		Assert.assertEquals(missingOrderIdAlertText, "Order ID required!");

	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}

}
