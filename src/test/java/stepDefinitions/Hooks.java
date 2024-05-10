package stepDefinitions;

import java.io.File;
import java.io.IOException;
import io.cucumber.java.Scenario;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import utils.TestContextSetup;

public class Hooks {
	TestContextSetup tcs;
	public Hooks(TestContextSetup tcs) {
		this.tcs = tcs;	
	}
	
	@After
	public void quitBrowser() throws IOException {
		tcs.testBase.WebDriverManager().quit();
	}
	
	@AfterStep
	public void AddScreenshot(Scenario scenario) throws IOException {
		WebDriver driver =tcs.testBase.WebDriverManager();
		if(scenario.isFailed()){
		//screenshot
		File sourcePath= 	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
		scenario.attach(fileContent, "image/png", "image");
		
		}
		
	}

}
