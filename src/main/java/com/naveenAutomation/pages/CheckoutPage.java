package com.naveenAutomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.naveenAutomation.testBase.TestBase;
import com.naveenAutomation.utilities.ExplicitWaitUtil;
import com.naveenAutomation.utilities.CommonUtils;

public class CheckoutPage extends TestBase {

	public CheckoutPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "label [name*='payment'][value='new']")
	private WebElement newAddressRadioBtn;

	@FindBy(id = "input-payment-firstname")
	private WebElement firstNameInputBox;

	@FindBy(id = "input-payment-lastname")
	private WebElement lastNameInputBox;

	@FindBy(id = "input-payment-address-1")
	private WebElement paymentAddressInputBox;

	@FindBy(id = "input-payment-city")
	private WebElement cityInputBox;

	@FindBy(id = "input-payment-postcode")
	private WebElement postCodeInputBox;

	@FindBy(id = "input-payment-country")
	private WebElement countrySelectBox;

	@FindBy(id = "input-payment-zone")
	private WebElement regionSelectBox;

	@FindBy(id = "button-payment-address")
	private WebElement addPaymentAddressBtn;

	@FindBy(id = "button-shipping-address")
	private WebElement continueShippingAddressBtn;

	@FindBy(id = "button-shipping-method")
	private WebElement continueShippingMethodBtn;

	@FindBy(css = "div [name='agree']")
	private WebElement agreeCheckboxRadioBtn;

	@FindBy(id = "button-payment-method")
	private WebElement confirmPaymentMethodBtn;

	@FindBy(id = "button-confirm")
	private WebElement confirmOrderBtn;
	
	
	private void clickAddAddressBtn() {
		newAddressRadioBtn = ExplicitWaitUtil.waitForElementToBeClickable(By.cssSelector("label [name*='payment'][value='new']"));
		newAddressRadioBtn.click();
	}
	
	private void enterBillingFirstName(String billingFirstName) {
		firstNameInputBox.sendKeys(billingFirstName);
	}

	private void enterBillingLastName(String billingLastName) {
		lastNameInputBox.sendKeys(billingLastName);
	}

	private void enterBillingAddress(String billingAddress) {
		paymentAddressInputBox.sendKeys(billingAddress);
	}

	private void enterBillingCity(String billingCity) {
		cityInputBox.sendKeys(billingCity);
	}

	private void enterPostCode(String postCode) {
		postCodeInputBox.sendKeys(postCode);
	}

	private void selectCountry(String countryOptionText, String countryOptionValue) {
		CommonUtils.selectElement(countrySelectBox, countryOptionText, countryOptionValue);
		ExplicitWaitUtil.waitForTextToBePresentInElement(countrySelectBox, countryOptionText);
	}

	private void selectRegion(String zoneOptionText, String zoneOptionValue) {
		ExplicitWaitUtil.waitForPresenceofNestedElement(By.id("input-payment-zone"), By.xpath("//select//option[text()='Ontario']"));
		CommonUtils.selectElement(regionSelectBox, zoneOptionText, zoneOptionValue);
	}
	
	private void clickAddPaymentAddressBtn() {
		addPaymentAddressBtn = ExplicitWaitUtil.waitForElementToBeClickable(By.id("button-payment-address"));
		addPaymentAddressBtn.click();
	}

	private void clickContinueShippingBtn() {
		continueShippingAddressBtn = ExplicitWaitUtil.waitForElementToBeClickable(By.id("button-shipping-address"));
		continueShippingAddressBtn.click();
	}

	private void clickagreeCheckboxRadioBtn() {
		agreeCheckboxRadioBtn = ExplicitWaitUtil.waitForElementToBeClickable(By.cssSelector("div [name='agree']"));
		agreeCheckboxRadioBtn.click();
	}

	private void clickConfirmShippingMethodBtn() {
		continueShippingMethodBtn = ExplicitWaitUtil.waitForElementToBeClickable(By.id("button-shipping-method"));
		continueShippingMethodBtn.click();
	}

	private void clickConfirmPaymentMethodBtn() {
		confirmPaymentMethodBtn = ExplicitWaitUtil.waitForElementToBeClickable(By.id("button-payment-method"));
		confirmPaymentMethodBtn.click();
	}

	private void clickConfirmOrderBtn() {
		confirmOrderBtn = ExplicitWaitUtil.waitForElementToBeClickable(By.id("button-confirm"));
		confirmOrderBtn.click();

	}

	public OrderConfirmationPage placeOrder(String firstName, String lastName, String address, String city,
			String postCode, String countryOptionText, String countryOptionValue, String zoneOptionText,
			String zoneOptionValue) {
		clickAddAddressBtn();
		enterBillingFirstName(firstName);
		enterBillingLastName(lastName);
		enterBillingAddress(address);
		enterBillingCity(city);
		enterPostCode(postCode);
		selectCountry(countryOptionText, countryOptionValue);
		selectRegion(zoneOptionText, zoneOptionValue);
		clickAddPaymentAddressBtn();
		clickContinueShippingBtn();
		clickConfirmShippingMethodBtn();
		clickagreeCheckboxRadioBtn();
		clickConfirmPaymentMethodBtn();
		clickConfirmOrderBtn();

		return new OrderConfirmationPage();
	}

}
