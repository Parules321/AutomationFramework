package com.naveenAutomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenAutomation.testBase.TestBase;
import com.naveenAutomation.utilities.CommonUtils;
import com.naveenAutomation.utilities.ExplicitWaitUtil;

public class AddAddressPage extends TestBase {

	public AddAddressPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "input-firstname")
	WebElement firstNameInputBox;

	@FindBy(id = "input-lastname")
	WebElement lastNameInputBox;

	@FindBy(id = "input-address-1")
	WebElement addressInputBox;

	@FindBy(id = "input-city")
	WebElement cityInputBox;

	@FindBy(id = "input-postcode")
	WebElement postCodeInputBox;

	@FindBy(id = "input-country")
	WebElement countryInputBox;

	@FindBy(id = "input-zone")
	WebElement regionInputBox;

	@FindBy(css = ".btn-primary")
	WebElement continueBtn;

	@FindBy(css = "div.text-danger")
	WebElement incompleteAddressAlertText;

	private void enterFirstName(String firstName) {
		firstNameInputBox.sendKeys(firstName);
	}

	private void enterLastName(String lastName) {
		lastNameInputBox.sendKeys(lastName);
	}

	private void enterAddress(String address) {
		addressInputBox.sendKeys(address);
	}

	private void enterCity(String city) {
		cityInputBox.sendKeys(city);
	}

	private void enterPostCode(String postCode) {
		postCodeInputBox.sendKeys(postCode);
	}

	private void selectCountry(String country, String value) {
		CommonUtils.selectElement(countryInputBox, country, value);
		ExplicitWaitUtil.waitForTextToBePresentInElement(countryInputBox, country);
	}

	private void enterRegion(String region, String value) {
		ExplicitWaitUtil.waitForPresenceofNestedElement(By.id("input-zone"), By.xpath("//select//option[text()='Ontario']"));
		CommonUtils.selectElement(regionInputBox, region, value);
	}

	public AddressBookPage submitAddress(String firstName, String lastName, String city, String address,
			String postalCode, String country, String zone, String countryValue, String zoneValue) {
		enterFirstName(firstName);
		enterLastName(lastName);
		enterCity(city);
		enterAddress(address);
		enterPostCode(postalCode);
		selectCountry(country, countryValue);
		enterRegion(zone, zoneValue);
		continueBtn.click();
		return new AddressBookPage();
	}

	public AddAddressPage submitIncompleteAddress(String firstName, String lastName, String city, String postalCode,
			String country, String zone, String countryValue, String zoneValue) {
		enterFirstName(firstName);
		enterLastName(lastName);
		enterCity(city);
		enterPostCode(postalCode);
		selectCountry(country, countryValue);
		enterRegion(zone, zoneValue);
		continueBtn.click();
		return new AddAddressPage();
	}

	public String getIncompleteAddressAlertText() {
		return incompleteAddressAlertText.getText();
	}
}
