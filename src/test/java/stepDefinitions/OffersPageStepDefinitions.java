package stepDefinitions;

import static org.testng.Assert.assertEquals;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class OffersPageStepDefinitions {
	public String OfferspageProductName;
	TestContextSetup tcs;
	PageObjectManager pageObjectMngr ;
	
	public OffersPageStepDefinitions(TestContextSetup tcs) {
		this.tcs = tcs;
	}
	@Then("^user searches for (.+) in Offers Page$")
	public void user_searches_for_in_offers_page(String shortName) throws InterruptedException {
		switchToOffersPage();
		//tcs.drv.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
		//Thread.sleep(2000);
		//OfferspageProductName = tcs.drv.findElement(By.xpath("//tr/td[1]")).getText();
		
		//OffersPage offerpage = new OffersPage(tcs.drv);
		OffersPage offerspage = tcs.pageObjMgr.offersPage();
		offerspage.serchItem(shortName);
		Thread.sleep(2000);
		OfferspageProductName = offerspage.getItemName();
	}
	
	public void switchToOffersPage() {
		//if(tcs.drv.getCurrentUrl().equalsIgnoreCase("https://rahulshettyacademy.com/seleniumPractise/#/offers")) {
		//}else {
		
		//pageObjectMngr = new PageObjectManager(tcs.drv);
		//LandingPage landingpage = pageObjectMngr.getLandingPage();
		
		//LandingPage landingpage = new LandingPage(tcs.drv);
		LandingPage landingpage = tcs.pageObjMgr.getLandingPage();
		landingpage.selectTopDealsPage();
		tcs.genericUtils.SwitchWindowToChild();

	}
	
	@Then("Validate product name matches in Offers page")
	public void validate_product_name_matches_in_offers_page() {
	    Assert.assertEquals(OfferspageProductName, tcs.LandingpageProductName);
	}
}
