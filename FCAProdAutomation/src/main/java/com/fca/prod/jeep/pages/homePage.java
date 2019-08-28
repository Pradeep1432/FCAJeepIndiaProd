package com.fca.prod.jeep.pages;

/*author name - pradeep patil
*/
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fca.prod.base.testBase;
import com.fca.prod.util.Utilities;

public class homePage extends testBase {

	// page factory Object repository
	// this will store the element in cache, when this element is interacted elements 
	// will be taken from cache rather then page
	// cacheLookup will increase speed of execution
	// But when page gets refreshed, some of the elements will get corrupted or
	// stale in cache

	WebDriverWait wait = new WebDriverWait(driver, 30);

	@FindBy(id = "signup")
	@CacheLookup
	WebElement LoginButton;

	@FindBy(xpath = "(//img[@src='/content/dam/cross-regional/apac/jeep/en_crossregional/global/header/logo-jeep.png'])[1]")
	WebElement Logo;

	@FindBy(id = "testDrive")
	WebElement TestDrive;

	@FindBy(id = "tollFree:1-800-266-5337")
	WebElement contactNumber;

	@FindBy(id = "shoppingtools")
	WebElement ShoppingTools;

	@FindBy(xpath = "(//a[contains(text(),'Get a Brochure')])[1]")
	WebElement GetABrochure;

	@FindBy(xpath = "//a[@data-lid='brochure']")
	WebElement Brouchure;

	@FindBy(xpath = "//span[contains(text(),'BROCHURE')]")
	WebElement BrouchureLink;

	// initialize all pages objects
	public homePage() {
		PageFactory.initElements(driver, this);
	}

	// actions
	public String verifyTitle() {
		String title = driver.getTitle();
		return title;
	}

	public boolean verifyContactNumber() {
		return contactNumber.isDisplayed();
	}
	
	public void customActions() throws InterruptedException {
		Actions act = new Actions(driver);
		act.doubleClick().build().perform();
		System.out.println("double clicked on element");
		Thread.sleep(5000);
		act.contextClick(contactNumber).perform();
		System.out.println("right clicked on the element");
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement ele = driver.findElement(By.xpath("//source[@srcset='/content/dam/cross-regional/test/jeep/footer/icons/fca-logo-small.png']"));
		js.executeScript("arguments[0].scrollIntoView();", ele);
		System.out.println("scrolled to the mentioned element");
		Select select = new Select(BrouchureLink);
	}

	public boolean JeepLogo() {
		return Logo.isDisplayed();		
	}

	public loginPage singInLink() {
		LoginButton.click();
		return new loginPage();
	}

	public brochurePage brochureLink() {
		wait.until(ExpectedConditions.visibilityOf(BrouchureLink));
		Actions act = new Actions(driver);
		act.moveToElement(BrouchureLink).build().perform();
		System.out.println("moved to brochure element");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", BrouchureLink);
		return new brochurePage();
	}

}
