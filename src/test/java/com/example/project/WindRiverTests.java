/*
 * Copyright 2015-2021 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */

package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

class WindRiverTests {

	@Test
	public void eightComponents() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.windriver.com/contact#sales-inquiries");


		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement accept_cookies_btn = driver.findElement(By.className("trustarc-primary-btn"));

		if(accept_cookies_btn != null){
			accept_cookies_btn.click();
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		}

		WebElement first_name_input = driver.findElement(By.id("FirstName"));
		WebElement last_name_input = driver.findElement(By.id("LastName"));
		WebElement email_input = driver.findElement(By.id("Email"));
		WebElement company_input = driver.findElement(By.id("Company"));
		WebElement phone_number_input = driver.findElement(By.id("Phone"));

		Select industry_select = new Select(driver.findElement(By.id("Industry")));
		Select product_select = new Select(driver.findElement(By.id("Product_Interested_in_Learning_About__c")));
		Select country_select = new Select(driver.findElement(By.id("Country")));
		WebElement comments_text_area = driver.findElement(By.id("Comments"));
		WebElement submit_btn = driver.findElement(By.id("mktoButton"));


		first_name_input.sendKeys("Kevin");
		last_name_input.sendKeys("Ordonez");
		email_input.sendKeys("kevin.ordonez@tek-experts.com");
		company_input.sendKeys("Tek-Experts");
		phone_number_input.sendKeys("50686823064");


		industry_select.selectByVisibleText(("Meical"));
		product_select.selectByVisibleText(("Other"));
		country_select.selectByVisibleText(("Costa Rica"));
		comments_text_area.sendKeys("You won't regret hiring me");
		submit_btn.click();
		driver.quit();
	}
}
