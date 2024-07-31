package stepDefinations;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.uitest.rmt.utils.TestContextSetup;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	WebDriver driver;
	TestContextSetup testContextSetup;

	By userName = By.id("username");
	By pwd = By.id("password");
	By login = By.cssSelector("button[class='login-button bx--btn bx--btn--primary']");

	public Hooks(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}

	@Before
	public void loginToRMT() throws Throwable {
		String user = System.getenv("Username");
		String password = System.getenv("Password");
		testContextSetup.testBase.webDriverManager().findElement(userName).sendKeys(user);
		testContextSetup.testBase.webDriverManager().findElement(pwd).sendKeys(password);
		testContextSetup.testBase.webDriverManager().findElement(login).click();
	}

	@After
	public void afterScenario() throws Throwable {
		// logout
	testContextSetup.testBase.webDriverManager().quit();
	}

	@AfterStep
	public void addScreenshot(Scenario scenario) throws Throwable {
		WebDriver driver = testContextSetup.testBase.webDriverManager();
		if (scenario.isFailed()) {
			File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			// here we are converting the file format to byte format with the help of
			// "apache common io"
			byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
			scenario.attach(fileContent, "image/png", "image");
		}
	}
}