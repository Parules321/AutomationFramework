package com.naveenAutomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenAutomation.testBase.TestBase;

public class GiftCertificatePage extends TestBase {
	
	public GiftCertificatePage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id ="input-to-name")
	WebElement recipientNameInputField;
	
	@FindBy(id ="input-to-email")
	WebElement recipientEmailField;
	
	@FindBy(css ="div #input-from-name")
	WebElement nameInputField;
	
	@FindBy(css = "div #input-from-email")
	WebElement emailInputField;
	
	@FindBy(css = ".radio label [value='8']")
	WebElement giftThemeRadioBtn;
	
	@FindBy(id = "input-message")
	WebElement giftMsgInputField;
	
	@FindBy(id = "input-amount")
	WebElement amountInputField;
	
	@FindBy(css = "[type='checkbox']")
	WebElement agreeCheckBtn;
	
	@FindBy(css = "[type = 'submit']")
	WebElement continueBtn;
	
	@FindBy(css = "div.text-danger")
	WebElement invalidRecipientEmailAlertText;
	
	@FindBy(css = "div.text-danger")
	WebElement incompleteAmountAlertText;
	
	
	private void enterRecipientName(String recipientName) {
		recipientNameInputField.sendKeys(recipientName);
	}
	
	private void enterRecipientEmail(String recipientEmail) {
		recipientEmailField.sendKeys(recipientEmail);
	}
	
	private void enterSenderName(String senderName) {
		nameInputField.sendKeys(senderName);
	}
	
	private void enterSenderEmail(String senderEmail) {
		emailInputField.sendKeys(senderEmail);
	}
	
	private void chooseGiftTheme() {
		giftThemeRadioBtn.click();
	}
	
	private void enterGiftMessage(String message) {
		giftMsgInputField.sendKeys(message);
	}
	
	private void enterGiftAmount(String amount) {
		amountInputField.sendKeys(amount);
	}
	
	private void clearAmount() {
		amountInputField.clear();
	}
	
	private void clickAgreeCheckBox() {
		agreeCheckBtn.click();	
	}
	
	private void clickSubmitBtn() {continueBtn.submit();}
	
	public GiftPurchaseConfirmationPage completeGiftCertificatePurchase(String recipientName, String recipientEmail, String senderName, String senderEmail,String message, String amount ) 
	{enterRecipientName(recipientName);
	enterRecipientEmail(recipientEmail);
	enterSenderName(senderName);
	enterSenderEmail(senderEmail);
	chooseGiftTheme();
	enterGiftMessage(message);
	clearAmount();
	enterGiftAmount(amount);
	clickAgreeCheckBox();
	clickSubmitBtn();
	return new GiftPurchaseConfirmationPage();
	}
	
	public GiftCertificatePage giftCertificatePurchaseWithInvalidRecipientEmail(String recipientName, String invalidRecipientEmail, String senderName, String senderEmail,String message, String amount) 
	{enterRecipientName(recipientName);
	enterRecipientEmail(invalidRecipientEmail);
	enterSenderName(senderName);
	enterSenderEmail(senderEmail);
	chooseGiftTheme();
	enterGiftMessage(message);
	enterGiftAmount(amount);
	clickAgreeCheckBox();
	clickSubmitBtn();
	return new GiftCertificatePage();
	}
	
	public GiftCertificatePage giftCertificatePurchaseWithMissingAmount(String recipientName, String recipientEmail, String senderName, String senderEmail,String message) 
	{enterRecipientName(recipientName);
	enterRecipientEmail(recipientEmail);
	enterSenderName(senderName);
	enterSenderEmail(senderEmail);
	chooseGiftTheme();
	enterGiftMessage(message);
	clearAmount();
	clickAgreeCheckBox();
	clickSubmitBtn();
	return new GiftCertificatePage();
	}
	
	public String getIncompleteAmountAlertText() {
		return incompleteAmountAlertText.getText();	
	}
	
	public String getInvalidRecipientEmailAlertText() {
		return invalidRecipientEmailAlertText.getText();	
	}

}
