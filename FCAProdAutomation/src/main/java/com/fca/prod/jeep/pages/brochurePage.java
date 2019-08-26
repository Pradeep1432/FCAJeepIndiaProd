package com.fca.prod.jeep.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;

import com.fca.prod.base.testBase;
import com.fca.prod.util.Utilities;

public class brochurePage extends testBase{
	
	WebDriverWait wait = new WebDriverWait(driver, 30);

	@FindBy(id = "brochureCardCheckbox-0-0|_COMPASS-TRAILHAWK")
	WebElement COMPASSTRAILHAWK;

	@FindBy(id = "brochureCardCheckbox-0-1|_COMPASS")
	WebElement COMPASS;

	@FindBy(id = "brochureCardCheckbox-0-3|_GRAND-CHEROKEE")
	WebElement GRANDCHEROKEE;

	@FindBy(id = "brochureCardCheckbox-0-2|_ALL-NEW-WRANGLER")
	WebElement ALLNEWWRANGLER;

	@FindBy(id = "first_name")
	WebElement firstName;

	@FindBy(id = "last_name")
	WebElement lastName;

	@FindBy(id = "email")
	WebElement emailId;

	@FindBy(id = "phone")
	WebElement mobileNo;

	@FindBy(id = "zip_code")
	WebElement zipcode;

	@FindBy(id = "privacy_checkbox")
	WebElement privacyCheckbox;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement submit;
	
	@FindBy(xpath = "//h2[contains(text(),'THANK YOU. YOUR REQUEST HAS BEEN SENT.')]")
	WebElement successMessage;

	@FindBy(xpath = "//a[text()='RETURN TO HOMEPAGE']")
	WebElement returnToHomePage;

	@FindBy(xpath = "//a[text()='DOWNLOAD']")
	WebElement Download;
	
	public brochurePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void brochureTitle() {
		String Title = driver.getTitle();
		System.out.println("Title is " +Title);
	}
	
	public void createBrochureData(String ft, String lt, String email, String no, String zpcode) {
		ALLNEWWRANGLER.click();
		firstName.sendKeys(ft);
		lastName.sendKeys(lt);
		emailId.sendKeys(email);
		mobileNo.sendKeys(no);
		zipcode.sendKeys(zpcode);
		privacyCheckbox.click();
		submit.click();
		System.out.println("form submitted successfully");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}	
	
	public homePage returnToHomePage() {
		//successMessage.isDisplayed();
		//Download.isDisplayed();
		wait.until(ExpectedConditions.visibilityOf(returnToHomePage));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", returnToHomePage);
		System.out.println("back to homepage");
		//returnToHomePage.click();
		return new homePage();
	}

}
