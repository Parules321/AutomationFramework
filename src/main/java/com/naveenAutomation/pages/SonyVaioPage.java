package com.naveenAutomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenAutomation.testBase.TestBase;


public class SonyVaioPage extends TestBase{
	
	
	public SonyVaioPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "li:first-of-type a.dropdown-toggle")
	private WebElement desktopsDropdwn;

	@FindBy(css = "ul.nav>li:first-of-type>div>a")
	private WebElement showAllDesktopsBtn;

	@FindBy(id = "button-cart")
	private WebElement addToCartBtn;


	private void clickAddToCartBtn() {
		addToCartBtn.click();
	}

	public DesktopsPage navigateBackToAllProductsWithItemAddedToCart() {
		clickAddToCartBtn();
		driver.navigate().back();
		return new DesktopsPage();
	}

	

}
