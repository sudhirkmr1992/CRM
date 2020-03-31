package com.crm.qa.Testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.TestBase.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.qa.Util.Util;

public class ContactPageTest extends TestBase
{
	HomePage hmpage;
	LoginPage page;
	Util util;
	ContactPage contactpage;
public ContactPageTest() {
	super();
}

@BeforeMethod
public void Beforemethod() {
	ChromeInitialization();
	page = new LoginPage();
	hmpage = new HomePage();		
	util = new Util();
	hmpage = page.login(prop.getProperty("UserName"), prop.getProperty("Password"));
	util.frame();
	contactpage =hmpage.CreateContact();
		}

@Test()
public void EntryTest(){
	hmpage.Contacts();
	contactpage.EnterUserDetails("Mr.", "Sudhir", "Kumar", "gunu");
}

@AfterMethod
public void Teardown(){
	
	driver.quit();
}


}
