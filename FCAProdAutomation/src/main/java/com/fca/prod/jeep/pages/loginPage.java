package com.fca.prod.jeep.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fca.prod.base.testBase;


public class loginPage extends testBase {

	@FindBy(xpath = "//h2[text()='SIGN UP FOR UPDATES']")
	WebElement LoginInHeader;

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

	@FindBy(id = "first_name")
	WebElement firstName;

	@FindBy(id = "last_name")
	WebElement lastName;

	@FindBy(id = "email")
	WebElement email;

	@FindBy(id = "confirm_email")
	WebElement confirmEmail;

	@FindBy(id = "city")
	WebElement city;

	@FindBy(id = "zip_code")
	WebElement zipCode;

	@FindBy(id = "privacy_checkbox")
	WebElement privacyCheckbox;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement submit;

	@FindBy(xpath = "//a[@data-lid='home_page']")
	WebElement returnToHomepage;

	public loginPage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean verifyLoginHeader() {
		return LoginInHeader.isDisplayed();
	}

	public homePage register() {
		GrandCherokee.click();
		firstName.sendKeys("peter");
		lastName.sendKeys("parker");
		email.sendKeys("peter.parker@test.com");
		confirmEmail.sendKeys("peter.parker@test.com");
		city.sendKeys("New York");
		zipCode.sendKeys("100038");
		privacyCheckbox.click();
		submit.click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		returnToHomepage.click();

		return new homePage();
	}

}
