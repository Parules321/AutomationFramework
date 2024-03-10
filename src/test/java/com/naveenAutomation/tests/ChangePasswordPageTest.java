package com.naveenAutomation.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenAutomation.pages.AccountLoginPage;
import com.naveenAutomation.pages.ChangePasswordPage;
import com.naveenAutomation.pages.MyAccountInformationPage;
import com.naveenAutomation.pages.MyAccountPage;
import com.naveenAutomation.testBase.TestBase;
import com.naveenAutomation.utilities.DataProviderUtils;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class ChangePasswordPageTest extends TestBase {

	AccountLoginPage loginPage;
	MyAccountPage accountPage;
	MyAccountInformationPage accountInfoPage;
	ChangePasswordPage changePswdPage;

	@BeforeMethod
	public void launchBrowser() {
		intialization();
		loginPage = new AccountLoginPage();
	}

	@Severity(SeverityLevel.NORMAL)
	@Epic("Account Management")
	@Feature("Account Related Information Update")
	@Test(dataProvider = "updatePasswordWithMismatchedConfirmationData", dataProviderClass = DataProviderUtils.class)
	public void validateUpdatePasswordWithMismatchedConfirmation(String username, String password, String newPassword,
			String mismatchedPassword) {
		accountPage = loginPage.submitCorrectLoginInfo(username, password);
		changePswdPage = accountPage.clickUpdatePasswordBtn();
		changePswdPage.updatePasswordWithIncorrectConfirmation(newPassword, mismatchedPassword);
		String mismatchedPasswordAlertText = changePswdPage.getPasswordMismatchAlertText();
		Assert.assertEquals(mismatchedPasswordAlertText, "Password confirmation does not match password!");

	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}
}
