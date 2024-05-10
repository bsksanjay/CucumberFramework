package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class LandingPageStepDefinitions {
	public WebDriver drv;
	public String LandingpageProductName;
	LandingPage landingpage;
	TestContextSetup tcs;
	
	public LandingPageStepDefinitions(TestContextSetup tcs) {
		this.landingpage = tcs.pageObjMgr.getLandingPage();
		this.tcs = tcs;
	}
	
	@Given("User is on Greenkart landing page")
	public void user_is_on_greenkart_landing_page() {
		
//		System.setProperty("webdriver.chrome.driver","C:\\Users\\sbrahmandlapally\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
//		tcs.drv = new ChromeDriver();
//		tcs.drv.manage().window().maximize();
//		tcs.drv.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		Assert.assertTrue(landingpage.getLandingPageTitle().contains("GreenKart"));
	    
	}
	@When("^user searches with short name (.+) and extracted actual name of product$")
	public void user_searches_with_short_name_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {
		
		landingpage.searchItem(shortName);
		Thread.sleep(2000);
		tcs.LandingpageProductName = landingpage.getItemName().split("-")[0].trim();
		//tcs.drv.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
		//Thread.sleep(2000);
		//tcs.LandingpageProductName = tcs.drv.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();
		System.out.println("Productname: "+ tcs.LandingpageProductName);
	}
	
	@When("Added {string} items of the selected product to cart")
	public void added_items_of_the_selected_product_to_cart(String totalCount) {
		tcs.LandingpageProductName = landingpage.getItemName();
		landingpage.incrementQuantity(totalCount);
		landingpage.addToCart();
	}
}
