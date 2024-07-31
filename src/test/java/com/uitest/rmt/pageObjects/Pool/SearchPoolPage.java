package com.uitest.rmt.pageObjects.Pool;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.uitest.rmt.pageObjects.ActionDetails;
import com.uitest.rmt.pageObjects.CommonObjects;
import com.uitest.rmt.pageObjects.ElementInfo;
import com.uitest.rmt.pageObjects.Pool.Elements.SearchPoolElements;
import com.uitest.rmt.utils.GenricUtils;
import com.uitest.rmt.utils.Helper;
import com.uitest.rmt.utils.LoggerHelper;
import com.uitest.rmt.utils.ReadFromExcel;

public class SearchPoolPage {
	public WebDriver driver;
	public Helper helper = new Helper();
	public GenricUtils utils = new GenricUtils(driver);
	static ReadFromExcel rfx = new ReadFromExcel();
	SearchPoolElements searchPoolElements;
	CommonObjects commonObjects = new CommonObjects(driver);
	private static org.apache.log4j.Logger logger = LoggerHelper.getLogger(SearchPoolPage.class);

	public SearchPoolPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
		searchPoolElements = new SearchPoolElements(driver);
	}

	// ===============================================================================================
	public String mandt;

	public String PoolID;
	String PoolName;
	String searchName;
	String regionId;
	String marketComplianceCd;
	String poolNameLong;
	String status;

	// ===============================================================================================

	public boolean enterMandt() throws IOException {
		Helper.sleep(2000);

		if (!mandt.equalsIgnoreCase("null")) {
			ElementInfo ei = new ElementInfo(mandt, searchPoolElements.getCreateMandt(mandt), "mandt");
			ActionDetails ad = new ActionDetails("attribute", "class", "bx--list-box__menu-item__option", "click");
			return commonObjects.functionToInsertDetail(ei, ad);
		} else {
			logger.error("mandt is null");
			return false;
		}
	}

	public boolean fillAllDetails() {
		try {
			getPoolDataFromExcel();
			enterMandt();

			return true;
		} catch (IOException e) {
			e.getMessage();
		}
		return false;
	}

	// =================================================================================================
	public void getPoolDataFromExcel() throws IOException {
		Map<String, String> createDetails = rfx.ReadFromExcelfile("SearchPool").get(0);
		String data = "00000";

		
		mandt = createDetails.get("mandt");
		PoolID = data + createDetails.get("PoolID");
		PoolName = createDetails.get("PoolName");
		searchName = createDetails.get("searchName");
		regionId = createDetails.get("regionId");
		marketComplianceCd = createDetails.get("marketComplianceCd");
		status = createDetails.get("status");
		poolNameLong = createDetails.get("poolNameLong");

	}
}