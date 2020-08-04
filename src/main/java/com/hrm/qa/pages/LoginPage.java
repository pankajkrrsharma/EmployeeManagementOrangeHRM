package com.hrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.hrm.qa.base.TestBase;


public class LoginPage extends TestBase {

	//Page facotry OR:
	
	@FindBy(id="txtUsername")
	WebElement username;

	@FindBy(id="txtPassword")
	WebElement password;

	@FindBy(id = "btnLogin" )
	WebElement LoginBtn;

	@FindBy(xpath ="//*[@id='menu_dashboard_index']")
	WebElement Dashboard;
	


	public LoginPage(){
		PageFactory.initElements(driver, this);
	}

	
	//Actions:
	public String login(String un, String pwd) {

		Sendkeys(driver, username, un);
		Sendkeys(driver, password, pwd);
		Clickon(driver, LoginBtn);
		return driver.getCurrentUrl();

	}
}







