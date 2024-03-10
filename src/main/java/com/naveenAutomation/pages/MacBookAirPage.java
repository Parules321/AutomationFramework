package com.naveenAutomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.naveenAutomation.testBase.TestBase;
import com.naveenAutomation.utilities.CommonUtils;
import com.naveenAutomation.utilities.ExplicitWaitUtil;

public class MacBookAirPage extends TestBase {

	public MacBookAirPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "li:first-of-type a.dropdown-toggle")
	private WebElement desktopsDropdwn;

	@FindBy(css = "ul.nav>li:first-of-type>div>a")
	private WebElement showAllDesktopsBtn;

	@FindBy(id = "input-quantity")
	private WebElement quantityInputBox;

	@FindBy(id = "button-cart")
	private WebElement addToCartBtn;

	@FindBy(id = "cart-total")
	private WebElement cartTotalBtn;

	@FindBy(css = "strong .fa-shopping-cart")
	private WebElement viewCartBtn;

	private void enterQuantityMoreThanOne(String multipleQuantity) {
		quantityInputBox.clear();
	//	multipleQuantity = CommonUtils.generateRandomNumberGreaterThanOne();
		quantityInputBox.sendKeys(multipleQuantity);
	}

	private void clickAddToCartBtn() {
		addToCartBtn.click();
	}

	private void clickCartTotalBtn() {
		cartTotalBtn.click();
	}

	private void clickViewCartBtn() {
		viewCartBtn = ExplicitWaitUtil.waitForElementToBeClickable(By.cssSelector("strong .fa-shopping-cart"));
		viewCartBtn.click();
	}

	public DesktopsPage navigateBackToAllProductsWithItemAddedToCart() {
		clickAddToCartBtn();
		driver.navigate().back();
		return new DesktopsPage();
	}

	public ShoppingCartPage completeAddToCart() {
		clickAddToCartBtn();
		clickCartTotalBtn();
		clickViewCartBtn();
		return new ShoppingCartPage();
	}

	public ShoppingCartPage completeAddToCartForMultipleItems(String multipleQuantity) {
		enterQuantityMoreThanOne(multipleQuantity);
		clickAddToCartBtn();
		clickCartTotalBtn();
		clickViewCartBtn();
		return new ShoppingCartPage();
	}

}
