package com.hrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.hrm.qa.base.TestBase;


public class HomePage extends TestBase {


	//Page facotry OR:

	@FindBy(xpath ="//*[@id='menu_pim_viewPimModule']")
	WebElement PIM;

	@FindBy(xpath ="//*[@id='menu_dashboard_index']")
	WebElement Dashboard;

	@FindBy(xpath ="//*[@id='btnAdd']")
	WebElement AddBtn;

	@FindBy(xpath ="//*[@id='firstName']")
	WebElement firstname;

	@FindBy(xpath ="//*[@id='lastName']")
	WebElement lastname;

	@FindBy(xpath ="//*[@id='photofile']")
	WebElement photofile;

	@FindBy(xpath ="//*[@id='btnSave']")
	WebElement SaveBtn;

	@FindBy(xpath ="//*[@id='empsearch_employee_name_empName']")
	WebElement employeename;

	@FindBy(xpath ="//*[@id='searchBtn']")
	WebElement searchBtn;

	@FindBy(xpath ="//*[@id=\"resultTable\"]/tbody/tr/td[3]/a")
	WebElement employeefirstname;

	@FindBy(xpath ="//*[@id=\"resultTable\"]/tbody/tr/td[4]/a")
	WebElement employeelastname;


	public HomePage(){

		PageFactory.initElements(driver, this);
	}


	//Actions:

	public void addNewEmployee(String first , String last, String Picture) {
		try {
			Clickon(driver, PIM);
			Clickon(driver, AddBtn);
			Sendkeys(driver, firstname, first);
			Sendkeys(driver, lastname, last);
			Sendkeys(driver, photofile, Picture );
			Clickon(driver, SaveBtn);
		}

		catch(Exception e) {
			e.printStackTrace();
		}
	}


	public boolean searchEmployee(String expectedFirst, String expectedLast) {

		String actualFirstname;
		String actualLastname;
		boolean flag = false;



		try{
			Clickon(driver, PIM);
			Sendkeys(driver, employeename, expectedFirst + " " + expectedLast);
			Clickon(driver, searchBtn);
			actualFirstname = employeefirstname.getText();
			actualLastname = employeelastname.getText();
			System.out.println(actualFirstname);
			System.out.println(actualLastname);

			if(actualFirstname.equals(expectedFirst) && actualLastname.equals(expectedLast)){

				return true;
			}

			else {
				return false; 
			}	
		}

		catch(Exception e) {

			e.printStackTrace();
		}

		return flag;
	}
}















