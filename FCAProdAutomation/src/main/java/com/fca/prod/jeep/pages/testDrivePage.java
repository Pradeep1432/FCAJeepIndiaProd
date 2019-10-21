package com.fca.prod.jeep.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.fca.prod.base.testBase;

public class testDrivePage extends testBase{
	
	@FindBy(xpath="//h2[text()='SCHEDULE A TEST DRIVE']")
	WebElement HeaderText;
	
	@FindBy(id = "brochureCardCheckbox-0-0|_COMPASS-TRAILHAWK")
	WebElement COMPASSTRAILHAWK;

	@FindBy(id = "brochureCardCheckbox-0-1|_compass")
	WebElement COMPASS;

	@FindBy(id = "brochureCardCheckbox-0-2|_ALL-NEW-WRANGLER")
	WebElement NewWrangler;

	@FindBy(id = "brochureCardCheckbox-0-3|_grand-cherokee")
	WebElement GrandCherokee;

	@FindBy(id = "brochureCardCheckbox-0-4|_grand-cherokee-srt")
	WebElement GrandCherokeeSrt;
	
	@FindBy(id="first_name")
	WebElement Firstname;
	
	@FindBy(id="last_name")
	WebElement LastName;
	
	@FindBy(id="phone")
	WebElement PhoneNo;
	
	@FindBy(id="email")
	WebElement Email;
	
	@FindBy(id="city")
	WebElement City;
	
	@FindBy(id="privacy_checkbox")
	WebElement privacyCheckbox;
	
	@FindBy(xpath="//input[@value='Submit']")
	WebElement submitBtn;
	
	public testDrivePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void testDriveTitle() {
		String title = driver.getTitle();
		System.out.println("Page title is" +title);
	}
	
	public boolean HeaderText() {
		boolean header = HeaderText.isDisplayed();
		return header;
	}
	
	public void registerTestDrive(String FN, String LN, String PNo, String emailId) {
		COMPASS.click();
		Firstname.sendKeys(FN);
		LastName.sendKeys(LN);
		PhoneNo.sendKeys(PNo);
		Email.sendKeys(emailId);
		Actions act = new Actions(driver);
		act.moveToElement(City).moveToElement(City).perform();
		Select select = new Select(City);
		select.selectByIndex(1);
		privacyCheckbox.click();		
	}
	
	public homePage returnToHomepage() {
		submitBtn.click();
		return new homePage();
	}
	

}
