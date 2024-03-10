package com.naveenAutomation.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenAutomation.pages.AccountLoginPage;
import com.naveenAutomation.pages.AddAddressPage;
import com.naveenAutomation.pages.AddressBookPage;
import com.naveenAutomation.pages.MyAccountPage;
import com.naveenAutomation.testBase.TestBase;
import com.naveenAutomation.utilities.DataProviderUtils;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class AddAddressPageTest extends TestBase {
	AccountLoginPage loginPage;
	MyAccountPage accountPage;
	AddressBookPage addressBookPage;
	AddAddressPage addAddressPage;

	@BeforeMethod
	public void launchBrowser() {
		intialization();
		loginPage = new AccountLoginPage();
	}

	@Severity(SeverityLevel.NORMAL)
	@Epic("Account Management")
	@Feature("Address Update")
	@Test(dataProvider = "incompleteAddressData", dataProviderClass = DataProviderUtils.class)
	public void validateSubmitIncompleteAddress(String username, String password, String firstName, String lastName,
			String city, String postalCode, String country, String zone, String countryValue, String zoneValue) {
		accountPage = loginPage.submitCorrectLoginInfo(username, password);
		addressBookPage = accountPage.clickAddressBookBtn();
		addAddressPage = addressBookPage.clickAddNewAddressBtn();
		addAddressPage = addAddressPage.submitIncompleteAddress(firstName, lastName, city, postalCode, country, zone,
				countryValue, zoneValue);
		String incompleteAddressAlertText = addAddressPage.getIncompleteAddressAlertText();
		Assert.assertEquals(incompleteAddressAlertText, "Address must be between 3 and 128 characters!");

	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}

}
