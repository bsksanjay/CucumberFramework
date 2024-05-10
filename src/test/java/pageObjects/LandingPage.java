package pageObjects;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
	public WebDriver drv;
	public LandingPage(WebDriver drv) {
		this.drv= drv;
	}
	
	By search = By.xpath("//input[@type='search']");
	By getItemName = By.cssSelector("h4.product-name");
	By topDeals = By.linkText("Top Deals");
	By quantity = By.xpath("//input[@class='quantity']");
	By increment = By.xpath("//a[@class='increment']");
	By addToCart = By.xpath("//button[text()='ADD TO CART']");
	
	public void searchItem(String itemName) {
		 drv.findElement(search).sendKeys(itemName);
	}
	public String getItemName() {
		return drv.findElement(getItemName).getText();
	}
	public void selectTopDealsPage() {
		drv.findElement(topDeals).click();
	}
	public void incrementQuantity(String count) {
		String iquantity = drv.findElement(quantity).getAttribute("value").toString();
		int quantity = Integer.parseInt(iquantity);
		int tcount = Integer.parseInt(count);
	    for (int i=quantity;i<tcount;i++) {
	    drv.findElement(increment).click();
	    }
	}
	
	public void addToCart() {
		drv.findElement(addToCart).click();
	}
	public String getLandingPageTitle() {
		return drv.getTitle();
	}
}
