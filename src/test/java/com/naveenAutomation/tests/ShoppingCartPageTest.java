package com.naveenAutomation.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenAutomation.pages.AccountLoginPage;
import com.naveenAutomation.pages.DesktopsPage;
import com.naveenAutomation.pages.MacBookAirPage;
import com.naveenAutomation.pages.MyAccountPage;
import com.naveenAutomation.pages.ShoppingCartPage;
import com.naveenAutomation.testBase.TestBase;
import com.naveenAutomation.utilities.CommonUtils;
import com.naveenAutomation.utilities.DataProviderUtils;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class ShoppingCartPageTest extends TestBase {

	AccountLoginPage loginPage;
	MyAccountPage accountPage;
	DesktopsPage desktopsPage;
	MacBookAirPage macBookAirPage;
	ShoppingCartPage shoppingCartPage;

	@BeforeMethod
	public void launchBrowser() {
		intialization();
		loginPage = new AccountLoginPage();
	}

	@Severity(SeverityLevel.CRITICAL)
	@Epic("Product Management")
	@Feature("Add to Cart")
	@Test(dataProvider = "validLoginData", dataProviderClass = DataProviderUtils.class)
	public void validateAddToCart(String username, String password) {
		accountPage = loginPage.submitCorrectLoginInfo(username, password);
		desktopsPage = accountPage.showAllDesktops();
		macBookAirPage = desktopsPage.selectMacBook();
		shoppingCartPage = macBookAirPage.completeAddToCart();
		String shoppingCartBannerText = shoppingCartPage.getShoppingCartBannerText();
		Assert.assertEquals(shoppingCartBannerText, "What would you like to do next?");

	}

	@Severity(SeverityLevel.CRITICAL)
	@Epic("Product Management")
	@Feature("Add to Cart")
	@Test(dataProvider = "validLoginData", dataProviderClass = DataProviderUtils.class)
	public void validateAddToCartForMultipleItems(String username, String password) {
		accountPage = loginPage.submitCorrectLoginInfo(username, password);
		desktopsPage = accountPage.showAllDesktops();
		macBookAirPage = desktopsPage.selectMacBook();
		shoppingCartPage = macBookAirPage
				.completeAddToCartForMultipleItems(CommonUtils.generateRandomNumberGreaterThanOne());
		String shoppingCartBannerText = shoppingCartPage.getShoppingCartBannerText();
		Assert.assertEquals(shoppingCartBannerText, "What would you like to do next?");

	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}
}
