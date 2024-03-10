package com.naveenAutomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenAutomation.testBase.TestBase;
import com.naveenAutomation.utilities.ExplicitWaitUtil;

public class OrderConfirmationPage extends TestBase {
	
	public OrderConfirmationPage() {
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(css ="#common-success #content h1")
	WebElement orderConfirmationText;
	
	public String getOrderConfirmationText() {
		orderConfirmationText = ExplicitWaitUtil.waitForVisibilityOfElement(By.cssSelector("#common-success #content h1"));
		return orderConfirmationText.getText();
	}

}
