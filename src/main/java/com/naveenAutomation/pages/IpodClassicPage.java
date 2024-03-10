package com.naveenAutomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.naveenAutomation.testBase.TestBase;
import com.naveenAutomation.utilities.ExplicitWaitUtil;

public class IpodClassicPage extends TestBase {

	public IpodClassicPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "button-cart")
	private WebElement addToCartBtn;

	@FindBy(id = "cart-total")
	private WebElement cartTotalBtn;

	@FindBy(css = "a:nth-of-type(2) .fa")
	private WebElement checkOutBtn;

	private void clickAddToCartBtn() {
		addToCartBtn.click();
	}

	private void clickCartTotalBtn() {
		cartTotalBtn.click();
	}

	private void clickCheckoutBtn() {
		checkOutBtn = ExplicitWaitUtil.waitForElementToBeClickable(By.cssSelector("a:nth-of-type(2) .fa"));
		checkOutBtn.click();
	}

	public CheckoutPage completeCheckout() {
		clickAddToCartBtn();
		clickCartTotalBtn();
		clickCheckoutBtn();
		return new CheckoutPage();
	}

}
