package com.naveenAutomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenAutomation.testBase.TestBase;

public class ContactUsPage extends TestBase {
	
	public ContactUsPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "input-name")
	WebElement nameInputField;
	
	@FindBy(id = "input-email")
	WebElement emailInputField;

	@FindBy(id = "input-enquiry")
	WebElement enquiryInputField;

	@FindBy(css = "[type ='submit']")
	WebElement submitBtn;
	
	@FindBy(css = ".text-danger")
	WebElement incompleteNameAlertTxt;
	
	@FindBy(css = ".text-danger")
	WebElement invalidEmailAlertTxt;
	
	@FindBy(css = ".text-danger")
	WebElement invalidEnquiryLengthAlertTxt;
	
	private void enterName(String name) {
		nameInputField.sendKeys(name);
	}
	
	private void enterEmail(String email) {
		emailInputField.sendKeys(email);
	}
	
	private void enterEnquiry(String enquiry) {
		enquiryInputField.sendKeys(enquiry);
	}

	private void clickSubmitBtn() {
		submitBtn.click();
	}

	public ContactUsSuccessPage submitContactDetails(String name, String email, String enquiry) {
		enterName(name);
		enterEmail(email);
		enterEnquiry(enquiry);
		clickSubmitBtn();
		return new ContactUsSuccessPage();
	}
	
	public ContactUsPage submitContactDetailsWithIncorrectEnquiryLength(String name, String email, String enquiryNotWithinCharsLength) {
		enterName(name);
		enterEmail(email);
		enterEnquiry(enquiryNotWithinCharsLength);
		clickSubmitBtn();
		return new ContactUsPage();
	}
	
	public ContactUsPage submitContactDetailsWithInvalidEmail(String name, String invalidEmail, String enquiry) {
		enterName(name);
		enterEmail(invalidEmail);
		enterEnquiry(enquiry);
		clickSubmitBtn();
		return new ContactUsPage();
	}
	
	public ContactUsPage submitContactDetailsWithIncompleteName(String email, String enquiry) {
		enterEmail(email);
		enterEnquiry(enquiry);
		clickSubmitBtn();
		return new ContactUsPage();
	}
	

public String getIncompleteNameAlertTxt() {return incompleteNameAlertTxt.getText();}


public String getInvalidEmailAlertTxt() {return invalidEmailAlertTxt.getText();}


public String getInvalidEnquiryLengthAlertTxt() 
{return invalidEnquiryLengthAlertTxt.getText();}

}
