package stepDefinations.Territory;

import org.openqa.selenium.WebDriver;

import com.uitest.rmt.pageObjects.Territory.SearchTerritoryPage;
import com.uitest.rmt.pageObjects.Territory.Elements.SearchTerritoryElements;
import com.uitest.rmt.utils.GenricUtils;
import com.uitest.rmt.utils.Helper;
import com.uitest.rmt.utils.TabMenu;
import com.uitest.rmt.utils.TestContextSetup;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchTerritoryStep {

	public WebDriver driver;

	TestContextSetup testContextSetup;
	SearchTerritoryPage searchterritoryPage;
	TabMenu tabMenu;
	GenricUtils utils;

	public SearchTerritoryStep(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.searchterritoryPage = testContextSetup.pageObjectManager.getSearchTerritoryPage();
		this.tabMenu = testContextSetup.pageObjectManager.getTabMenu();
		this.utils = testContextSetup.pageObjectManager.getGenricUtils();

	}

	@Given("User should be in Territory module under COV Structure Tab")
	public void user_should_be_in_territory_module_under_cov_structure_tab() throws Throwable {
		tabMenu.switchToTab("CovStruct");
		Helper.sleep(1000);
		searchterritoryPage.clickTerritoryLink();
	}

	@When("Fill all the details to search Territory id")
	public void fill_all_the_details_to_search_territory_id() {
		searchterritoryPage.fillAllDetails();

	}

	@When("Fill mandt detail to search Territory id")
	public void fill_mandt_detail_to_search_territory_id() {
		searchterritoryPage.fillMandt();

	}

	@When("Fill coverageid detail to search Territory id")
	public void fill_coverageid_detail_to_search_territory_id() {
		searchterritoryPage.fillCoverageID();

	}

	@When("Fill coverageidname detail to search Territory id")
	public void fill_coverageidname_detail_to_search_territory_id() {
		searchterritoryPage.fillCoverageIDName();

	}

	@When("Fill execName detail to search Territory id")
	public void fill_exec_name_detail_to_search_territory_id() {
		searchterritoryPage.fillExecName();

	}

	@When("Fill ExecCnum detail to search Territory id")
	public void fill_exec_cnum_detail_to_search_territory_id() {
		searchterritoryPage.fillExecCnum();

	}

	@When("Fill execIntranetId detail to search Territory id")
	public void fill_exec_intranet_id_detail_to_search_territory_id() {
		searchterritoryPage.fillExecIntranet();

	}

	@Then("User should be able to search")
	public void user_should_be_able_to_search() {
		searchterritoryPage.searchBtn();

	}
}
