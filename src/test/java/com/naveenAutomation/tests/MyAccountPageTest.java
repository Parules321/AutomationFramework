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

public class MyAccountPageTest extends TestBase {

	AccountLoginPage loginPage;
	MyAccountPage accountPage;
	MyAccountInformationPage accountInfoPage;
	ChangePasswordPage changePswdPage;

	@BeforeMethod
	public void launchBrowser() {
		intialization();
		loginPage = new AccountLoginPage();
	}

	@Severity(SeverityLevel.BLOCKER)
	@Epic("Account Management")
	@Feature("Login")
	@Test(dataProvider = "validLoginData", dataProviderClass = DataProviderUtils.class)
	public void validateLogin(String username, String password) {
		accountPage = loginPage.submitCorrectLoginInfo(username, password);
		String myAccountText = accountPage.getMyAccountText();
		Assert.assertEquals(myAccountText, "My Account1");
	}

	@Severity(SeverityLevel.NORMAL)
	@Epic("Account Management")
	@Feature("Account Related Information Update")
	@Test(dataProvider = "editAccountInfoData", dataProviderClass = DataProviderUtils.class)
	public void validateEditAccountInfo(String username, String password, String firstName, String lastName,
			String phoneNum) {
		accountPage = loginPage.submitCorrectLoginInfo(username, password);
		accountInfoPage = accountPage.clickEditAccountBtn();
		accountPage = accountInfoPage.editAccountInfo(firstName, lastName, phoneNum);
		String accountUpdateAlertText = accountPage.getAccountUpdateAlertText();
		Assert.assertEquals(accountUpdateAlertText, "Success: Your account has been successfully updated.");
	}

	@Severity(SeverityLevel.NORMAL)
	@Epic("Account Management")
	@Feature("Password Update")
	@Test(dataProvider = "validPasswordUpdateData", dataProviderClass = DataProviderUtils.class)
	public void validateUpdatePassword(String username, String password, String newPassword) {
		accountPage = loginPage.submitCorrectLoginInfo(username, password);
		changePswdPage = accountPage.clickUpdatePasswordBtn();
		changePswdPage.updatePassword(newPassword);
		String passwordUpdateAlertText = accountPage.getPasswordUpdateAlertText();
		Assert.assertEquals(passwordUpdateAlertText, "Success: Your password has been successfully updated.");

	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}

}
