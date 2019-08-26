package com.fca.prod.jeep.testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fca.prod.base.testBase;
import com.fca.prod.jeep.pages.homePage;
import com.fca.prod.jeep.pages.loginPage;

public class loginPageTest extends testBase {
	homePage homepage;
	loginPage loginpage;
	
	public loginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		homepage = new homePage();
		loginpage = homepage.singInLink();
	}
	
	@Test
	public void verifyTitle() {
		loginpage.verifyLoginPageTitle();
	}
	
	@Test
	public void registerNewUser() {
		homepage = loginpage.register();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
