package com.naveenAutomation.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenAutomation.pages.AccountLoginPage;
import com.naveenAutomation.pages.ContactUsPage;
import com.naveenAutomation.testBase.TestBase;
import com.naveenAutomation.utilities.DataProviderUtils;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class ContactUsPageTest extends TestBase {

	AccountLoginPage loginPage;
	ContactUsPage contactPage;

	@BeforeMethod
	public void launchBrowser() {
		intialization();
		loginPage = new AccountLoginPage();
	}

	@Severity(SeverityLevel.NORMAL)
	@Epic("Customer Support")
	@Feature("Contact Us Form")
	@Test(dataProvider = "contactDataWithInvalidEmail", dataProviderClass = DataProviderUtils.class)
	public void validateContactUsWithInvalidEmail(String name, String invalidEmail, String enquiry) {
		contactPage = loginPage.clickContactBtn();
		contactPage = contactPage.submitContactDetailsWithInvalidEmail(name, invalidEmail, enquiry);
		String invalidEmailAlertTxt = contactPage.getInvalidEmailAlertTxt();
		Assert.assertEquals(invalidEmailAlertTxt, "E-Mail Address does not appear to be valid!");
	}

	@Severity(SeverityLevel.NORMAL)
	@Epic("Customer Support")
	@Feature("Contact Us Form")
	@Test(dataProvider = "contactDataWithoutName", dataProviderClass = DataProviderUtils.class)
	public void validateContactUsWithIncompleteName(String email, String enquiry) {
		contactPage = loginPage.clickContactBtn();
		contactPage = contactPage.submitContactDetailsWithIncompleteName(email, enquiry);
		String incompleteNameAlertTxt = contactPage.getIncompleteNameAlertTxt();
		Assert.assertEquals(incompleteNameAlertTxt, "Name must be between 3 and 32 characters!");
	}

	@Severity(SeverityLevel.NORMAL)
	@Epic("Customer Support")
	@Feature("Contact Us Form")
	@Test(dataProvider = "contactDataWithInvalidEnquiryLength", dataProviderClass = DataProviderUtils.class)
	public void validateContactUsWithInvalidEnquiryLength(String name, String email,
			String enquiryNotWithinCharsLength) {
		contactPage = loginPage.clickContactBtn();
		contactPage = contactPage.submitContactDetailsWithIncorrectEnquiryLength(name, email,
				enquiryNotWithinCharsLength);
		String invalidEnquiryLengthAlertTxt = contactPage.getInvalidEnquiryLengthAlertTxt();
		Assert.assertEquals(invalidEnquiryLengthAlertTxt, "Enquiry must be between 10 and 3000 characters!");

	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}

}
