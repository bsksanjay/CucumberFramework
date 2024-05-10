package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	public WebDriver drv;
	public LandingPage landingPage;
	public OffersPage offersPage;
	public CheckOutPage checkOutPage;
	
	public PageObjectManager(WebDriver drv) {
		this.drv=drv;
	}
	
	public LandingPage getLandingPage() {
		landingPage = new LandingPage(drv);
		return landingPage;
	}
	public OffersPage offersPage() {
		offersPage = new OffersPage(drv);
		return offersPage;
	}
	
	public CheckOutPage getCheckOutPage() {
		checkOutPage = new CheckOutPage(drv);
		return checkOutPage;
		
	}
}
