package stepDefinations.Pool;

import org.openqa.selenium.WebDriver;

import com.uitest.rmt.pageObjects.Pool.SearchPoolPage;
import com.uitest.rmt.utils.GenricUtils;
import com.uitest.rmt.utils.Helper;
import com.uitest.rmt.utils.TabMenu;
import com.uitest.rmt.utils.TestContextSetup;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchPoolStep {
	public WebDriver driver;

	TestContextSetup testContextSetup;
	SearchPoolPage searchPoolPage;
	TabMenu tabMenu;
	GenricUtils utils;

	public SearchPoolStep(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.searchPoolPage = testContextSetup.pageObjectManager.getSearchPoolPage();
		this.tabMenu = testContextSetup.pageObjectManager.getTabMenu();
		this.utils = testContextSetup.pageObjectManager.getGenricUtils();
	}

	@Given("User should be in Pool module under COV Structure Tab")
	public void User_should_be_in_Pool_module_under_COV_Structure_Tab() {

		tabMenu.switchToTab("POOL");
		Helper.sleep(1000);

	}

	@When("User should fill all the field to search Pool Id")
	public void User_should_fill_all_the_field_to_search_Pool_Id() {

		searchPoolPage.fillAllDetails();

	}

	@Then("User should successfully search and see the list of pool data")
	public void user_should_successfully_search_and_see_the_list_of_pool_data() {

	}
}