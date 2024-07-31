package stepDefinations;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.uitest.rmt.pageObjects.LoginPage;
import com.uitest.rmt.utils.TestContextSetup;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginCTUIStep {

	public WebDriver driver;

	public String landingPageProductName;
	public String offerPageProductName;
	TestContextSetup testContextSetup;
	LoginPage landingPage;

	public LoginCTUIStep(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.landingPage = testContextSetup.pageObjectManager.getLandingPage();

	}

	@Given("User is on RMT Landing page")
	public void user_is_on_rmt_landing_page() {

		Assert.assertTrue(landingPage.getTitleLandingPage().contains("Coverage GUI"));
	}

	@When("User should login to the RMT application with username and password and enter submit button")
	public void user_should_login_to_the_rmt_application_with_username_and_password_and_enter_submit_button(
			String username, String password) throws Throwable {

		LoginPage op = testContextSetup.pageObjectManager.getLandingPage();
		op.userName(username);
		op.password(password);
		op.submitBtn();

	}

	@Then("User should redirect to the homescreen of RMT application")
	public void user_should_redirect_to_the_homescreen_of_rmt_application() throws Throwable {

	}

}
