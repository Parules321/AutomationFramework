package com.naveenAutomation.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenAutomation.pages.AccountLoginPage;
import com.naveenAutomation.pages.AddAddressPage;
import com.naveenAutomation.pages.AddressBookPage;
import com.naveenAutomation.pages.CheckoutPage;
import com.naveenAutomation.pages.DesktopsPage;
import com.naveenAutomation.pages.IpodClassicPage;
import com.naveenAutomation.pages.MacBookAirPage;
import com.naveenAutomation.pages.MyAccountPage;
import com.naveenAutomation.pages.OrderConfirmationPage;
import com.naveenAutomation.testBase.TestBase;
import com.naveenAutomation.utilities.DataProviderUtils;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class OrderConfirmationPageTest extends TestBase {

	AccountLoginPage loginPage;
	MyAccountPage accountPage;
	AddressBookPage addressBookPage;
	AddAddressPage addAddressPage;
	DesktopsPage desktopsPage;
	MacBookAirPage macBookAirPage;
	IpodClassicPage ipodClassicPage;
	CheckoutPage checkoutPage;
	OrderConfirmationPage orderConfimedPage;

	@BeforeMethod
	public void launchBrowser() {
		intialization();
		loginPage = new AccountLoginPage();
	}

	@Severity(SeverityLevel.CRITICAL)
	@Epic("User Transactions")
	@Feature("Product Purchase")
	@Test(dataProvider = "completeProductPurchaseData", dataProviderClass = DataProviderUtils.class)
	public void validateCompletePurchaseForSingleItem(String username, String password, String firstName,
			String lastName, String address, String city, String postCode, String countryOptionText,
			String countryOptionValue, String zoneOptionText, String zoneOptionValue) {
		accountPage = loginPage.submitCorrectLoginInfo(username, password);
		desktopsPage = accountPage.showAllDesktops();
		ipodClassicPage = desktopsPage.selectIpodClassic();
		checkoutPage = ipodClassicPage.completeCheckout();
		orderConfimedPage = checkoutPage.placeOrder(firstName, lastName, address, city, postCode, countryOptionText,
				countryOptionValue, zoneOptionText, zoneOptionValue);
		String orderConfirmationText = orderConfimedPage.getOrderConfirmationText();
		Assert.assertEquals(orderConfirmationText, "Your order has been placed!");
	}

	@Severity(SeverityLevel.CRITICAL)
	@Epic("User Transactions")
	@Feature("Product Purchase")
	@Test(dataProvider = "completeProductPurchaseData", dataProviderClass = DataProviderUtils.class)
	public void validateCompletePurchaseForMultipleItems(String username, String password, String firstName,
			String lastName, String address, String city, String postCode, String countryOptionText,
			String countryOptionValue, String zoneOptionText, String zoneOptionValue) {
		accountPage = loginPage.submitCorrectLoginInfo(username, password);
		desktopsPage = accountPage.showAllDesktops();
		macBookAirPage = desktopsPage.selectMacBook();
		desktopsPage = macBookAirPage.navigateBackToAllProductsWithItemAddedToCart();
		ipodClassicPage = desktopsPage.selectIpodClassic();
		checkoutPage = ipodClassicPage.completeCheckout();
		orderConfimedPage = checkoutPage.placeOrder(firstName, lastName, address, city, postCode, countryOptionText,
				countryOptionValue, zoneOptionText, zoneOptionValue);
		String orderConfirmationText = orderConfimedPage.getOrderConfirmationText();
		Assert.assertEquals(orderConfirmationText, "Your order has been placed!");
	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}
}
