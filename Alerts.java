package com.selenium.test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Alerts {

	@Test
	public void alertBox() {

		// Create driver
		System.setProperty("webdriver.chrome.driver", "Browsers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Navigate to the url
		String url = "https://www.seleniumeasy.com/test/javascript-alert-box-demo.html";
		driver.get(url);

		sleep(5000);

		// Accepts the alert message by clicking 'OK'
		WebElement button = driver.findElement(By.xpath("//*[@id='easycont']/div/div[2]/div[1]/div[2]/button"));
		button.click();
		sleep(3000);
		driver.switchTo().alert().accept();

		// To scroll the webpage
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,300);");

		// Declines the alert message by clicking 'Cancel'
		WebElement button1 = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[2]/button"));
		button1.click();
		sleep(3000);
		driver.switchTo().alert().dismiss();

		// Assertion of displayed message
		WebElement msg = driver.findElement(By.id("confirm-demo"));
		String actual = msg.getText();
		String expected = "You pressed Cancel!";
		Assert.assertEquals(actual, expected);
		System.out.println("Assertion is successful.\nDisplayed message: " + "\"" + actual + "\"");

		// To scroll the webpage
		js.executeScript("scroll(0,500);");

		// Enters 'Selenium' in alert text box and clicks 'OK'
		WebElement button2 = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[3]/div[2]/button"));
		button2.click();
		sleep(3000);
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Selenium");
		alert.accept();
		sleep(3000);

		// Assertion of displayed message
		WebElement msg1 = driver.findElement(By.id("prompt-demo"));
		String actualMsg = msg1.getText();
		String expectedMsg = "You have entered 'Selenium' !";
		Assert.assertEquals(actualMsg, expectedMsg);
		System.out.println("Assertion is successful.\nDisplayed message: " + "\"" + actualMsg + "\"");

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
