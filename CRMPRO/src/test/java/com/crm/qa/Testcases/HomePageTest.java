package com.crm.qa.Testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.TestBase.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.qa.Util.Util;

public class HomePageTest  extends TestBase {
	HomePage hmpage;
	LoginPage page;
	Util util;
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void Beforemethod() {
		ChromeInitialization();
		page = new LoginPage();
		hmpage = new HomePage();		
		util = new Util();
		hmpage = page.login(prop.getProperty("UserName"), prop.getProperty("Password"));
			}
	
	@Test(priority =1)
	public void Title(){
		String s = hmpage.Title();
		System.out.println(s);
		Assert.assertEquals(s, "CRMPRO");
	}
	@Test(priority =2)
	public void UserName() {
		util.frame();
		boolean b = hmpage.CheckUserName();
		
		Assert.assertTrue(b, "correct username");
		
	}
	
	@Test(priority =4)
	public void Account() {
	util.frame();
		hmpage.CreateContacts();
		
	}
	@Test(priority =3)
	public void Search() {
		util.frame();
		hmpage.SearchData();
		
		
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
