package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.TestBase.TestBase;

public class HomePage extends TestBase {
	@FindBy(xpath="//td[contains(text(),'User: Demo User')]")
	WebElement username;
	@FindBy(xpath="//a[@title='Contacts']")
	WebElement contacts;
	@FindBy(xpath="//input[@type='image']")
	WebElement search;
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newcontact;
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean CheckUserName() {
		return username.isDisplayed();
	}
     public ContactPage CreateContact () {
   
    	 return new ContactPage();}
    	 public void CreateContacts () {
        	 contacts.click();
        	 
     }
     
     public SearchPage SearchData() {
    	 search.click();
    	 return new SearchPage();
     }
     public String Title() {
    	 return driver.getTitle();
    	      }
     
     public void Contacts() {
    	 Actions action = new Actions(driver);
    	 action.moveToElement(contacts).build().perform();
    	 newcontact.click();
     }
	}
	
	


