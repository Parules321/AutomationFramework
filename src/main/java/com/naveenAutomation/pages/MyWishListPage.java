package com.naveenAutomation.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenAutomation.testBase.TestBase;

public class MyWishListPage extends TestBase{
	
	
	public MyWishListPage() {
		PageFactory.initElements(driver, this);
	}
		
	@FindBy(css="tr:first-of-type button.btn-primary")
	WebElement moveToCartBtn;
	
	@FindBy(css ="tr:last-of-type a.btn-danger")
	WebElement removeFromWishListBtn;
	
		
	@FindBy (css =".alert-success a:last-of-type")
	WebElement itemMovedToCartAlertTxt;
	
	@FindBy (css =".alert-success")
	WebElement itemRemovedFromWishListAlertText;
	
	@FindBy (css ="#content p")
	WebElement emptyWishListConfirmationTxt;
	
	@FindBy (xpath ="//h2[contains(text(), 'My Wish')]")
	WebElement wishListPageBannerTxt;
	
	
	private void clickMoveToCartBtn() {
		moveToCartBtn.click();
	}
	
	private void clickRemoveFromWishListBtn() {
		removeFromWishListBtn.click();
	}
	
	public String getwishListPageBannerTxt() {
		return wishListPageBannerTxt.getText();
	}
	
	public String getWishListIsEmptyConfirmationTxt() {
		return emptyWishListConfirmationTxt.getText();
	}
	
	public String getItemMovedToCartAlertText() {
		return itemMovedToCartAlertTxt.getText();
	}
	
	public String getItemRemovedFromWishListAlertText() {
		return itemRemovedFromWishListAlertText.getText();
	}
	
	
	public MyWishListPage moveItemToCart() {
		clickMoveToCartBtn();
		return new MyWishListPage();
	}
	
	public MyWishListPage removeItemFromWishList() {
		clickRemoveFromWishListBtn();
		return new MyWishListPage();
	}
	
	

}
