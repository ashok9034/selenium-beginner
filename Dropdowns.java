package com.selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Dropdowns {

	@Test(priority = 1)
	public void dropdown() {

		// Create driver
		System.setProperty("webdriver.edge.driver", "Browsers/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();

		// Navigate to the url
		String url = "https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html";
		driver.get(url);

		sleep(5000);

		// Selecting option from dropdown
		Select dropdown = new Select(driver.findElement(By.id("select-demo")));
		dropdown.selectByVisibleText("Sunday");

		sleep(5000);

		// Assertion of displayed message
		WebElement msg = driver.findElement(By.className("selected-value"));
		String actual = msg.getText();
		String expected = "Day selected :- Sunday";
		Assert.assertEquals(actual, expected);
		System.out.println("Assertion is succesful.\nDisplayed message: " + "\"" + actual + "\"");

		// Closes the browser
		driver.close();

	}

	@Test(priority = 2)
	public void multipleDropdown() {

		// Create driver
		System.setProperty("webdriver.chrome.driver", "Browsers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Navigate to the url
		String url = "https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html";
		driver.get(url);

		sleep(5000);

		// This will scroll the web page till end.
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,500);");

		sleep(3000);

		// Selectind options from list
		Select dropdown = new Select(driver.findElement(By.id("multi-select")));
		dropdown.selectByVisibleText("New York");
		dropdown.selectByVisibleText("Ohio");

		// Clicks button
		WebElement button = driver.findElement(By.id("printMe"));
		button.click();

		sleep(5000);

		// Assertion of displayed message
		WebElement msg = driver.findElement(By.className("getall-selected"));
		String actual = msg.getText();
		String expected = "First selected option is : Ohio";
		Assert.assertEquals(actual, expected);
		System.out.println("Assertion is successful.\nDisplayed message: " + "\"" + actual + "\"");

		// Closes the browser
		driver.close();
	}

	public void sleep(int s) {

		try {
			Thread.sleep(s);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
