package com.uitest.rmt.pageObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.uitest.rmt.utils.Helper;
import com.uitest.rmt.utils.LoggerHelper;

public class CommonObjects {

	public WebDriver driver;
	private static org.apache.log4j.Logger logger = LoggerHelper.getLogger(CommonObjects.class);

	public CommonObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
	}

	// to check elements like search, new , export buttons and perform click
	// operations
	public boolean clickableElement(WebElement element, String stringToCompare, String elementName) {
		if (element.getText().equalsIgnoreCase(stringToCompare)) {
			element.click();
			Helper.sleep(5000);
			logger.info(elementName + " clicked");
			return true;
		} else {
			logger.error(elementName + " element is null or invalid - " + element);
			return false;
		}
	}

	// for non dynamic elements, compare not null excel data, check elements
	// validity with getText,
	// then perform click operation
	public boolean functionToInsertDetails(String fieldValue, WebElement element, String fieldName) {
		if (!fieldValue.equalsIgnoreCase("null")) {
			if (element.getText().equalsIgnoreCase(fieldValue)) {
				element.click();
				logger.info(fieldName + " selected is - " + fieldValue);
				return true;
			} else {
				logger.error(fieldName + " element is null or invalid - " + element);
				return false;
			}
		} else {
			logger.error(fieldName + " is null");
			return false;
		}
	}

	// for non dynamic elements, compare not null excel data, check elements
	// validity with getAttribute,
	// then perform sendKeys operations
	public boolean functionToInsertDetails0(String fieldValue, WebElement element, String fieldName,
			String attributeName, String stringToCompare) {
		if (!fieldValue.equalsIgnoreCase("null")) {
			if (element.getAttribute(attributeName).equalsIgnoreCase(stringToCompare)) {
				element.clear();
				element.sendKeys(fieldValue);
				logger.info(fieldName + " entered is - " + fieldValue);
				return true;
			} else {
				logger.error(fieldName + " element is null or invalid - " + element);
				return false;
			}
		} else {
			logger.error(fieldName + " is null");
			return false;
		}

	}

	// for dynamic elements, check elements validity with getAttribute, then perform
	// click operation
	public boolean functionToInsertDetails1(String fieldValue, WebElement element, String fieldName,
			String attributeName, String stringToCompare) {
		if (element.getAttribute(attributeName).equalsIgnoreCase(stringToCompare)) {
			element.click();
			logger.info(fieldName + " selected is - " + fieldValue);
			return true;
		} else {
			logger.error(fieldName + " element is null or invalid - " + element);
			return false;
		}

	}

	// for dynamic elements, check elements validity with getText, then perform
	// click operation
	public boolean functionToInsertDetails2(String fieldValue, WebElement element, String fieldName) {
		if (element.getText().equalsIgnoreCase(fieldValue)) {
			element.click();
			logger.info(fieldName + " selected is - " + fieldValue);
			return true;
		} else {
			logger.error(fieldName + " element is null or invalid - " + element);
			return false;
		}
	}

	// clearAndSendKeys and click
//	public boolean functionToInsertDetailsX(String fieldValue, WebElement element, String fieldName,
//			String comparatorType, String attributeName, String stringToCompare, String actionType) {
//		boolean isValid = false;
//
//		if (comparatorType.equalsIgnoreCase("text")) {
//			isValid = element.getText().equalsIgnoreCase(fieldValue);
//		} else if (comparatorType.equalsIgnoreCase("attribute")) {
//			isValid = element.getAttribute(attributeName).equalsIgnoreCase(stringToCompare);
//		} else {
//			logger.error("Invalid comparatorType provided");
//			return false;
//		}
//
//		if (!fieldValue.equalsIgnoreCase("null")) {
//			if (isValid) {
//				if (actionType.equalsIgnoreCase("clearAndSendKeys")) {
//					element.clear();
//					element.sendKeys(fieldValue);
//				} else if (actionType.equalsIgnoreCase("click")) {
//					element.click();
//				} else {
//					logger.error("Invalid actionType provided");
//					return false;
//				}
//
//				logger.info(fieldName + " action performed with value - " + fieldValue);
//				return true;
//			} else {
//				logger.error(fieldName + " element is null or invalid - " + element);
//				return false;
//			}
//		} else {
//			logger.error(fieldName + " is null");
//			return false;
//		}
//	}

	public boolean functionToInsertDetail(ElementInfo elementInfo, ActionDetails actionDetails) {
		boolean isValid = false;

		if (actionDetails.getComparatorType().equalsIgnoreCase("text")) {
			isValid = elementInfo.getElement().getText().equalsIgnoreCase(elementInfo.getFieldValue());
		} else if (actionDetails.getComparatorType().equalsIgnoreCase("attribute")) {
			isValid = elementInfo.getElement().getAttribute(actionDetails.getAttributeName())
					.equalsIgnoreCase(actionDetails.getStringToCompare());
		} else {
			logger.error("Invalid comparatorType provided");
			return false;
		}

		if (!elementInfo.getFieldValue().equalsIgnoreCase("null")) {
			if (isValid) {
				if (actionDetails.getActionType().equalsIgnoreCase("clearAndSendKeys")) {
					elementInfo.getElement().clear();
					elementInfo.getElement().sendKeys(elementInfo.getFieldValue());
				} else if (actionDetails.getActionType().equalsIgnoreCase("click")) {
					elementInfo.getElement().click();
				} else {
					logger.error("Invalid actionType provided");
					return false;
				}

				logger.info(elementInfo.getFieldName() + " entered with value - " + elementInfo.getFieldValue());
				return true;
			} else {
				logger.error(elementInfo.getFieldName() + " element is null or invalid - " + elementInfo.getElement());
				return false;
			}
		} else {
			logger.error(elementInfo.getFieldName() + " is null");
			return false;
		}
	}

	public String generateSelectQuery(String tableName, List<String> columns, List<String> whereConditions) {
		StringBuilder queryBuilder = new StringBuilder("SELECT ");

		// Append columns
		queryBuilder.append(String.join(", ", columns));

		// Append table name
		queryBuilder.append(" FROM ").append(tableName);

		// Append WHERE clause if conditions are provided
		if (!whereConditions.isEmpty()) {
			queryBuilder.append(" WHERE ").append(String.join(" AND ", whereConditions));
		}

		return queryBuilder.toString();
	}

	public List<String> buildWhereConditions(Map<String, String> dataToUpdate) {
		List<String> whereConditions = new ArrayList<>();
		for (String key : dataToUpdate.keySet()) {
			whereConditions.add(key + " = '" + dataToUpdate.get(key) + "'");
		}
		return whereConditions;
	}

}
