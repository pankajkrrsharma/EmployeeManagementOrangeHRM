package com.hrm.qa.testcases;


import org.testng.annotations.Test;
import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.hrm.qa.base.TestBase;
import com.hrm.qa.pages.LoginPage;


public class LoginPageTest extends TestBase {

	LoginPage loginPage;
	String actualHomePageUrl;

	public LoginPageTest() {
		super();

	}

	@BeforeMethod
	public void setup()  {

		initialization();
		loginPage = new LoginPage();
	}

	/*
	 * Expected result - driver should navigate to home page URL.
	 */
	@Test(description = "Validating login page")
	public void LoginTest() {

		actualHomePageUrl =	loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(actualHomePageUrl, prop.getProperty("expectedHomePageUrl"));

	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}

}



