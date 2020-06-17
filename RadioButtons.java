package com.selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtons {

	@Test(priority = 1)
	public void singleRadioBtn() {

		// Create driver
		System.setProperty("webdriver.edge.driver", "Browsers/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();

		// Navigate to the url
		String url = "https://www.seleniumeasy.com/test/basic-radiobutton-demo.html";
		driver.get(url);

		sleep(5000);

		// Selects 'Male' radio button and clicks 'Get Checked Value' button
		WebElement male = driver.findElement(By.xpath("//*[@id='easycont']/div/div[2]/div[1]/div[2]/label[1]/input"));
		male.click();
		WebElement button = driver.findElement(By.xpath("//button[@id='buttoncheck']"));
		button.click();

		sleep(5000);

		// Assertion of displayed message
		WebElement msg = driver.findElement(By.className("radiobutton"));
		String actual = msg.getText();
		String expected = "Radio button 'Male' is checked";
		Assert.assertEquals(actual, expected);
		System.out.println("Assertion is successful.\nDisplayed message: " + "\"" + actual + "\"");

		// Closes the browser
		driver.close();

	}

	@Test(priority = 2)
	public void multipleRadioBtn() {

		// Create driver
		System.setProperty("webdriver.chrome.driver", "Browsers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Navigate to the url
		String url = "https://www.seleniumeasy.com/test/basic-radiobutton-demo.html";
		driver.get(url);

		sleep(5000);

		// This will scroll the web page till end.
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		// Selects 'Male', 'Age' and clicks 'Get Values' button
		WebElement male = driver
				.findElement(By.xpath("//*[@id='easycont']/div/div[2]/div[2]/div[2]/div[1]/label[1]/input"));
		male.click();
		WebElement age = driver.findElement(By.xpath("//input[@value='15 - 50']"));
		age.click();
		WebElement button = driver.findElement(By.xpath("//*[@id='easycont']/div/div[2]/div[2]/div[2]/button"));
		button.click();
		
		sleep(5000);

		// Assertion of displayed message
		WebElement msg = driver.findElement(By.xpath("//p[@class='groupradiobutton']"));
		String actual = msg.getText();
		String expected = "Sex : Male\nAge group: 15 - 50";
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
