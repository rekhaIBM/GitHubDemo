package com.uitest.rmt.pageObjects.Territory;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.uitest.rmt.pageObjects.ActionDetails;
import com.uitest.rmt.pageObjects.CommonObjects;
import com.uitest.rmt.pageObjects.ElementInfo;
import com.uitest.rmt.pageObjects.Territory.Elements.SearchTerritoryElements;
import com.uitest.rmt.utils.GenricUtils;
import com.uitest.rmt.utils.Helper;
import com.uitest.rmt.utils.LoggerHelper;
import com.uitest.rmt.utils.ReadFromExcel;

public class SearchTerritoryPage {

	public WebDriver driver;
	static ReadFromExcel rfx = new ReadFromExcel();
	SearchTerritoryElements searchTerritoryElement;
	CommonObjects commonObjects = new CommonObjects(driver);
	public GenricUtils utils = new GenricUtils(driver);

	private static org.apache.log4j.Logger logger = LoggerHelper.getLogger(SearchTerritoryPage.class);

	public SearchTerritoryPage(WebDriver driver) {
		this.driver = driver;
		searchTerritoryElement = new SearchTerritoryElements(driver);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
	}

	public String mandt;
	String coverageId;
	String coverageIdName;
	String execName;
	String execIntranetId;
	String execCnum;
	String rowCount;

	public boolean searchBtn() {
		Helper.sleep(1000);
		utils.scrollToElement(driver, searchTerritoryElement.getSearchButton());
		commonObjects.clickableElement(searchTerritoryElement.getSearchButton(), "Search", "search_btn");
		Helper.sleep(8000);
		utils.scrollToElement(driver, searchTerritoryElement.getTotaRowCount());
		rowCount = searchTerritoryElement.getTotaRowCount().getText();
		logger.info(rowCount);
		return true;
	}

	public boolean enterMandt() throws IOException {
		Helper.sleep(2000);

		if (!mandt.equalsIgnoreCase("null")) {
			ElementInfo ei = new ElementInfo(mandt, searchTerritoryElement.getCreateMandt(mandt), "mandt");
			ActionDetails ad = new ActionDetails("attribute", "class", "bx--list-box__menu-item__option", "click");
			return commonObjects.functionToInsertDetail(ei, ad);
		} else {
			logger.error("mandt is null");
			return false;
		}
	}

	public boolean enterCoverageId() throws IOException {
		Helper.sleep(2000);
		utils.scrollToElement(driver, searchTerritoryElement.getCoverageID());

		if (!coverageId.equalsIgnoreCase("null")) {
			ElementInfo ei = new ElementInfo(coverageId, searchTerritoryElement.getCoverageID(), "coverageId");
			ActionDetails ad = new ActionDetails("attribute", "title", "COVERAGE ID", "clearAndSendKeys");
			utils.scrollToElement(driver, searchTerritoryElement.getCoverageID());
			return commonObjects.functionToInsertDetail(ei, ad);
		} else {
			logger.error("coverageID is  null");
			return false;
		}
	}

	public boolean enterCoverageIdName() throws IOException {
		Helper.sleep(2000);
		if (!coverageIdName.equalsIgnoreCase("null")) {
			ElementInfo ei = new ElementInfo(coverageIdName, searchTerritoryElement.getCoverageIDName(),
					"coverageIdName");
			ActionDetails ad = new ActionDetails("attribute", "title", "Coverage ID Name", "clearAndSendKeys");
			utils.scrollToElement(driver, searchTerritoryElement.getCoverageIDName());
			return commonObjects.functionToInsertDetail(ei, ad);
		} else {
			logger.error("coverageIDName is  null");
			return false;
		}
	}

