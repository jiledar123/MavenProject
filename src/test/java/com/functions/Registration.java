package com.functions;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sun.jna.platform.win32.WinDef.LPARAM;

public class Registration {
	ArrayList<String> credentials;
	WebDriver driver;
	WebElement element;
	By locator;
	CommonFunctions function = new CommonFunctions();

	public ArrayList<String> registerWearecurio(WebDriver driver) {
		
		try {
			credentials = new ArrayList<String>();
			locator = By.cssSelector(".btn.btn-red-inverse");
			
			WebElement login = function.isPresent(driver,locator);
			login.click();
			locator = By.xpath("//a[text()='Create an account']");
			WebElement element = function.isPresent(driver,locator);
			element.click();
			//Check the registration form loaded properly
			locator = By.id("signupForm");
			function.isPresent(driver,locator);
			//Generate unique user name 
			int randomNum = ThreadLocalRandom.current().nextInt(0, 9999 + 1);
			String UserName = "User"+randomNum;
			//Fill user name in to username field
			locator = By.id("username");
			element = function.isPresent(driver,locator);
			function.fillInto(UserName, element);
			//Fill Password in password field
			locator = By.id("password");
			element = function.isPresent(driver,locator);
			function.fillInto("Password123", element);
			//Fill email id in email address field
			locator = By.id("email");
			element = function.isPresent(driver,locator);
			function.fillInto("test"+randomNum+"@gmail.com", element);
			locator = By.id("confirm_email");
			element = function.isPresent(driver,locator);
			function.fillInto("test"+randomNum+"@gmail.com", element);
			//Fill the Full name in text field
			locator = By.id("name");
			element = function.isPresent(driver,locator);
			function.fillInto("User", element);
			//Fill the Promo code in text field
			locator = By.id("promoCode");
			element = function.isPresent(driver,locator);
			function.fillInto("ABC", element);
			//Click on Register Now button
			locator = By.xpath("//button[contains(text(),'Register')]");
			element = function.isPresent(driver,locator);
			element.click();
//			element = driver.findElement(By.cssSelector(".col-sm-2.col-sm-offset-1.text-center>div"));
//			if(element==null){
//				System.out.println("User is already register.");
//			}else{
				credentials.add(UserName);
				credentials.add("Password123");
//			}
			
		} catch (Exception e) {
			System.out
					.println("Registeration to Wearecurio application is failed.");
			e.printStackTrace();
		}
		
		return credentials;
	}
}
