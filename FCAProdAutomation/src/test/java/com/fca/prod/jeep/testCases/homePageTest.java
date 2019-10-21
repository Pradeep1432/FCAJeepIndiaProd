package com.fca.prod.jeep.testCases;

import org.testng.Assert;
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
		loginpage = new loginPage();
		homepage = new homePage();
	}

	@Test
	public void totalLinks() {
		homepage.NoOfLinks();
	}

	@Test(priority = 1)
	public void verifyHomePageTitle() {
		homepage = new homePage();
		String homePageTitle = homepage.verifyTitle();
		Assert.assertEquals("Jeep® India Official Website - SUVs &amp; Crossovers In India", homePageTitle);
	}

	@Test(priority = 2) public void verifyJeepLogo() throws InterruptedException
	  { homepage.JeepLogo(); //homepage.customActions(); homepage.getText(); 
	  
	  }

	@Test(priority = 3)
	public void signInLink() {
		loginpage = homepage.singInLink();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
