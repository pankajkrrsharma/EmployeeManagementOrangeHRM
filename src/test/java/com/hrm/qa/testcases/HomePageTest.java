package com.hrm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrm.qa.base.TestBase;
import com.hrm.qa.pages.HomePage;
import com.hrm.qa.pages.LoginPage;
import com.hrm.qa.util.TestUtil;



public class HomePageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	
	
	public HomePageTest() {
		super();
	
	}
	
	@BeforeMethod
	public void setup()  {
		
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage(); 
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority =1 , description = "Add new employee")
	public void addNewEmployeeTest() {
		
		homePage.addNewEmployee(prop.getProperty("firstname"),prop.getProperty("lastname") , PicturePath);
		
	}
	
	@Test(priority =2, description = "Validating search Employee", dependsOnMethods = "addNewEmployeeTest")
	public void searchEmployeeTest() {
		
		Assert.assertTrue(homePage.searchEmployee(prop.getProperty("firstname"),prop.getProperty("lastname")));
		
		}
	@AfterMethod
	public void tearDown() {
		
   
	}

}
