package com.framework.testCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.framework.generics.Base;
import com.framework.generics.FileLib;
import com.framework.pageObjects.HomePage;
import com.framework.pageObjects.LoginPage;

@Listeners(com.framework.testCases.Listener.class)
public class Login extends Base{
	public static Logger log = LogManager.getLogger(Login.class.getName());
	WebDriver driver;
	Base b;
	FileLib f;

	@BeforeTest
	public void initilizeBrowser() throws IOException {
		b=new Base();
		f = new FileLib();
		log.debug("open the browser");
		driver = b.openBrowser();
	}

	@AfterTest
	public void closeBrowser() {
		log.debug("Close the browser");
		b.closeBrowser(driver);
		log.info("Browser Closed");
	}

	@Test(dataProvider = "data",priority = 3)
	public void login(String username, String password) throws IOException {
		String url = f.data();
		log.debug("Enter url");
		driver.get(url);
		HomePage h = new HomePage(driver);
		h.login().click();
		log.info("Login page is displayed");
		LoginPage l = new LoginPage(driver);
		log.debug("Enter user Id");
		l.email().sendKeys(username);
		log.debug("Enter password");
		l.password().sendKeys(password);
		log.debug("Click on login button");
		l.logIn().click();
		Reporter.log(driver.getTitle(), true);

	}

	@DataProvider
	public String[][] data() {
		String[][] s = new String[2][2];
		s[0][0] = "somugaikwad93@gmail.com";
		s[0][1] = "9916592942";
		s[1][0] = "somanath.sbg@gmail.com";
		s[1][1] = "7019807360";
		return s;
	}
	@Test(priority = 1)
	public void displayText() throws IOException {
		String url = f.data();
		log.debug("Enter url");
		driver.get(url);
		HomePage h = new HomePage(driver);
		log.debug("check text is displayed or not");
		Assert.assertTrue(h.displayText().isDisplayed());
		log.info("Text is displayed");
	}
	@Test(priority=2)
	public void verifyText() throws IOException {
		String url = f.data();
		log.debug("Enter url");
		driver.get(url);
		HomePage h = new HomePage(driver);
		log.debug("verify actual Text to Expected Text");
		Assert.assertEquals(h.text().getText(), "somu");
		log.error("Verification Failed");
	}

}
