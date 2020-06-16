package com.selenium.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FormFilling {

	@Test
	public void formFilling() {

		// Create driver
		System.setProperty("webdriver.edge.driver", "Browsers/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();

		// Navigate to the url
		String url = "https://www.seleniumeasy.com/test/basic-first-form-demo.html";
		driver.get(url);

		// Textbox locator
		WebElement textbox = driver.findElement(By.id("user-message"));
		textbox.sendKeys("My message");

		// 'Show Message' button locator
		WebElement button = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div[2]/form/button"));
		button.click();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// 'Your Message' locator
		WebElement message = driver.findElement(By.id("display"));
		String expectedMsg = message.getText();
		String actualMsg = "My message";
		Assert.assertEquals(actualMsg, expectedMsg);
		System.out.println("Assertion is successful");

		// Closes the browser
		driver.close();
	}

	@Test
	public void formWithTwoInputs() {

		// Create driver
		System.setProperty("webdriver.chrome.driver", "Browsers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Navigate to the url
		String url = "https://www.seleniumeasy.com/test/basic-first-form-demo.html";
		driver.get(url);

		// Locators for textboxes
		WebElement text1 = driver.findElement(By.id("sum1"));
		text1.sendKeys("1");
		WebElement text2 = driver.findElement(By.id("sum2"));
		text2.sendKeys("2");

		// Button locator
		WebElement totalBtn = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[2]/form/button"));
		totalBtn.click();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// 'Get Total' Locator
		WebElement sumMsg = driver.findElement(By.id("displayvalue"));
		String expectedMsg = sumMsg.getText();
		String actualMsg = "3";
		Assert.assertEquals(actualMsg, expectedMsg);
		System.out.println("Assertion is successful");

		// Closes the browser
		driver.close();
	}

}
