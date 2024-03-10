package com.naveenAutomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenAutomation.testBase.TestBase;

import io.qameta.allure.Step;

public class AccountLoginPage extends TestBase {
	public AccountLoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "input-email")
	private WebElement loginInput;

	@FindBy(id = "input-password")
	private WebElement pwdInput;

	@FindBy(css = "#content div>div form>input")
	private WebElement loginBtn;

	@FindBy(css = "#account-login li:nth-of-type(3) a")
	private WebElement loginText;

	@FindBy(xpath = "//div[contains(text(),'Warning')]")
	private WebElement incorrectUserNameMsgText;

	@FindBy(xpath = "//div[contains(text(),'Warning')]")
	private WebElement incorrectPswdMsgText;

	@FindBy(xpath = "//a[text()='Gift Certificates']")
	WebElement giftCertificatePurchaseBtn;

	@FindBy(xpath = "//li//a[text()='Returns']")
	WebElement returnsBtn;

	@FindBy(xpath = "//a[text()='Contact Us']")
	WebElement contactUsBtn;

	private void enterEmail(String email) {
		loginInput.sendKeys(email);
	}
	
	
	private void enterPwd(String pwd) {
		pwdInput.sendKeys(pwd);
	}

	 
	private void clickLoginBtn() {
		loginBtn.click();
	}

	public MyAccountPage submitCorrectLoginInfo(String email, String pwd) {
		enterEmail(email);
		enterPwd(pwd);
		clickLoginBtn();
		return new MyAccountPage();
	}

	public AccountLoginPage submitIncorrectUsername(String invalidEmail, String pwd) {
		enterEmail(invalidEmail);
		enterPwd(pwd);
		clickLoginBtn();
		return new AccountLoginPage();
	}

	public AccountLoginPage submitIncorrectPassword(String email, String invalidPwd) {
		enterEmail(email);
		enterPwd(invalidPwd);
		clickLoginBtn();
		return new AccountLoginPage();
	}

	public String getIncorrectUsernameMsgText() {
		return incorrectUserNameMsgText.getText();
	}

	public String getIncorrectPswdMsgText() {
		return incorrectPswdMsgText.getText();
	}

	public GiftCertificatePage clickGiftPurchaseBtn() {
		giftCertificatePurchaseBtn.click();
		return new GiftCertificatePage();
	}

	public ReturnPage clickProductReturnsBtn() {
		returnsBtn.click();
		return new ReturnPage();
	}

	public ContactUsPage clickContactBtn() {
		contactUsBtn.click();
		return new ContactUsPage();

	}

}
