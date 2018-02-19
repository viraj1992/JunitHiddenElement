package com.viraj.HiddenElements;

import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

	WebDriver driver;
	String baseUrl1, baseUrl2;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Viraj\\Desktop\\Selenium Drivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl1 = "https://letskodeit.teachable.com/p/practice";
		baseUrl2 = "https://www.expedia.co.in/";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void testLetsKodeIt() throws InterruptedException {
		driver.get(baseUrl1);
		WebElement textBox = driver.findElement(By.id("displayed-text"));
		System.out.println("Text Box Displayed: " + textBox.isDisplayed());

		Thread.sleep(3000);

		WebElement hideButton = driver.findElement(By.id("hide-textbox"));
		hideButton.click();
		System.out.println("Clicked on the hide button");
		System.out.println("Text Box Displayed: " + textBox.isDisplayed());

		Thread.sleep(3000);

		WebElement showButton = driver.findElement(By.id("show-textbox"));
		showButton.click();
		System.out.println("Clicked on the show button");
		System.out.println("Text Box Displayed: " + textBox.isDisplayed());

	}

	@Test
	public void testExpedia() throws InterruptedException {
		driver.get(baseUrl2);
		
		WebElement childDropDown = driver.findElement(By.id("hotel-1-age-select-1"));
		System.out.println("Child Dropdown Displayed: " + childDropDown.isDisplayed());
		Thread.sleep(2000);
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}



}
