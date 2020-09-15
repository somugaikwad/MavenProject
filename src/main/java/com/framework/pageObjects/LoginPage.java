package com.framework.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	By email = By.id("username");
	By pwd = By.id("password");
	By log_in = By.id("Login");

	public WebElement email() {
		return driver.findElement(email);
	}

	public WebElement password() {
		return driver.findElement(pwd);
	}

	public WebElement logIn() {
		return driver.findElement(log_in);
	}
}
