package com.selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BootstrapModal {

	@Test(priority = 1)
	public void singleModal() {

		// Create driver
		System.setProperty("webdriver.edge.driver", "Browsers/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();

		// Navigate to the url
		String url = "https://www.seleniumeasy.com/test/bootstrap-modal-demo.html";
		driver.get(url);

		// Clicks on 'Launch modal' button
		WebElement button1 = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div/div/div[2]/a"));
		button1.click();

		sleep(5000);

		// Clicks on 'Save changes' button
		WebElement saveChanges1 = driver.findElement(By.xpath("//*[@id='myModal0']/div/div/div[4]/a[2]"));
		saveChanges1.click();
		sleep(3000);

		String currentTitle = driver.getCurrentUrl();
		String expectedTitle = "https://www.seleniumeasy.com/test/bootstrap-modal-demo.html";
		Assert.assertEquals(currentTitle, expectedTitle);
		System.out.println("The page refreshed after clicking \'Save changes\' button");

		// Closes the browser
		driver.close();

	}

	@Test(priority = 2)
	public void multipleModal() {

		// Create driver
		System.setProperty("webdriver.chrome.driver", "Browsers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Navigate to the url
		String url = "https://www.seleniumeasy.com/test/bootstrap-modal-demo.html";
		driver.get(url);

		// Clicks on 'Launch modal' button
		WebElement button2 = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div/div[2]/a"));
		button2.click();

		sleep(5000);

		// Clicks on 'Launch modal' button in pop up
		WebElement launchModal = driver.findElement(By.xpath("//*[@id='myModal']/div/div/div[3]/a"));
		launchModal.click();
		sleep(3000);

		// Clicks on 'Save changes' button
		WebElement saveChanges2 = driver.findElement(By.xpath("//*[@id='myModal2']/div/div/div[6]/a[2]"));
		saveChanges2.click();
		sleep(3000);

		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = "https://www.seleniumeasy.com/test/bootstrap-modal-demo.html";
		Assert.assertEquals(currentUrl, expectedUrl);
		System.out.println("The page refreshed after clicking \'Save changes\' button");

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
