package com.uitest.rmt.cucmberOptions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features", glue = "stepDefinations", tags = "@SearchPool", monochrome = true, dryRun = false, plugin = {
		"html:target/cucumber.html", "json:target/cucumber.json",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "rerun:target/failed_scenarios.txt" })

//https://www.extentreports.com/docs/versions/4/java/cucumber4.html

public class TestNGTestRunner extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = false)
	public Object[][] scenarios() {

		return super.scenarios();
	}
}

/**
 * @E2E : For run END 2 END test case for GBG & BG
 * @AdminRole : It will run all the test case w.r.t. Admin Role
 * @ReadOnlyRole : it will run all the test case w.r.t. ReadOnly
 * 
 *               GBG
 * @SearchGBG : It will run all test case w.r.t. Search GBG
 * @CreateGBG : It will run all test case w.r.t. Create GBG
 * @DeleteGBG : It will run all test case w.r.t. Delete GBG
 * @UpdateGBG :It will run all test case w.r.t. Update GBG
 * 
 *            BG
 * @SearchBG : It will run All the test case based on search BG
 * @CreateBG : It will run All the test case based on Create BG
 * @UpdateBG : It will run All the test case based on Update BG
 * @DeleteBG : It will run All the test case based on Delete BG
 * @SearchBGByBGRules : It will run All the test case based on SearchBGByBGRules
 * @SearchBGByLocks : It will run All the test case based on SearchBGByLocks BG
 * 
 */
