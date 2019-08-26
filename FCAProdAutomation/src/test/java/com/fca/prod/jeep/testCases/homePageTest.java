package com.fca.prod.jeep.testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fca.prod.base.testBase;
import com.fca.prod.jeep.pages.homePage;
import com.fca.prod.jeep.pages.loginPage;

public class homePageTest extends testBase {
	homePage homepage;
	loginPage loginpage;

	// super keyword will initiate the base class constructor
	public homePageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		System.out.println("browser is launched and user is on jeep application");
	}

	@Test(priority = 1)
	public void verifyHomePageTitle() {
		homepage = new homePage();
		homepage.verifyTitle();
	}

	@Test(priority = 2)
	public void verifyJeepLogo() {
		homepage.JeepLogo();
	}

	@Test(priority = 3)
	public void signInLink() {
		loginpage = new loginPage();
		homepage = new homePage();
		loginpage = homepage.singInLink();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
