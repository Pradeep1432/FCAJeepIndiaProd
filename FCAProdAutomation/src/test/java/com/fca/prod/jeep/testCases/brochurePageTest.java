package com.fca.prod.jeep.testCases;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fca.prod.base.testBase;
import com.fca.prod.jeep.pages.brochurePage;
import com.fca.prod.jeep.pages.homePage;
import com.fca.prod.util.Utilities;

public class brochurePageTest extends testBase {
	
	Utilities testUtil;
	homePage homepage;
	brochurePage brochure;
	
	String JeepSheetName = "Brochure";
	
	public brochurePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new Utilities();
		homepage = new homePage();
		brochure = new brochurePage();
		brochure = homepage.brochureLink();
	}
	
	@DataProvider
	public Object[][] getJeepTestData() throws InvalidFormatException {
		Object data[][] = Utilities.getTestData(JeepSheetName);
		return data;
	}
	
	/*
	 * @Test(priority = 1) public void verifyBrochureTitle() {
	 * brochure.brochureTitle(); }
	 */
	
	@Test(priority = 2, dataProvider="getJeepTestData")
	public void verifyBrochureDetails(String FirstName, String LastName, String Email, String MobileNo, String ZipCode) {
		brochure.createBrochureData(FirstName, LastName, Email, MobileNo, ZipCode);
	}
	
	/*
	 * @Test(priority=3) public void returnToHomepage() {
	 * brochure.returnToHomePage(); System.out.println("back to homepage"); }
	 */
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	
	

}
