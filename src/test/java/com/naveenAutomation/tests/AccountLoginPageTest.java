package com.naveenAutomation.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenAutomation.pages.AccountLoginPage;
import com.naveenAutomation.pages.MyAccountPage;
import com.naveenAutomation.testBase.TestBase;
import com.naveenAutomation.utilities.DataProviderUtils;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class AccountLoginPageTest extends TestBase {

	AccountLoginPage loginPage;
	MyAccountPage accountPage;

	@BeforeMethod
	public void launchBrowser() {
		intialization();
		loginPage = new AccountLoginPage();
	}

	@Severity(SeverityLevel.MINOR)
	@Epic("Account Management")
	@Feature("Login")
	@Test(dataProvider = "invalidUsernameData", dataProviderClass = DataProviderUtils.class)
	public void validateLoginWithIncorrectUsername(String username, String password) {
		loginPage.submitIncorrectUsername(username, password);
		String incorrectUsernameMessage = loginPage.getIncorrectUsernameMsgText();
		Assert.assertEquals("Warning: No match for E-Mail Address and/or Password.", incorrectUsernameMessage);
	}

	@Severity(SeverityLevel.MINOR)
	@Epic("Account Management")
	@Feature("Login")
	@Test(dataProvider = "invalidPasswordData", dataProviderClass = DataProviderUtils.class)
	public void validateLoginWithIncorrectPassword(String username, String password) {
		loginPage.submitIncorrectPassword(username, password);
		String incorrectPasswordMessage = loginPage.getIncorrectPswdMsgText();
		Assert.assertEquals("Warning: No match for E-Mail Address and/or Password.", incorrectPasswordMessage);
	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}

}
