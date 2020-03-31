package com.qa.Util;

import com.crm.qa.TestBase.TestBase;

public class Util extends TestBase{
	public static long PageLoadTime = 1000 ;
	public static long ImplicityTime = 1000;
	
	public void frame() {
		driver.switchTo().frame("mainpanel");
	}

	public static void takeScreenshotAtEndOfTest() {
		// TODO Auto-generated method stub
		
	}

}
