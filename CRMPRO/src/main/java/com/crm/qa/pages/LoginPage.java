package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.TestBase.TestBase;

public class LoginPage extends TestBase {
	@FindBy(xpath="//input[@name='username']")
	WebElement username ;
	@FindBy(xpath="//input[@name='password']")
	WebElement password ;
	@FindBy(xpath="//input[@type='submit']")
	WebElement buttonlogin ;
	@FindBy(xpath="//a[@class='navbar-brand']/img")
	WebElement logo;
	@FindBy(xpath="//a[text()=\"Sign Up\"]")
	WebElement signup;
	
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public HomePage login(String user ,String pswd) {
		username.sendKeys(user);
		password.sendKeys(pswd);
		buttonlogin.click();
		return new HomePage();
	}
	
	public boolean CrmLogo() {
		return logo.isDisplayed();
	}
	
	public void Signup() {
		signup.click();
	}
	public String Title() {
		return driver.getTitle();
	}
}
