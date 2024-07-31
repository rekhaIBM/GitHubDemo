package com.uitest.rmt.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	By userName = By.id("username");
	By pwd = By.id("password");
	By submit = By.cssSelector("login-button bx--btn bx--btn--primary");

	public void userName(String username) {

		driver.findElement(userName).sendKeys(username);

	}

	public void password(String password) {

		driver.findElement(pwd).sendKeys(password);

	}

	public void submitBtn() throws Throwable {

		driver.findElement(submit).click();
		Thread.sleep(3000);

	}

	public String getTitleLandingPage() {
		return driver.getTitle();
	}

}
