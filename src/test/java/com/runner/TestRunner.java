package com.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import com.base.BaseTest;
import com.reports.Reporting;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

		@RunWith(Cucumber.class)
	@CucumberOptions(tags = ("@Login"), snippets = SnippetType.CAMELCASE, dryRun = false, publish = true, stepNotifications = true, monochrome = true, plugin = {
			"pretty","json:target/Output.json" },features = "C:\\Users\\Lenovo\\Desktop\\Ecommerce project-Demo\\ProjectEcommerce\\Features",
					glue = "com.stepdefinition")
	public class TestRunner extends BaseTest {

		@AfterClass
		public static void afterClass() throws Exception {

			Reporting.generateJvmReport(getProjectLoc()+getPropertyFileValues("jsonPath"));
		}

}

