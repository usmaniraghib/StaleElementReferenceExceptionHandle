package com.raghib.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaleElement {
	
	public static String url = "https://www.pavantestingtools.com/";
	public static String onlineTrainingHeader = "//a[text()='Online Training']";

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(5000);
		
		WebElement element = driver.findElement(By.xpath(onlineTrainingHeader));
		element.click();
		driver.navigate().back();		
		Thread.sleep(5000);
		
		try {
			element.click();
		} catch(StaleElementReferenceException e) {
			/*
			 * If you uncomment the below line then;
			 * 
			 * Exception in thread "main" org.openqa.selenium.StaleElementReferenceException: stale element reference: stale element not found
			 * 
			 * will gone.
			 * 
			 * */
			
			//element = driver.findElement(By.xpath(onlineTrainingHeader));
			element.click();
		}
		
		driver.quit();

	}

}