	public boolean enterExecName() throws IOException {
		Helper.sleep(2000);
		if (!execName.equalsIgnoreCase("null")) {
			ElementInfo ei = new ElementInfo(execName, searchTerritoryElement.getExecName(), "execName");
			ActionDetails ad = new ActionDetails("attribute", "title", "Exec Name", "clearAndSendKeys");
			utils.scrollToElement(driver, searchTerritoryElement.getExecName());
			return commonObjects.functionToInsertDetail(ei, ad);
		} else {
			logger.error("execName is  null");
			return false;
		}
	}

	public boolean enterExecIntranetID() throws IOException {
		Helper.sleep(2000);
		if (!execIntranetId.equalsIgnoreCase("null")) {
			ElementInfo ei = new ElementInfo(execIntranetId, searchTerritoryElement.getExecIntranetID(),
					"execIntranetId");
			ActionDetails ad = new ActionDetails("attribute", "title", "Exec Intranet ID", "clearAndSendKeys");
			utils.scrollToElement(driver, searchTerritoryElement.getExecIntranetID());
			return commonObjects.functionToInsertDetail(ei, ad);
		} else {
			logger.error("execIntranetId is  null");
			return false;
		}
	}

	public boolean enterExecCnum() throws IOException {
		Helper.sleep(2000);
		if (!execCnum.equalsIgnoreCase("null")) {
			ElementInfo ei = new ElementInfo(execCnum, searchTerritoryElement.getExecCnum(), "execCnum");
			ActionDetails ad = new ActionDetails("attribute", "title", "Exec CNUM", "clearAndSendKeys");
			utils.scrollToElement(driver, searchTerritoryElement.getExecCnum());
			return commonObjects.functionToInsertDetail(ei, ad);
		} else {
			logger.error("execCnum is  null");
			return false;
		}
	}

	public boolean clickTerritoryLink() throws InterruptedException {
		utils.scrollToElement(driver, searchTerritoryElement.getTerritoryLink());

		return commonObjects.clickableElement(searchTerritoryElement.getTerritoryLink(), "Territory", "territory_tab");
	}

	public void getSearchTerritoryFromExcel() throws IOException {
		Map<String, String> createDetails = rfx.ReadFromExcelfile("SearchTerritory").get(0);
		mandt = createDetails.get("mandt");
		coverageId = createDetails.get("coverageId");
		coverageIdName = createDetails.get("coverageIdName");
		execName = createDetails.get("execName");
		execIntranetId = createDetails.get("execIntranetId");
		execCnum = createDetails.get("execCnum");

	}

	public boolean fillAllDetails() {
		try {
			getSearchTerritoryFromExcel();
			enterMandt();
			enterCoverageId();
			enterCoverageIdName();
			enterExecName();
			enterExecIntranetID();
			enterExecCnum();

			return true;
		} catch (IOException e) {
			e.getMessage();
		}
		return false;
	}

	public boolean fillMandt() {
		try {
			getSearchTerritoryFromExcel();
			enterMandt();

			return true;
		} catch (IOException e) {
			e.getMessage();
		}
		return false;
	}

	public boolean fillCoverageID() {
		try {
			getSearchTerritoryFromExcel();
			enterCoverageId();

			return true;
		} catch (IOException e) {
			e.getMessage();
		}
		return false;
	}
	public boolean fillCoverageIDName() {
			try {
				getSearchTerritoryFromExcel();
				enterCoverageIdName();

				return true;
			} catch (IOException e) {
				e.getMessage();
			}
			return false;
		}
	
	public boolean fillExecName() {
		try {
			getSearchTerritoryFromExcel();
			enterExecName();

			return true;
		} catch (IOException e) {
			e.getMessage();
		}
		return false;
	}

	public boolean fillExecCnum() {
		try {
			getSearchTerritoryFromExcel();
			enterExecCnum();

			return true;
		} catch (IOException e) {
			e.getMessage();
		}
		return false;
	}
	
	public boolean fillExecIntranet() {
		try {
			getSearchTerritoryFromExcel();
			enterExecIntranetID();

			return true;
		} catch (IOException e) {
			e.getMessage();
		}
		return false;
	}
	
	
}