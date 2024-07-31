package com.uitest.rmt.utils;

import org.openqa.selenium.WebDriver;

import com.uitest.rmt.pageObjects.PageObjectManager;

public class TestContextSetup {
	public WebDriver driver;
	public String landingPageProductName;
	public PageObjectManager pageObjectManager;
	public TestBase testBase;
	public Helper helper;
	public DB2Connect db2Connect;
	public GenricUtils genricUtils;
	public ReadFromExcel readFromExcel;
	public TabMenu tabMenu;



	public TestContextSetup() throws Throwable {

		testBase = new TestBase();
		pageObjectManager = new PageObjectManager(testBase.webDriverManager());
		genricUtils = new GenricUtils(testBase.webDriverManager());
		tabMenu = new TabMenu(testBase.webDriverManager());
		helper = new Helper();
		db2Connect = new DB2Connect();
		readFromExcel = new ReadFromExcel();

	}

}