package com.uitest.rmt.pageObjects.Territory.Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class SearchTerritoryElements {

	public WebDriver driver;

	@FindBy(xpath = "//button[text()='Territory']")
	WebElement territory_tab;
	
	
	@FindBy(xpath = "(//button[@id='downshift-14-toggle-button'])[1]")
	WebElement mandt_dd;
	

	
	@FindBy(xpath = "//input[@title='COVERAGE ID']")
	WebElement coverage_id_text;
	
	
	@FindBy(xpath = "(//input[@id='branchDescLong'])[4]")
	WebElement coverage_id_name_text;
	
	@FindBy(xpath = "(//input[@id='salesVertId'])[2]")
	WebElement exec_name_text;
	
	@FindBy(xpath = "(//input[@id='execName'])[7]")
	WebElement exec_intranet_text;
	
	
	
	@FindBy(xpath = "(//input[@id='execCnum'])[6]")
	WebElement exec_cnum_text;
	@FindBy(xpath = "(//button[@type='submit'][normalize-space()='Search'])[13]")
	WebElement search_btn;

	
	@FindBy(xpath = "//span[@id='ag-1149-row-count' and @ref='lbRecordCount' and @class='ag-paging-row-summary-panel-number' and text()='100']")
	WebElement row_count;
	
	
	

	public WebElement getSearchButton() {
		return search_btn;
	}
		public WebElement getCoverageID() {
		return coverage_id_text;
	}
	public WebElement getCoverageIDName() {
		return coverage_id_name_text;
	}
	
	public WebElement getExecName() {
		return exec_name_text;
	}

	public WebElement getExecIntranetID() {
		return exec_intranet_text;
	}
	public WebElement getExecCnum() {
		return exec_cnum_text;
	}

	public WebElement getTotaRowCount() {
		return row_count;
	}
	public WebElement getCreateMandt(String mandt) {
		mandt_dd.click();
		String mandtElement = "//div[contains(@class, 'bx--list-box__menu-item__option') and contains(text(), '" + mandt +"')]";
		By by_mandt = By.xpath(mandtElement);
		return driver.findElement(by_mandt);
	}
	
	
	
	
	public SearchTerritoryElements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
	}
	
	public WebElement getTerritoryLink() {
		
		return territory_tab;
	}

	
	
	
}
