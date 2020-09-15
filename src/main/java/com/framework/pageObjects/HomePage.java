package com.framework.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	private By login = By.xpath("//div[@class='dropdown']");
	private By text = By.xpath("(//span[@class='salesforce-sans-bold uppercase text-cirrus'])[1]/../b");
	private By textDisplay = By.xpath("(//span[@class='salesforce-sans-bold uppercase text-cirrus']/a/b)[1]");

	/**
	 * 
	 * @return login button
	 */
	public WebElement login() {
		return driver.findElement(login);
	}

	public WebElement text() {
		return driver.findElement(text);
	}

	public WebElement displayText() {
		return driver.findElement(textDisplay);
	}

}
