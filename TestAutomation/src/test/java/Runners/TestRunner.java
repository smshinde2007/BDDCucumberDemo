package Runners;

import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

import cucumber.api.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	    features = "src/test/resources/Features",
	    		tags = "@Smoke",
	    glue = {"stepDefinitions","Base","TestBase"},         
	    plugin = { "pretty", "html:target/cucumber-report.html" },
	    monochrome = true                                         
	)
	
public class TestRunner extends AbstractTestNGCucumberTests
{
 
	 @Override
	    @DataProvider(parallel = true)
	    public Object[][] scenarios() {
	        return super.scenarios();
	    }
}
