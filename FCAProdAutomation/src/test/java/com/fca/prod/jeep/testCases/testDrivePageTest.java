package com.fca.prod.jeep.testCases;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fca.prod.base.testBase;
import com.fca.prod.jeep.pages.homePage;
import com.fca.prod.jeep.pages.testDrivePage;
import com.fca.prod.util.Utilities;

public class testDrivePageTest extends testBase {

	homePage hPage;
	testDrivePage tDrive;
	Utilities testDriveUtil;

	String TestDrivesheetName = "TestDrive";

	public testDrivePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		testDriveUtil = new Utilities();
		hPage = new homePage();
		tDrive = new testDrivePage();
		tDrive = hPage.testDrivePage();
	}

	@DataProvider
	public Object[][] getTestDriveData() throws InvalidFormatException {
		Object TestDriveData[][] = Utilities.getTestData(TestDrivesheetName);
		return TestDriveData;
	}

	@Test(priority = 1)
	public void testDriveTitle() {
		tDrive.testDriveTitle();
	}

	@Test(priority = 2)
	public void verifyheader() {
		tDrive.HeaderText();
	}

	@Test(priority = 3, dataProvider = "getTestDriveData")
	public void TestRegisterTestDriveDetails(String FirstName, String LastName, String MobileNo, String Email) {
		tDrive.registerTestDrive(FirstName, LastName, MobileNo, Email);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
