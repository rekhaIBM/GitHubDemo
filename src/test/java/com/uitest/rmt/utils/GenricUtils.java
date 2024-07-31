package com.uitest.rmt.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;

public class GenricUtils {

	// private static final Logger logger = LogManager.getLogger(GenricUtils.class);
	public WebDriver driver;
	public DB2Connect db2Connect;
	By userName = By.id("user");
	By pwd = By.id("password");
	By submit = By.cssSelector("button.ibm-btn-pri.ibm-btn-blue-50");

	public GenricUtils(WebDriver driver) {

		this.driver = driver;

	}

	// this will handle the multiple frame
	public void switchWindowToChild() {

		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> i1 = s1.iterator();
//		String parentWindow = i1.next();
		String childWindow = i1.next();
		driver.switchTo().window(childWindow);
	}

	// this method is for select the dropdown randomly
	public void selectDropdownRandomly(WebElement dropdown) {

		Select select = new Select(dropdown);
		// get the list of option
		Helper.sleep(2000);
		List<WebElement> options = select.getOptions();
		Helper.sleep(2000);
		// generate the random index within the range of the number of Options
		Random random = new Random();
		Helper.sleep(2000);
		int randomIndex = random.nextInt(options.size());
		Helper.sleep(2000);

		// int size = options.size();

//		// print the options of Drop down
//		for (int i = 0; i < size; i++) {
//			String optionss = options.get(i).getText();
//			Helper.sleep(2000);
//		}

		// Select the option at the generated index
		select.selectByIndex(randomIndex);

	}

	// this method is for select the dropdown by giving the String
	public void selectDropdownByGivenString(WebElement dropdown, String input) {
//		Helper.sleep(3000);
		Select select = new Select(dropdown);
		Helper.sleep(3000);
		// Select the option at the generated index
		select.selectByValue(input);

	}

	// this methos is to get the test from the selected dropdown option
	public void getDropdownOptionText(WebElement dropdown) {
		Helper.sleep(3000);

		Select select = new Select(dropdown);

		WebElement option = select.getFirstSelectedOption();
		option.getText();
	}

	// this method is to wait until loader icon is visible
	public static void waitForLoaderToDisappear(WebDriver driver) {
		boolean isLoaderVisible = true;
		while (isLoaderVisible) {
			isLoaderVisible = driver.findElements(By.cssSelector("#herodiv-gbg > center > div")).size() > 0;
		}
	}

	// this method with get the text from the element
	public String getInnerTextFromElement(WebElement elementValue, String elementName) {

		String value = elementValue.getAttribute("innerText");
		return (value != null) ? elementValue.getAttribute("innerText").trim() : null;
	}

	// Here it will capture the DB data for assertion
	public List<Map<String, String>> dbGetGBGDetails(String query) {

		Map<String, String> DBdetail = null;
		DBdetail = new HashMap<String, String>();

		db2Connect = new DB2Connect();

		List<Map<String, String>> DBdetails = db2Connect.setUp(query);
//		System.out.println(DBdetails);

		return DBdetails;

	}

	// scroll down by using element
	public void scrollToElement(WebDriver driver, WebElement elementXPath) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", elementXPath);
	}

}
