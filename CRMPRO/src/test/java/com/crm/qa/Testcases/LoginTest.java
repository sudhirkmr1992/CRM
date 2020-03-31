package com.crm.qa.Testcases;



import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.TestBase.TestBase;
import com.crm.qa.pages.LoginPage;

public class LoginTest extends TestBase {
	LoginPage page;
	// for log4j 
	Logger log = Logger.getLogger(LoginTest.class);
	public LoginTest() {
		super();
	}
	
	@BeforeMethod
	public  void Initialization(){
		ChromeInitialization();
		page = new LoginPage();
		log.info("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			}
	@Test()
	public void Title() throws InterruptedException{
		String title =page.Title();
		Thread.sleep(2000);
		System.out.println(title);
		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}
	@Test(priority =1)
	public void LogoTest(){
		Assert.assertTrue(page.CrmLogo(), "logo missing");
	}
	@Test(priority =3)
	public void Login(){
		page.login(prop.getProperty("UserName"), prop.getProperty("Password"));

	}
	@Test(priority =2)
	public void Signup() {
		page.Signup();
	}
	@AfterMethod
	  public void tearDown() {
		  driver.quit();
	  }

}
