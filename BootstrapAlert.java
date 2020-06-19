package com.selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BootstrapAlert {

	static WebDriver driver;

	@Test
	public void bootstrapAlert() {

		// Create driver
		System.setProperty("webdriver.chrome.driver", "Browsers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Navigate to the url
		String url = "https://www.seleniumeasy.com/test/bootstrap-alert-messages-demo.html";
		driver.get(url);

		// 'Autocloseable success message' button
		WebElement autoCloseSuccessBtn = driver.findElement(By.id("autoclosable-btn-success"));
		autoCloseSuccessBtn.click();
		WebElement autoCloseSuccessMsg = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[1]"));
		Assert.assertTrue(autoCloseSuccessMsg.isDisplayed());
		System.out.println("Autocloseable success message is displayed");
		sleep(6000);

		// 'Normal success message' button
		WebElement normalSuccessBtn = driver.findElement(By.id("normal-btn-success"));
		normalSuccessBtn.click();
		sleep(3000);
		WebElement normalSuccessMsg = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[2]"));
		Assert.assertTrue(normalSuccessMsg.isDisplayed());
		System.out.println("Normal success message is displayed");
		WebElement close = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[2]/button"));
		close.click();

		// 'Autocloseable warning message' button
		WebElement autoCloseWarningBtn = driver.findElement(By.id("autoclosable-btn-warning"));
		autoCloseWarningBtn.click();
		WebElement autoCloseWarningMsg = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[3]"));
		Assert.assertTrue(autoCloseWarningMsg.isDisplayed());
		System.out.println("Autocloseable warning message is displayed");
		sleep(4000);

		// 'Normal warning message' button
		WebElement normalWarningBtn = driver.findElement(By.id("normal-btn-warning"));
		normalWarningBtn.click();
		sleep(3000);
		WebElement normalWarningMsg = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[4]"));
		Assert.assertTrue(normalWarningMsg.isDisplayed());
		System.out.println("Normal warning message is displayed");
		WebElement close1 = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[4]/button"));
		close1.click();

		// 'Autocloseable danger message' button
		WebElement autoCloseDangerBtn = driver.findElement(By.id("autoclosable-btn-danger"));
		autoCloseDangerBtn.click();
		WebElement autoCloseDangerMsg = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[5]"));
		Assert.assertTrue(autoCloseDangerMsg.isDisplayed());
		System.out.println("Autocloseable danger message is displayed");
		sleep(6000);

		// 'Normal danger message' button
		WebElement normalDangerBtn = driver.findElement(By.id("normal-btn-danger"));
		normalDangerBtn.click();
		sleep(3000);
		WebElement normalDangerMsg = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[6]"));
		Assert.assertTrue(normalDangerMsg.isDisplayed());
		System.out.println("Normal danger message is displayed");
		WebElement close2 = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[6]/button"));
		close2.click();

		// 'Autocloseable info message' button
		WebElement autoCloseInfoBtn = driver.findElement(By.id("autoclosable-btn-info"));
		autoCloseInfoBtn.click();
		WebElement autoCloseInfoMsg = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[7]"));
		Assert.assertTrue(autoCloseInfoMsg.isDisplayed());
		System.out.println("Autocloseable info message is displayed");
		sleep(7000);

		// 'Normal info message' button
		WebElement normalInfoBtn = driver.findElement(By.id("normal-btn-info"));
		normalInfoBtn.click();
		sleep(3000);
		WebElement normalInfoMsg = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[8]"));
		Assert.assertTrue(normalInfoMsg.isDisplayed());
		System.out.println("Normal info message is displayed");

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
