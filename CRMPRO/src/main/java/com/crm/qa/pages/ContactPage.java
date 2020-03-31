package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.TestBase.TestBase;

public class ContactPage extends TestBase {
	@FindBy(xpath="//select[@name='title']")
	WebElement Title;
    @FindBy(xpath="//input[@name='first_name']")
    WebElement firstname ;
    @FindBy(xpath="//input[@name='surname']")
    WebElement lastname ;
    @FindBy(xpath="//input[@name='nickname']")
    WebElement nickname ;
    @FindBy(xpath="//input[@value='Load From Company']/following-sibling::input[1]")
    WebElement button; 
    
    public ContactPage() {
    	PageFactory.initElements(driver, this);
    }
    
    public void EnterUserDetails(String title,String Firstname,String Lastname,String Nickname) {
    	Select select = new Select(Title);
    	select.selectByVisibleText(title);
    	firstname.sendKeys(Firstname);
    	lastname.sendKeys(Lastname);
    	nickname.sendKeys(Nickname);
    	button.click();
    	
    }
}
