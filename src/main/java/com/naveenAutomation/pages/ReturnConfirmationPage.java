package com.naveenAutomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenAutomation.testBase.TestBase;

public class ReturnConfirmationPage extends TestBase {

	public ReturnConfirmationPage() {
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//p[contains(text(), 'Thank you for submitting')]")
	WebElement returnConfirmationText;

	public String getReturnConfirmationText() {
		return returnConfirmationText.getText();

	}

}
