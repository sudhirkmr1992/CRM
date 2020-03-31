package com.crm.qa.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.qa.Util.Util;
import com.qa.Util.WebEventListener;


public class TestBase {
	public static WebDriver driver;
	public static Properties prop ;
	public static EventFiringWebDriver e_drive;
	public static WebEventListener listener ;
	public TestBase() {
	try {
		prop = new Properties();		 
	FileInputStream  skg = new FileInputStream("D:\\WorkSpace\\CRMPRO\\src\\main\\java\\com\\crm\\qa\\Config\\config.properties");
		prop.load(skg);
		
	}
		 catch(FileNotFoundException e) {
			 e.printStackTrace();
		 }
		 catch(IOException e) {
			 e.printStackTrace();
		 }
	}
	public void ChromeInitialization() {
		String BrowserName = prop.getProperty("Browser");
		if(BrowserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Software\\Selenium\\chromedriver.exe");
			 driver = new ChromeDriver();		    
		}
		else if(BrowserName.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\Software\\Selenium\\geckodriver.exe");
			 driver = new FirefoxDriver();	
		}
		//==== for EventFiringWebDriver initialization  
		e_drive = new EventFiringWebDriver(driver);
		 listener = new WebEventListener();
		 e_drive.register(listener);
		 driver = e_drive;
		 //=========
		driver.manage().window().maximize();
	 driver.manage().deleteAllCookies();
	    driver.manage().timeouts().pageLoadTimeout(Util.PageLoadTime, TimeUnit.SECONDS);
	    driver.manage().timeouts().implicitlyWait(Util.ImplicityTime, TimeUnit.SECONDS);
	    driver.get(prop.getProperty("url"));
	}
	
}
