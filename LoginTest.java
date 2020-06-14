package com.selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginTest {
	
	    @Test
		public void loginTest() {
		
		//Create driver
		System.setProperty("webdriver.chrome.driver", "Browsers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//Navigate to the url
		String url = "http://the-internet.herokuapp.com/login";
		driver.get(url);
		
		//Username locator
		WebElement userName = driver.findElement(By.id("username"));
		userName.sendKeys("tomsmith");
		
		//Password locator
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("SuperSecretPassword!");
		
		//Login button locator
		WebElement login = driver.findElement(By.className("radius"));
		login.click();
		
		//Closes the browser
		driver.quit();
				
	}

}
