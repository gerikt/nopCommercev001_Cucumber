package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
(
	
		features=".//Features/Customers.feature",
		glue="stepDefinitions",
		dryRun=false,
		monochrome=true,
		plugin={"pretty",
				"html:test-output"}

)
public class TestRun {
	
	//if i want to run more than one feature files
	//i would put them in {} and seperate by comma,
	//features={".//Features/Customers.feature",".//Features/Login.feature"}
	

}
