package com.naveenAutomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenAutomation.testBase.TestBase;


public class AddressBookPage extends TestBase{
	
	public AddressBookPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".btn-primary")
	private WebElement addNewAddressBtn;
	
	@FindBy(css = "div.alert")
	WebElement addressUpdateAlertText;

	
	public AddAddressPage clickAddNewAddressBtn() {	
		addNewAddressBtn.click();	
		return new AddAddressPage();
	}

	public String getAddressUpdateAlertText() {
		return addressUpdateAlertText.getText();
	}
}


