package com.naveenAutomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenAutomation.testBase.TestBase;

public class GiftPurchaseConfirmationPage extends TestBase {
	
	public GiftPurchaseConfirmationPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//p[contains(text(),'Thank you')]")
	WebElement giftPurchaseConfirmationText;
	
	public String getPurchaseConfirmationText() {
		return giftPurchaseConfirmationText.getText();
		
	}

}
