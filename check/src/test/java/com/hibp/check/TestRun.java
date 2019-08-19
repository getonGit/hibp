package com.hibp.check;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/feature",
		glue={"stepdef"},
	// 	dryRun = true,
		plugin= {"html:target/cucumber-html-report"}
				)

public class TestRun {

	
}
