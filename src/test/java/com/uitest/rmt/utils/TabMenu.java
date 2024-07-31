package com.uitest.rmt.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TabMenu {
	public WebDriver driver;
	public GenricUtils utils = new GenricUtils(driver);

	public TabMenu(WebDriver driver) {
		this.driver = driver;

	}

	By home = By.xpath("(//button[normalize-space()='Home'])[1]");

	By covStructure = By.xpath("(//button[normalize-space()='Cov Structure'])[1]");
	By geography = By.xpath("(//button[normalize-space()='Geography'])[1]");
	By market = By.xpath("(//button[normalize-space()='Market'])[1]");
	By region = By.xpath("(//button[normalize-space()='Region'])[1]");
	By branchGroup = By.xpath("(//button[normalize-space()='Branch Group'])[1]");
	By branch = By.xpath("(//button[normalize-space()='Branch'])[1]");
	By subBranch = By.xpath("(//button[normalize-space()='Sub Branch'])[1]");
	By integrated = By.xpath("(//button[normalize-space()='Integrated (I)'])[1]");
	By cluster = By.xpath("(//button[normalize-space()='Cluster'])[1]");
	By territory = By.xpath("(//button[normalize-space()='Territory'])[1]");
	By pool = By.xpath("(//button[normalize-space()='Pool'])[1]");
	By coverageClientMapping = By.xpath("(//button[normalize-space()='CoverageClient Mapping'])[1]");
	By previewInitialization = By.xpath("(//button[normalize-space()='Preview Initialization'])[1]");

	public void switchToTab(String tabName) {

		switch (tabName) {
		case "GEOGRAPHY":
			driver.findElement(covStructure).click();
			driver.findElement(geography).click();
			break;
		case "MARKET":
			driver.findElement(covStructure).click();
			driver.findElement(market).click();
			break;
		case "REGION":
			driver.findElement(covStructure).click();
			driver.findElement(region).click();
			break;
		case "BRANCH_GROUP":
			driver.findElement(covStructure).click();
			driver.findElement(branchGroup).click();
			break;
		case "BRANCH":
			driver.findElement(covStructure).click();
			driver.findElement(branch).click();
			break;
		case "SUB_BRANCH":
			driver.findElement(covStructure).click();
			driver.findElement(subBranch).click();
			break;
		case "INTEGRATED(I)":
			driver.findElement(covStructure).click();
			driver.findElement(integrated).click();
			break;
		case "CLUSTER":
			driver.findElement(covStructure).click();
			driver.findElement(cluster).click();
			break;
		case "TERRITORY":
			driver.findElement(covStructure).click();
			driver.findElement(territory).click();
			break;
		case "POOL":
			Helper.sleep(5000);
			driver.findElement(covStructure).click();

			utils.scrollToElement(driver, driver.findElement(pool));

			driver.findElement(pool).click();
			break;
		case "COVERAGE_CLIENT_MAPPING":
			driver.findElement(covStructure).click();
			driver.findElement(coverageClientMapping).click();
			break;
		case "PREVIEW_INITIALIZATION":
			driver.findElement(covStructure).click();
			driver.findElement(previewInitialization).click();
			break;

		// default:
		// driver.findElement(home).click();
		}
	}
}