package com.naveenAutomation.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.naveenAutomation.testBase.TestBase;

public class ExplicitWaitUtil extends TestBase {

	private static int DEFAULT_TIMEOUT = 15;
	

	public static WebElement waitForElementToBeClickable(By locator) {
		return new WebDriverWait(driver, DEFAULT_TIMEOUT).until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public static WebElement waitForVisibilityOfElement(By locator) {
		return new WebDriverWait(driver, DEFAULT_TIMEOUT).until(ExpectedConditions.visibilityOfElementLocated(locator));	
	}

	public static void waitForTextToBePresentInElement(WebElement element, String text) {
		new WebDriverWait(driver, DEFAULT_TIMEOUT).until(ExpectedConditions.textToBePresentInElement(element, text));
	}

	public static void waitForPresenceofNestedElement(By locator, By nestedElementLocator) {
		new WebDriverWait(driver, DEFAULT_TIMEOUT).until(ExpectedConditions.presenceOfNestedElementLocatedBy(locator, nestedElementLocator));
	}

}
