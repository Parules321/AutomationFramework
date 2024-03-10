package com.naveenAutomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenAutomation.testBase.TestBase;

public class ContactUsSuccessPage extends TestBase {
	
	public ContactUsSuccessPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//p[contains(text(),'successfully sent')]")
	WebElement contactSubmissionConfirmationText;
	
	public String getContactSubmissionConfirmationText() {
		return contactSubmissionConfirmationText.getText();		
	}
	

}
