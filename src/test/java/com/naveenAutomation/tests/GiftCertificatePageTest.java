package com.naveenAutomation.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenAutomation.pages.AccountLoginPage;
import com.naveenAutomation.pages.GiftCertificatePage;
import com.naveenAutomation.testBase.TestBase;
import com.naveenAutomation.utilities.DataProviderUtils;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class GiftCertificatePageTest extends TestBase {
	AccountLoginPage loginPage;
	GiftCertificatePage giftCertificatePage;

	@BeforeMethod
	public void launchBrowser() {
		intialization();
		loginPage = new AccountLoginPage();
	}

	@Severity(SeverityLevel.NORMAL)
	@Epic("User Transactions")
	@Feature("Gift Certficate Purchase")
	@Test(dataProvider = "giftPurchaseDataWithWrongToEmail", dataProviderClass = DataProviderUtils.class)
	public void validateGiftPurchaseWithInvalidRecipientEmail(String recipientName, String invalidRecipientEmail,
			String senderName, String senderEmail, String message, String amount) {
		giftCertificatePage = loginPage.clickGiftPurchaseBtn();
		giftCertificatePage = giftCertificatePage.giftCertificatePurchaseWithInvalidRecipientEmail(recipientName,
				invalidRecipientEmail, senderName, senderEmail, message, amount);
		String invalidRecipientEmailAlertText = giftCertificatePage.getInvalidRecipientEmailAlertText();
		Assert.assertEquals(invalidRecipientEmailAlertText, "E-Mail Address does not appear to be valid!");
	}

	@Severity(SeverityLevel.NORMAL)
	@Epic("User Transactions")
	@Feature("Gift Certficate Purchase")
	@Test(dataProvider = "giftPurchaseDataWithMissingAmount", dataProviderClass = DataProviderUtils.class)
	public void validateGiftPurchaseWithIncompleteAmount(String recipientName, String recipientEmail, String senderName,
			String senderEmail, String message) {
		giftCertificatePage = loginPage.clickGiftPurchaseBtn();
		giftCertificatePage = giftCertificatePage.giftCertificatePurchaseWithMissingAmount(recipientName,
				recipientEmail, senderName, senderEmail, message);
		String incompleteAmountAlertText = giftCertificatePage.getIncompleteAmountAlertText();
		Assert.assertEquals(incompleteAmountAlertText, "Amount must be between $1.00 and $1,000.00!");
	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}
}
