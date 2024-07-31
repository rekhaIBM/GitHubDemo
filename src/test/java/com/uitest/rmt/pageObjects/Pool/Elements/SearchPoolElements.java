package com.uitest.rmt.pageObjects.Pool.Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class SearchPoolElements {
	public WebDriver driver;

	@FindBy(xpath = "(//button[@id='downshift-16-toggle-button'])[1]")
	WebElement mandt_dd;
	
	public SearchPoolElements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
	}

	public WebElement getCreateMandt(String mandt) {
		mandt_dd.click();
		String mandtElement = "//div[contains(@class, 'bx--list-box__menu-item__option') and contains(text(), '"+mandt+"')]";
		By by_mandt = By.xpath(mandtElement);
		return driver.findElement(by_mandt);
	}
}