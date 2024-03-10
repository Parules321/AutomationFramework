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

public class AddressBookPageTest extends TestBase {

	AccountLoginPage loginPage;
	MyAccountPage accountPage;
	AddressBookPage addressBookPage;
	AddAddressPage addAddressPage;

	@BeforeMethod
	public void launchBrowser() {
		intialization();
		loginPage = new AccountLoginPage();
	}

	@Severity(SeverityLevel.CRITICAL)
	@Epic("Account Management")
	@Feature("Address Update")
	@Test(dataProvider = "validAddressData", dataProviderClass = DataProviderUtils.class)
	public void validateSubmitAddress(String username, String password, String firstName, String lastName, String city,
			String address, String postalCode, String country, String zone, String countryValue, String zoneValue) {
		accountPage = loginPage.submitCorrectLoginInfo(username, password);
		addressBookPage = accountPage.clickAddressBookBtn();
		addAddressPage = addressBookPage.clickAddNewAddressBtn();
		addressBookPage = addAddressPage.submitAddress(firstName, lastName, city, address, postalCode, country, zone,
				countryValue, zoneValue);
		String addressUpdateAlertText = addressBookPage.getAddressUpdateAlertText();
		Assert.assertEquals(addressUpdateAlertText, "Your address has been successfully added");

	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}
}
