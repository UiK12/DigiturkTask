package com.umitkaya.BaseClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class BaseTest {
	
public WebDriver driver;
	
	@BeforeClass
	public void start() {
		//ChromeDriver path'i kendi cihazýma göre ayarladým. Çalýþtýrýlacak cihazlarda driverýn olduðu path'e göre deðiþtirilmeli.
		System.setProperty("webdriver.chrome.driver","C:\\Users\\uik12\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@AfterTest
	public void end(){ 
	    //Close driver
		driver.quit();
	}
}
