package com.naveenAutomation.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenAutomation.pages.AccountLoginPage;
import com.naveenAutomation.pages.GiftCertificatePage;
import com.naveenAutomation.pages.GiftPurchaseConfirmationPage;
import com.naveenAutomation.testBase.TestBase;
import com.naveenAutomation.utilities.DataProviderUtils;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class GiftPurchaseConfirmationPageTest extends TestBase {

	AccountLoginPage loginPage;
	GiftCertificatePage giftCertificatePage;
	GiftPurchaseConfirmationPage purchaseConfirmationPage;

	@BeforeMethod
	public void launchBrowser() {
		intialization();
		loginPage = new AccountLoginPage();
	}

	@Severity(SeverityLevel.CRITICAL)
	@Epic("User Transactions")
	@Feature("Gift Certficate Purchase")
	@Test(dataProvider = "validGiftPurchaseData", dataProviderClass = DataProviderUtils.class)
	public void validateGiftCertificatePurchase(String recipientName, String recipientEmail, String senderName,
			String senderEmail, String message, String amount) {
		giftCertificatePage = loginPage.clickGiftPurchaseBtn();
		purchaseConfirmationPage = giftCertificatePage.completeGiftCertificatePurchase(recipientName, recipientEmail,
				senderName, senderEmail, message, amount);
		String giftPurchaseConfirmationText = purchaseConfirmationPage.getPurchaseConfirmationText();
		Assert.assertEquals(giftPurchaseConfirmationText,
				"Thank you for purchasing a gift certificate! Once you have completed your order your gift certificate recipient will be sent an e-mail with details how to redeem their gift certificate.");
	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}
}
