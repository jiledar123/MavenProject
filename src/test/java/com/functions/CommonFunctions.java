package com.functions;

import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonFunctions {

	WebDriver driver;
	WebElement element;
	By locator;

	public void loginWearecurio(String username, String password) {
		try {
			// Go to login page
			locator = By.cssSelector(".btn.btn-red-inverse");
			element = isPresent(driver, locator);
			element.click();
			// Fill in username field
			locator = By.id("username");
			element = isPresent(driver, locator);
			fillInto(username, element);
			// Fill in password field
			locator = By.id("password");
			element = isPresent(driver, locator);
			fillInto(password, element);
			// Click on Login button
			locator = By.xpath(".//*[@id='curiousloginform']/div[3]/input");
			element = isPresent(driver, locator);
			element.click();
			locator = By.cssSelector("a[data-toggle='dropdown']");
			element = isPresent(driver, locator);
		} catch (Exception e) {
			System.out.println("Login failed");
			e.printStackTrace();
		}
		
	}

	public WebDriver setupBrowser() {
		// here we can handle multiple browsers and its Capabilities
		System.setProperty("webdriver.chrome.driver", "lib/driver/chromedriver.exe");
		driver = new ChromeDriver();
		return driver;
	}

	public WebElement isPresent(WebDriver driver, By locator) {
		try {
			new WebDriverWait(driver, 20).until(ExpectedConditions
					.presenceOfElementLocated(locator));
			element = driver.findElement(locator);
		} catch (Exception e) {
			System.out.println("Element is not present.");
			e.printStackTrace();
		}

		return element;
	}

	public void fillInto(String value, WebElement element) {
		element.sendKeys(value);
	}
}
