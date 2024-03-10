package com.naveenAutomation.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenAutomation.pages.AccountLoginPage;
import com.naveenAutomation.pages.ContactUsPage;
import com.naveenAutomation.pages.ContactUsSuccessPage;
import com.naveenAutomation.testBase.TestBase;
import com.naveenAutomation.utilities.DataProviderUtils;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class ContactUsSuccessPageTest extends TestBase {

	AccountLoginPage loginPage;
	ContactUsPage contactPage;
	ContactUsSuccessPage confirmationPage;

	@BeforeMethod
	public void launchBrowser() {
		intialization();
		loginPage = new AccountLoginPage();
	}

	@Severity(SeverityLevel.CRITICAL)
	@Epic("Customer Support")
	@Feature("Contact Us Form")
	@Test(dataProvider = "validContactUsData", dataProviderClass = DataProviderUtils.class)
	public void validateContactUsSubmission(String name, String Email, String enquiry) {
		contactPage = loginPage.clickContactBtn();
		confirmationPage = contactPage.submitContactDetails(name, Email, enquiry);
		String submissionConfirmationTxt = confirmationPage.getContactSubmissionConfirmationText();
		Assert.assertEquals(submissionConfirmationTxt, "Your enquiry has been successfully sent to the store owner!");
	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}

}
