package com.uitest.rmt.pageObjects;

import org.openqa.selenium.WebDriver;

import com.uitest.rmt.pageObjects.Pool.SearchPoolPage;

import com.uitest.rmt.pageObjects.Territory.SearchTerritoryPage;
import com.uitest.rmt.utils.GenricUtils;
import com.uitest.rmt.utils.Helper;
import com.uitest.rmt.utils.TabMenu;

public class PageObjectManager {

	public LoginPage landginPage;
	public GenricUtils genricUtils;
	public Helper helper;
	public TabMenu tabMenu;

	public WebDriver driver;
	public SearchTerritoryPage searchterritoryPage;
	public SearchPoolPage searchPoolPage;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public LoginPage getLandingPage() {
		landginPage = new LoginPage(driver);
		return landginPage;

	}

	public GenricUtils getGenricUtils() {
		genricUtils = new GenricUtils(driver);
		System.out.println(genricUtils);
		return genricUtils;

	}

	public Helper getHelper() {
		helper = new Helper();
		return helper;

	}

	public TabMenu getTabMenu() {
		tabMenu = new TabMenu(driver);
		return tabMenu;

	}

	public SearchTerritoryPage getSearchTerritoryPage() {
		searchterritoryPage = new SearchTerritoryPage(driver);
		return searchterritoryPage;
	}

	public SearchPoolPage getSearchPoolPage() {

		searchPoolPage = new SearchPoolPage(driver);
		return searchPoolPage;
	}

}
