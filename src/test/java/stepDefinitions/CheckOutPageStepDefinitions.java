package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CheckOutPage;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class CheckOutPageStepDefinitions {
	public WebDriver drv;
	public String LandingpageProductName;
	public String CheckOutPageProductName;
	
	TestContextSetup tcs;
	CheckOutPage checkOutPage;
	
	public CheckOutPageStepDefinitions(TestContextSetup tcs) {
		this.tcs = tcs;
		checkOutPage = tcs.pageObjMgr.getCheckOutPage();
	}
	
	 
	//And verify user has ability to enter promo code and place the order
	@Then("^User proceeds to Checkout and validate the (.+) items in checkout page$")
	public void checkPromoAndPlaceOrder(String prodName) {
		checkOutPage.checkOutItem();
		CheckOutPageProductName = checkOutPage.getProdName();
		Assert.assertEquals(tcs.LandingpageProductName, CheckOutPageProductName);
	}
	
	@Then("verify user has ability to enter promo code and place the order")
	public void placeOrderAndCheckOut() throws InterruptedException {
		
		Assert.assertTrue(checkOutPage.VerifyPlaceOrderBtn());
		Assert.assertTrue(checkOutPage.VerifyPromoBtn());
		checkOutPage.placeorder();
	}
	
	
}
