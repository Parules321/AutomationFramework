package com.naveenAutomation.testBase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.BeforeSuite;

import com.naveenAutomation.browsers.Browsers;
import com.naveenAutomation.environment.Environment;
import com.naveenAutomation.listeners.WebDriverEvents;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;
	private static Browsers DEFAULT_BROWSER = Browsers.CHROME;
	private static Environment DEFAULT_ENV = Environment.PROD;
	public static Logger logger;
	private WebDriverEvents events;
	private EventFiringWebDriver eDriver;

	@BeforeSuite
	public void setUpLogger() {
		logger = Logger.getLogger(TestBase.class);
		PropertyConfigurator.configure("log4j.properties");
		BasicConfigurator.configure();
		logger.setLevel(Level.ALL);
	}

	public void intialization() {
		setBrowserForTesting();
		driverManagement();
		logger.info("Loading Page in Browser");
		driver.get(DEFAULT_ENV.getEnvUrl());
	}

	private void driverManagement() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	private void setBrowserForTesting() {
		switch (DEFAULT_BROWSER) {
		case CHROME:
			WebDriverManager.chromedriver().setup();
			logger.info("Launching Chrome Browser");
			driver = new ChromeDriver();
			break;
		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.DISMISS);
			logger.info("Launching Firefox Browser");
			driver = new FirefoxDriver(firefoxOptions);
			break;
		case EDGE:
			WebDriverManager.edgedriver().setup();
			logger.info("Launching Edge Browser");
			driver = new EdgeDriver();
			break;

		default:
			throw new IllegalArgumentException();
		}

		eDriver = new EventFiringWebDriver(driver);

		events = new WebDriverEvents();

		eDriver.register(events);
		driver = eDriver;
	}

	public void tearDown() {
		driver.close();
	}

}