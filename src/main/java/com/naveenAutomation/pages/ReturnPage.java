package com.naveenAutomation.pages;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.naveenAutomation.testBase.TestBase;
import com.naveenAutomation.utilities.CommonUtils;

public class ReturnPage extends TestBase {

	public ReturnPage() {
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = "div #input-firstname")
	private WebElement firstNameInputBox;

	@FindBy(css = "div #input-lastname")
	private WebElement lastNameInputBox;

	@FindBy(css = "div #input-email")
	private WebElement emailInputBox;

	@FindBy(css = "div #input-telephone")
	private WebElement phoneInputBox;

	@FindBy(id = "input-order-id")
	private WebElement orderIdInputBox;

	@FindBy(css = "div .date span button")
	private WebElement calendarBtn;

	@FindBy(css = "div.datepicker-days table thead tr th.prev")
	private WebElement datePickerArrowBtn;

	@FindBy(css = ".datepicker-days .picker-switch")
	private WebElement monthWithYear;
	
	@FindBy(xpath ="//div[@class='datepicker-days'] //table //tbody //tr")
	private List <WebElement> dateRowList;
	
	@FindBy(xpath = "//div[@class='datepicker-days'] //table //thead //tr[2]//th")
	private List <WebElement> dateColumnList;

	@FindBy(id = "input-product")
	private WebElement productNameInputBox;

	@FindBy(id = "input-model")
	private WebElement productModelInputBox;

	@FindBy(css = "input[value='2']")
	private WebElement returnReasonRadioBtn;

	@FindBy(css = "[type = 'submit']")
	private WebElement submitBtn;
	
	@FindBy(css = ".text-danger")
	private WebElement missingOrderIdAlertText;
	
	@FindBy(css = ".text-danger")
	private WebElement invalidEmailAlertText;

	private void enterFirstName(String firstName) {
		firstNameInputBox.sendKeys(firstName);
	}

	private void enterLastName(String lastName) {
		lastNameInputBox.sendKeys(lastName);
	}

	private void enterEmail(String email) {
		emailInputBox.sendKeys(email);
	}

	private void enterPhone(String phoneNo) {
		phoneInputBox.sendKeys(phoneNo);
	}

	private void enterOrderId(String orderId) {
		orderIdInputBox.sendKeys(orderId);
	}

	private void clickCalendarBtn() {
		calendarBtn.click();
	}

	private String getMonthWithYear() {
		String monthYear = monthWithYear.getText();
		return monthYear;
	}
	
	public void clickDatePickerArrowBtn() {datePickerArrowBtn.click();}

	private void chooseMonthWithYear(String expectedMonthWithYear) {
		clickCalendarBtn();
		while (!(getMonthWithYear().equals(expectedMonthWithYear))){
			clickDatePickerArrowBtn();
		}		
	}
	
	private void clickDateFromCalendarTable(String expectedDate) {
		CommonUtils.clickElementFromWebTable(dateRowList, dateColumnList, By.xpath("//div[@class='datepicker-days'] //table //tbody //tr[" + dateRowList.size()+ "]//td[" +dateColumnList.size() +"]"), expectedDate);	
	}
	
	private void chooseDate(String expectedMonthWithYear, String expectedDate) {
		chooseMonthWithYear(expectedMonthWithYear);
		clickDateFromCalendarTable(expectedDate);	
	}

	private void enterProductName(String productName) {
		productNameInputBox.sendKeys(productName);
	}

	private void enterProductModel(String productModel) {
		productModelInputBox.sendKeys(productModel);
	}

	private void chooseReturnReason() {
		returnReasonRadioBtn.click();
	}

	private void clickReturnBtn() {submitBtn.submit();}	
	
	
	public ReturnConfirmationPage submitReturnRequest(String firstName, String lastName, String email, String phone, String orderId,String expectedMonthWithYear, String expectedDate, String productName, String productCode) {
		enterFirstName(firstName);
		enterLastName(lastName);
		enterEmail(email);
		enterPhone(phone);
		enterOrderId(orderId);
		chooseDate(expectedMonthWithYear, expectedDate);
		enterProductName(productName);
		enterProductModel(productCode);
		chooseReturnReason();
		clickReturnBtn();
		return new ReturnConfirmationPage();
	}
	
	public ReturnPage submitReturnRequestWithMissingOrderId(String firstName, String lastName, String email, String phone,String expectedMonthWithYear, String expectedDate, String productName, String productCode) {
		enterFirstName(firstName);
		enterLastName(lastName);
		enterEmail(email);
		enterPhone(phone);
		chooseDate(expectedMonthWithYear, expectedDate);
		enterProductName(productName);
		enterProductModel(productCode);
		chooseReturnReason();
		clickReturnBtn();
		return new ReturnPage();
	}
	
	public ReturnPage submitReturnRequestWithInvalidEmail(String firstName, String lastName, String invalidEmail, String phone,String orderId,String expectedMonthWithYear, String expectedDate, String productName, String productCode) {
		enterFirstName(firstName);
		enterLastName(lastName);
		enterEmail(invalidEmail);
		enterPhone(phone);
		enterOrderId(orderId);
		chooseDate(expectedMonthWithYear, expectedDate);
		enterProductName(productName);
		enterProductModel(productCode);
		chooseReturnReason();
		clickReturnBtn();
		return new ReturnPage();
	}
	
	public String getInvalidEmailAlertText() {
		return invalidEmailAlertText.getText();	
	}
	
	public String getMissingOrderIdAlertText() {
		return missingOrderIdAlertText.getText();	
	}
}



