package com.naveenAutomation.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenAutomation.testBase.TestBase;
import com.naveenAutomation.utilities.CommonUtils;
import com.naveenAutomation.utilities.ExplicitWaitUtil;

public class MyAccountPage extends TestBase {

	public MyAccountPage() {
		PageFactory.initElements(driver, this);

	}


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
	
	@FindBy(xpath = "//li //a[text()='Account']")
	private WebElement accountPageBannerTxt;
	
	@FindBy(xpath = "//h2[text()='My Account']")
	private WebElement myAccountBannerTxt;
	
	
	private void getMyAccountDropDownMenu() {
		myAccountDropDwnBtn.click();
	}

	public String getMyAccountText() {
		return myAccountBannerTxt.getText();
	}

	public String getAccountUpdateAlertText() {;
		return accountPageBannerTxt.getText();
	}

	public String getPasswordUpdateAlertText() {
		return accountPageBannerTxt.getText();
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
