package com.naveenAutomation.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenAutomation.testBase.TestBase;

public class MyAccountInformationPage extends TestBase {

	public MyAccountInformationPage() {
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "input-firstname")
	private WebElement firstNameInputBox;

	@FindBy(id = "input-lastname")
	private WebElement lastNameInputBox;

	@FindBy(id = "input-email")
	private WebElement emailInputBox;

	@FindBy(id = "input-telephone")
	private WebElement phoneInputBox;

	@FindBy(css = "[type ='submit']")
	private WebElement submitBtn;

	@FindBy(css = "div.text-danger")
	private WebElement invalidEmailAlert;

	@FindBy(css = "div.text-danger")
	private WebElement missingPhoneNumAlert;

	private void editFirstName(String newFirstName) {
		firstNameInputBox.clear();
		firstNameInputBox.sendKeys(newFirstName);
	}

	private void editLastName(String newLastName) {
		lastNameInputBox.clear();
		lastNameInputBox.sendKeys(newLastName);
	}

	private void editPhoneNum(String newPhoneNum) {
		phoneInputBox.clear();
		phoneInputBox.sendKeys(newPhoneNum);
	}

	private void updateInvalidEmail(String invalidEmail) {
		emailInputBox.clear();
		emailInputBox.sendKeys(invalidEmail);

	}

	private void clearPhoneNum() {
		phoneInputBox.clear();
	}

	private void clickSubmitBtn() {
		submitBtn.submit();
	}

	public MyAccountPage editAccountInfo(String newFirstName, String newLastName, String newPhoneNum) {
		editFirstName(newFirstName);
		editLastName(newLastName);
		editPhoneNum(newPhoneNum);
		clickSubmitBtn();
		return new MyAccountPage();
	}

	public MyAccountInformationPage updateAccountInfoWithInvalidEmail(String newFirstName, String newLastName,
			String invalidEmail, String newPhoneNum) {
		editFirstName(newFirstName);
		editLastName(newLastName);
		updateInvalidEmail(invalidEmail);
		editPhoneNum(newPhoneNum);
		clickSubmitBtn();
		return new MyAccountInformationPage();
	}
	
	public MyAccountInformationPage editAccountInfoWithMissingPhoneNum(String newFirstName, String newLastName) {
		editFirstName(newFirstName);
		editLastName(newLastName);
		clearPhoneNum();
		clickSubmitBtn();
		return new MyAccountInformationPage();
	}

	public String getinvalidEmailAlertText() {
		return invalidEmailAlert.getText();
	}

	public String getmissingPhoneNumAlertText() {
		return missingPhoneNumAlert.getText();
	}

}
