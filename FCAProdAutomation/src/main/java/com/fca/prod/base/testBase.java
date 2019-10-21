package com.fca.prod.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.EventListener;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.fca.prod.util.WebEventListener;

public class testBase {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	

	public testBase() {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(
					"C:\\Users\\prapatil0\\eclipse-workspace\\FCAProdAutomation\\src\\main\\java\\com\\fca\\prod\\config\\config.properties");
			prop.load(fis);
		} catch (IOException e) {
			e.getMessage();
		}
	}

	public static void initialization() {
		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C://Selenium/SeleniumDrivers/chromedriver/chromedriver.exe");
			driver = new ChromeDriver();
		}

		// create object of eventfiringwebdriver class and pass our driver
		e_driver = new EventFiringWebDriver(driver);
		// now create object of WebEventListener class
		eventListener = new WebEventListener();
		// now we need to register eventlistener class object with eventfiringwebdriver
		// class object
		e_driver.register(eventListener);
		driver = e_driver;

		driver.manage().window().maximize();
		System.out.println("chrome launched");
		driver.get(prop.getProperty("url"));
		System.out.println("url launched");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


	}

}
