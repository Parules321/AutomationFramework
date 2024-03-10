package com.naveenAutomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenAutomation.testBase.TestBase;

public class ChangePasswordPage extends TestBase {

	public ChangePasswordPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "input-password")
	private WebElement passwordInputBox;

	@FindBy(id = "input-confirm")
	private WebElement passwordConfirmationInputBox;

	@FindBy(css = "[type ='submit']")
	private WebElement submitBtn;
	
	@FindBy(css = "div .text-danger")
	private WebElement mismatchedPasswordAlert;
	

	private void enterNewPassword(String newPassword) {
		passwordInputBox.sendKeys(newPassword);
	}

	private void confirmNewPassword(String newPassword) {
		passwordConfirmationInputBox.sendKeys(newPassword);
	}

	private void confirmWithMismatchedPassword(String mismatchedPassword) {
		passwordConfirmationInputBox.sendKeys(mismatchedPassword);
	}

	private void submitDetails() {
		submitBtn.submit();
	}
	
	public MyAccountPage updatePassword(String newPassword) {
		
		enterNewPassword(newPassword);
		confirmNewPassword(newPassword);
		submitDetails();
		return new MyAccountPage();
	}
	
	public ChangePasswordPage updatePasswordWithIncorrectConfirmation(String newPassword, String mismatchedPassword) {
		enterNewPassword(newPassword);
		confirmWithMismatchedPassword(mismatchedPassword);
		submitDetails();
		return new ChangePasswordPage();
	}
	
	public String getPasswordMismatchAlertText() {
		return mismatchedPasswordAlert.getText();
	};
	
	

}
