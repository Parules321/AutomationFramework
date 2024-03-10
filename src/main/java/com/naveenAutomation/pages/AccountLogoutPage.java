package com.naveenAutomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenAutomation.testBase.TestBase;

public class AccountLogoutPage extends TestBase{
	
	public AccountLogoutPage() {
		PageFactory.initElements(driver, this);
	}
		
	@FindBy(css = "#content h1")
	private WebElement logoutMsgText;
	
	public String getLogoutMsgText() {
		return logoutMsgText.getText();
	}

}
