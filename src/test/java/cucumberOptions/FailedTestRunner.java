package cucumberOptions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="@target/failed_scenarios.txt",glue="stepDefinitions"
,monochrome = true
,tags = "@PlaceOrder or @OffersPage"
,plugin = {"html:target/cucumber1.html","json:target/cucumber1.json","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class FailedTestRunner extends AbstractTestNGCucumberTests {
	
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios(){
		return super.scenarios();
	}

}
