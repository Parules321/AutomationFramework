package com.naveenAutomation.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenAutomation.testBase.TestBase;
import com.naveenAutomation.utilities.CommonUtils;

public class DesktopsPage extends TestBase {

	public DesktopsPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "div div.caption a")
	List<WebElement> productClickBtnsList;

	@FindBy(css = "div.product-grid:nth-of-type(8) i.fa-heart")
	WebElement addMacBookAirToWishListBtn;

	@FindBy(css = "div.product-grid:nth-of-type(6) i.fa-heart")
	WebElement addIpodClassicToWishListBtn;

	@FindBy(css = "div.product-grid:last-of-type i.fa-heart")
	WebElement addSonyVaioToWishListBtn;

	@FindBy(css = "li:nth-of-type(3) .fa-heart")
	WebElement continueToWishListPageBtn;

	public MacBookAirPage selectMacBook() {
		CommonUtils.clickOnElementFromWebElementsList(productClickBtnsList, "MacBook Air");
		return new MacBookAirPage();
	}

	public SonyVaioPage selectSonyVaio() {
		CommonUtils.clickOnElementFromWebElementsList(productClickBtnsList, "Sony VAIO");
		return new SonyVaioPage();
	}

	public IpodClassicPage selectIpodClassic() {
		CommonUtils.clickOnElementFromWebElementsList(productClickBtnsList, "iPod Classic");
		return new IpodClassicPage();
	}

	private void clickAddMacBookAirToWishListBtn() {
		addMacBookAirToWishListBtn.click();
	}

	private void clickAddIpodClassicToWishListBtn() {
		addIpodClassicToWishListBtn.click();
	}

	private void clickAddSonyVaioToWishListBtn() {
		addSonyVaioToWishListBtn.click();
	}

	private void clickContinueToWishListPageBtn() {
		continueToWishListPageBtn.click();
	}

	public MyWishListPage addSingleItemToWishList() {
		clickAddIpodClassicToWishListBtn();
		clickContinueToWishListPageBtn();
		return new MyWishListPage();
	}

	public MyWishListPage addMultipleItemsToWishList() {
		clickAddSonyVaioToWishListBtn();
		clickAddMacBookAirToWishListBtn();
		clickContinueToWishListPageBtn();
		return new MyWishListPage();

	}

}
