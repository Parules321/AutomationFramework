package com.naveenAutomation.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenAutomation.pages.AccountLoginPage;
import com.naveenAutomation.pages.MyAccountInformationPage;
import com.naveenAutomation.pages.MyAccountPage;
import com.naveenAutomation.testBase.TestBase;
import com.naveenAutomation.utilities.DataProviderUtils;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class MyAccountInformationPageTest extends TestBase {

	AccountLoginPage loginPage;
	MyAccountPage accountPage;
	MyAccountInformationPage accountInfoPage;

	@BeforeMethod
	public void launchBrowser() {
		intialization();
		loginPage = new AccountLoginPage();
	}

	@Severity(SeverityLevel.NORMAL)
	@Epic("Account Management")
	@Feature("Account Related Information Update")
	@Test(dataProvider = "updateAccountInfoWithInvalidEmailData", dataProviderClass = DataProviderUtils.class)
	public void validateUpdateAccountInfoWithInvalidEmail(String username, String password, String firstName,
			String lastName, String invalidEmail, String phoneNum) {
		accountPage = loginPage.submitCorrectLoginInfo(username, password);
		accountInfoPage = accountPage.clickEditAccountBtn();
		accountInfoPage = accountInfoPage.updateAccountInfoWithInvalidEmail(firstName, lastName, invalidEmail,
				phoneNum);
		String invalidEmailAlertText = accountInfoPage.getinvalidEmailAlertText();
		Assert.assertEquals(invalidEmailAlertText, "E-Mail Address does not appear to be valid!");
	}

	@Severity(SeverityLevel.NORMAL)
	@Epic("Account Management")
	@Feature("Account Related Information Update")
	@Test(dataProvider = "updateAccountInfoWithMissingPhoneNumData", dataProviderClass = DataProviderUtils.class)
	public void validateUpdateAccountInfoWithMissingPhoneNum(String username, String password, String firstName,
			String lastName) {
		accountPage = loginPage.submitCorrectLoginInfo(username, password);
		accountInfoPage = accountPage.clickEditAccountBtn();
		accountInfoPage = accountInfoPage.editAccountInfoWithMissingPhoneNum(firstName, lastName);
		String missingPhoneNumText = accountInfoPage.getmissingPhoneNumAlertText();
		Assert.assertEquals(missingPhoneNumText, "Telephone must be between 3 and 32 characters!");
	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}

}
