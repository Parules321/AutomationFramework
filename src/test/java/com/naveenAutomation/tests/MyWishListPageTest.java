package com.naveenAutomation.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenAutomation.pages.AccountLoginPage;
import com.naveenAutomation.pages.DesktopsPage;
import com.naveenAutomation.pages.MyAccountPage;
import com.naveenAutomation.pages.MyWishListPage;
import com.naveenAutomation.testBase.TestBase;
import com.naveenAutomation.utilities.DataProviderUtils;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class MyWishListPageTest extends TestBase {

	AccountLoginPage loginPage;
	MyAccountPage accountPage;
	DesktopsPage desktopsPage;
	MyWishListPage wishListPage;

	@BeforeMethod
	public void launchBrowser() {
		intialization();
		loginPage = new AccountLoginPage();
	}

	@Severity(SeverityLevel.MINOR)
	@Epic("Product Management")
	@Feature("Wishlist")
	@Test(dataProvider = "validLoginData", dataProviderClass = DataProviderUtils.class)
	public void validateAddItemToWishList(String username, String password) {
		accountPage = loginPage.submitCorrectLoginInfo(username, password);
		desktopsPage = accountPage.showAllDesktops();
		wishListPage = desktopsPage.addSingleItemToWishList();
		String wishListBannerText = wishListPage.getwishListPageBannerTxt();
		Assert.assertEquals(wishListBannerText, "My Wish List");
	}

	@Severity(SeverityLevel.MINOR)
	@Epic("Product Management")
	@Feature("Wishlist")
	@Test(dataProvider = "validLoginData", dataProviderClass = DataProviderUtils.class)
	public void validateMoveWishListItemToCart(String username, String password) {
		accountPage = loginPage.submitCorrectLoginInfo(username, password);
		desktopsPage = accountPage.showAllDesktops();
		wishListPage = desktopsPage.addMultipleItemsToWishList();
		wishListPage = wishListPage.moveItemToCart();
		String itemMovedToCartAlertText = wishListPage.getItemMovedToCartAlertText();
		Assert.assertEquals(itemMovedToCartAlertText, "shopping cart");
	}

	@Severity(SeverityLevel.MINOR)
	@Epic("Product Management")
	@Feature("Wishlist")
	@Test(dataProvider = "validLoginData", dataProviderClass = DataProviderUtils.class)
	public void validateRemoveItemFromWishList(String username, String password) {
		accountPage = loginPage.submitCorrectLoginInfo(username, password);
		desktopsPage = accountPage.showAllDesktops();
		wishListPage = desktopsPage.addMultipleItemsToWishList();
		wishListPage = wishListPage.removeItemFromWishList();
		String itemRemovedAlertText = wishListPage.getItemRemovedFromWishListAlertText();
		Assert.assertTrue(itemRemovedAlertText.contains("You have modified your wish list"));
	}

	@Severity(SeverityLevel.MINOR)
	@Epic("Product Management")
	@Feature("Wishlist")
	@Test(dataProvider = "validLoginData", dataProviderClass = DataProviderUtils.class)
	public void validateAddMultipleItemsToWishList(String username, String password) {
		accountPage = loginPage.submitCorrectLoginInfo(username, password);
		desktopsPage = accountPage.showAllDesktops();
		wishListPage = desktopsPage.addMultipleItemsToWishList();
		String wishListBannerText = wishListPage.getwishListPageBannerTxt();
		Assert.assertEquals(wishListBannerText, "My Wish List");
	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}

}
