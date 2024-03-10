package com.naveenAutomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenAutomation.testBase.TestBase;

public class ShoppingCartPage extends TestBase {

	public ShoppingCartPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#content h2")
	private WebElement shoppingCartBannerText;
	
	public String getShoppingCartBannerText() {
		return shoppingCartBannerText.getText();
		
	}
	

}
