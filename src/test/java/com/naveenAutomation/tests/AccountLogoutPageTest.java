package com.naveenAutomation.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenAutomation.pages.AccountLoginPage;
import com.naveenAutomation.pages.AccountLogoutPage;
import com.naveenAutomation.pages.MyAccountPage;
import com.naveenAutomation.testBase.TestBase;
import com.naveenAutomation.utilities.DataProviderUtils;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class AccountLogoutPageTest extends TestBase {
	AccountLoginPage loginPage;
	MyAccountPage accountPage;
	AccountLogoutPage logoutPage;

	@BeforeMethod
	public void launchBrowser() {
		intialization();
		loginPage = new AccountLoginPage();
	}

	@Severity(SeverityLevel.NORMAL)
	@Epic("Account Management")
	@Feature("Logout")
	@Test(dataProvider = "validLoginData", dataProviderClass = DataProviderUtils.class)
	public void validateSignOutFromMyAccountDropDwn(String email, String password) {
		accountPage = loginPage.submitCorrectLoginInfo(email, password);
		logoutPage = accountPage.clickMyAccountLogOutBtn();
		String logoutText = logoutPage.getLogoutMsgText();
		Assert.assertEquals("Account Logout", logoutText);
	}

	@Severity(SeverityLevel.NORMAL)
	@Epic("Account Management")
	@Feature("Logout")
	@Test(dataProvider = "validLoginData", dataProviderClass = DataProviderUtils.class)
	public void validateSignOutFromSideMenuBtn(String email, String password) {
		accountPage = loginPage.submitCorrectLoginInfo(email, password);
		logoutPage = accountPage.clickSideNavLogOutBtn();
		String logoutText = logoutPage.getLogoutMsgText();
		Assert.assertEquals("Account Logout", logoutText);
	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}
}
