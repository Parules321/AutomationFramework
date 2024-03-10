package com.naveenAutomation.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenAutomation.testBase.TestBase;
import com.naveenAutomation.utilities.CommonUtils;

public class MyAccountPage extends TestBase {

	public MyAccountPage() {
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = "div .alert-success")
	private WebElement passwordUpdateAlert;

	@FindBy(xpath = "//h2[text() = 'My Account']")
	private WebElement myAccountText;

	@FindBy(css = "div [class*='alert-success']")
	private WebElement accountUpdateAlertText;

	@FindBy(css = ".list-group a")
	private List<WebElement> sideNavMenuList;

	@FindBy(css = "span.caret")
	private WebElement myAccountDropDwnBtn;

	@FindBy(css = "ul.dropdown-menu-right li:last-of-type")
	private WebElement myAccountLogOutBtn;
	
	@FindBy(css = "li:first-of-type a.dropdown-toggle")
	private WebElement desktopsDropdwn;
	
	@FindBy(css = "ul.nav>li:first-of-type>div>a")
	private WebElement showAllDesktopsBtn;
	
	
	private void getMyAccountDropDownMenu() {
		myAccountDropDwnBtn.click();
	}

	public String getMyAccountText() {
		return myAccountText.getText();
	}

	public String getAccountUpdateAlertText() {
		return accountUpdateAlertText.getText();
	}

	public String getPasswordUpdateAlertText() {
		return passwordUpdateAlert.getText();
	}

	public AccountLogoutPage clickSideNavLogOutBtn() {
		CommonUtils.clickOnElementFromWebElementsList(sideNavMenuList, "Logout");
		return new AccountLogoutPage();
	}

	public AccountLogoutPage clickMyAccountLogOutBtn() {
		getMyAccountDropDownMenu();
		myAccountLogOutBtn.click();
		return new AccountLogoutPage();
	}

	public MyAccountInformationPage clickEditAccountBtn() {
		CommonUtils.clickOnElementFromWebElementsList(sideNavMenuList, "Edit Account");
		return new MyAccountInformationPage();
	}

	public ChangePasswordPage clickUpdatePasswordBtn() {
		CommonUtils.clickOnElementFromWebElementsList(sideNavMenuList, "Password");
		return new ChangePasswordPage();
	}

	public AddressBookPage clickAddressBookBtn() {
		CommonUtils.clickOnElementFromWebElementsList(sideNavMenuList, "Address Book");
		return new AddressBookPage();
	}
	
	
	private void hoverOverDesktopDrpdwn() {
		Actions action = new Actions(driver);
		action.moveToElement(desktopsDropdwn).perform();		
	}
	
	private void clickShowAllDesktops() {
		showAllDesktopsBtn.click();
	}
	
	public DesktopsPage showAllDesktops() {
		hoverOverDesktopDrpdwn();
		clickShowAllDesktops();
		return new DesktopsPage();
		
	}
	
}
