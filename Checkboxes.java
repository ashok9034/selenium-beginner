package com.selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Checkboxes {

	@Test(priority = 1)
	public void singleCheckbox() {

		// Create driver
		System.setProperty("webdriver.edge.driver", "Browsers/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();

		// Navigate to the url
		String url = "https://www.seleniumeasy.com/test/basic-checkbox-demo.html";
		driver.get(url);

		sleep(5000);

		// Select the checkbox
		WebElement check = driver.findElement(By.xpath("//input[@id = 'isAgeSelected']"));
		check.click();

		sleep(5000);

		// Assertion of displayed message
		WebElement msg = driver.findElement(By.xpath("//div[@id='txtAge']"));
		String expected = msg.getText();
		String actual = "Success - Check box is checked";
		Assert.assertEquals(actual, expected);
		System.out.println("Assertion is successful.\nThe message displayed is: " + "\"" + msg.getText() + "\"");

		// Closes the browser
		driver.close();

	}

	@Test(priority = 2)
	public void multipleCheckbox() {

		// Create driver
		System.setProperty("webdriver.chrome.driver", "Browsers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Navigate to the url
		String url = "https://www.seleniumeasy.com/test/basic-checkbox-demo.html";
		driver.get(url);

		sleep(5000);

		WebElement checkAll = driver.findElement(By.xpath("//input[@id = 'check1']"));
		checkAll.click();

		sleep(5000);

		boolean expected = checkAll.isSelected();
		System.out.println("Check All is selected.");

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
