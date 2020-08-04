package com.hrm.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;	
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.hrm.qa.util.TestUtil;
import com.hrm.qa.util.WebEventListener;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebDriverWait wait;
	public  String PicturePath;
	public static WebEventListener eventListener;

	public TestBase()  {

		try {
			prop = new Properties();
			String ProperpertiesPath = System.getProperty("user.dir") + File.separator + "data" + File.separator
					+ "Testdata.properties";
			PicturePath = System.getProperty("user.dir") + File.separator + "data" + File.separator + "EmployeePicture.jpg";
			FileInputStream ip = new FileInputStream(ProperpertiesPath);
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public static void initialization() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));


	}

	public static void Sendkeys(WebDriver driver,WebElement element  , String value) {

		new WebDriverWait(driver, TestUtil.Explicit_wait).until(ExpectedConditions.visibilityOf(element));
		element.clear();
		element.sendKeys(value);

	}
	public static void Clickon(WebDriver driver,WebElement element ) {

		new WebDriverWait(driver, TestUtil.Explicit_wait).until(ExpectedConditions.elementToBeClickable(element));
		element.click();

	}
}










