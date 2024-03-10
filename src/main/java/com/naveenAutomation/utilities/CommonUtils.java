package com.naveenAutomation.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.naveenAutomation.dateFormats.DateFormat;
import com.naveenAutomation.testBase.TestBase;

public class CommonUtils extends TestBase {

	public static void selectElement(WebElement element, String text, String value) {
		Select sc = new Select(element);

		try {
			sc.selectByVisibleText(text);
		} catch (Exception e) {
			sc.selectByValue(value);
		}
	}

	public static void clickElementFromWebTable(List<WebElement> rowList, List<WebElement> columnList, By locator,
			String expectedText) {
		for (int r = 1; r <= rowList.size(); r++) {
			for (int c = 1; c <= columnList.size(); c++) {
				WebElement element = driver.findElement(locator);
				if (element.getText().equals(expectedText)) {
					element.click();
					break;
				}
			}
		}
	}

	
	public static void takeFailedTestScreenShot(String testCaseName) {
	
		String timeStamp = new SimpleDateFormat(DateFormat.LONG_DATE.getFormat()).format(new Date());
		File screenShotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenShotFile,
					new File("./FailedScreenShot\\" + "_" + testCaseName + "_" + timeStamp + ".jpeg"));
		} catch (IOException e) {
			System.out.println("Unable to save or take screen shot of failed test " + testCaseName);

		}

	}

	public static void clickOnElementFromWebElementsList(List<WebElement> elements, String elementText) {

		for (WebElement element : elements) {

			if (element.getText().equals(elementText)) {
				element.click();
				break;
			}

		}
	}

	public static String generateRandomNumberGreaterThanOne() {
		int randomQuantity = new Random().nextInt(5) + 1;
		String quantity = String.valueOf(randomQuantity);
		return quantity;
	}
	
}