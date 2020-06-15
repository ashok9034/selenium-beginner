package com.selenium.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InvalidLoginTestAssertion {

	@Test(priority = 2)
	public void invalidPasswordAssertion() {

		// Create driver
		System.setProperty("webdriver.chrome.driver", "Browsers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Navigate to the url
		String url = "http://the-internet.herokuapp.com/login";
		driver.get(url);

		// Username locator
		WebElement userName = driver.findElement(By.id("username"));
		userName.sendKeys("tomsmith");

		// Password locator
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("incorrectPassword");

		// Login button locator
		WebElement login = driver.findElement(By.className("radius"));
		login.click();

		// Implicit wait makes the browser to wait till the page is loaded
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// Login success message locator
		WebElement message = driver.findElement(By.id("flash"));
		String actualMsg = message.getText();
		String expectedMsg = "Your password is invalid!\n×";
		Assert.assertEquals(actualMsg, expectedMsg);
		System.out.println("Assertion is successful");

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// Closes the browser
		driver.quit();

	}

	@Test(priority = 1)
	public void invalidUsernameAssertion() {

		// Create driver
		System.setProperty("webdriver.chrome.driver", "Browsers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Navigate to the url
		String url = "http://the-internet.herokuapp.com/login";
		driver.get(url);

		// Username locator
		WebElement userName = driver.findElement(By.id("username"));
		userName.sendKeys("invalidUsername");

		// Password locator
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("SuperSecretPassword!");

		// Login button locator
		WebElement login = driver.findElement(By.className("radius"));
		login.click();

		// Implicit wait makes the browser to wait till the page is loaded
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// Login success message locator
		WebElement message = driver.findElement(By.id("flash"));
		String actualMsg = message.getText();
		String expectedMsg = "Your username is invalid!\n×";
		Assert.assertEquals(actualMsg, expectedMsg);
		System.out.println("Assertion is successful");

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// Closes the browser
		driver.quit();

	}

}
