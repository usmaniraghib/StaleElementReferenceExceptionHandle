package com.raghib.selenium;

/**
 * Reference:-
 * https://www.youtube.com/watch?v=m558zwIM-bU
 */

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StaleElement extends BaseClass {

	public static WebDriver driver;
	public static String browserName = "chrome";
	public static String browserVersion = "116";

	public static String url = "https://www.pavantestingtools.com/";
	public static String onlineTrainingHeader = "//a[text()='Online Training']";

	public static void main(String[] args) throws InterruptedException {
		// Chrome Browser
		driver = BaseClass.getDriver(browserName, browserVersion);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get(url);

		Thread.sleep(5000);
		WebElement element = driver.findElement(By.xpath(onlineTrainingHeader));
		element.click();
		driver.navigate().back();
		Thread.sleep(5000);

		try {
			element.click();
		} catch (StaleElementReferenceException e) {
			/*
			 * If you uncomment the below line then;
			 * 
			 * Exception in thread "main"
			 * org.openqa.selenium.StaleElementReferenceException: stale element reference:
			 * stale element not found
			 * 
			 * will gone.
			 * 
			 */

			// element = driver.findElement(By.xpath(onlineTrainingHeader));
			element.click();
		}
		BaseClass.quitDriver();
	}
}