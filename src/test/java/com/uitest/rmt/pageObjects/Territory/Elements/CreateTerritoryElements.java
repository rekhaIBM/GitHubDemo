package com.uitest.rmt.pageObjects.Territory.Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class CreateTerritoryElements {

	public WebDriver driver;

	@FindBy(xpath = "//button[text()='Territory']")
	WebElement territory_tab;

	@FindBy(xpath = "(//button[@type='submit'][normalize-space()='Add'])[17]")
	WebElement add_btn;

	@FindBy(xpath = "//button[@id='downshift-75-toggle-button'])[1]")
	WebElement mandt_dd;

	public CreateTerritoryElements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
	}

	public WebElement getTerritoryLink() {

		return territory_tab;
	}

	public WebElement getAddBtn() {
		return add_btn;
	}

	public WebElement getCreateMandt(String mandt) {
		mandt_dd.click();
		String mandtElement = "//div[contains(@class, 'bx--list-box__menu-item__option') and contains(text(), '" + mandt +"')]";
		By by_mandt = By.xpath(mandtElement);
		return driver.findElement(by_mandt);
	}

	}
