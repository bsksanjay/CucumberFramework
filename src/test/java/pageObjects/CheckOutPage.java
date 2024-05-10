package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage {

	public WebDriver drv;
	
	public CheckOutPage(WebDriver drv) {
		this.drv=drv;
	}
	
	 By checkOutButton = By.xpath("//button[text()='PROCEED TO CHECKOUT']");
	 By cartBag = By.xpath("//img[@alt='Cart']");
	 By promoBtn = By.xpath("//input[@class='promoCode']");
	 By applyPromo = By.xpath("//button[text()='Apply']");
	 By placeOrder= By.xpath("//button[text()='Place Order']");
	 By productName = By.xpath("//p[@class='product-name']");
	public void checkOutItem() {
		drv.findElement(cartBag).click();
		drv.findElement(checkOutButton).click();
	}
	
	public boolean VerifyPromoBtn() {
		return drv.findElement(promoBtn).isDisplayed();
	}
	public boolean VerifyPlaceOrderBtn() {
		return drv.findElement(placeOrder).isDisplayed();
	}
	public String getProdName() {
		return drv.findElement(productName).getText();
		
	}
	public void placeorder() {
		drv.findElement(placeOrder).click();
	}
}
