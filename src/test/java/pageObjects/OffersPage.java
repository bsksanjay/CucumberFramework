package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage {

	public WebDriver drv;
	
	public OffersPage(WebDriver drv) {
		this.drv=drv;
	}
	
	By search = By.xpath("//input[@type='search']");
	By offersPageProdName = By.xpath("//tr/td[1]");
	
	public void serchItem(String itemName) {
		System.out.println(drv.getCurrentUrl());
		System.out.println(drv.getTitle());
		drv.findElement(search).sendKeys(itemName);
	}
	
	public String getItemName() {
		return drv.findElement(offersPageProdName).getText();
	}

}
