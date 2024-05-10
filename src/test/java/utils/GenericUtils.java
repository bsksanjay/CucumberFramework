package utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class GenericUtils {
	
	public WebDriver drv;
	public GenericUtils(WebDriver drv) {
		this.drv=drv;
	}
	public void SwitchWindowToChild() {
		//if(tcs.drv.getCurrentUrl().equalsIgnoreCase("https://rahulshettyacademy.com/seleniumPractise/#/offers")) {
		//}else {
	    Set<String>s1 = drv.getWindowHandles();
		Iterator<String> itr = s1.iterator();
		String parentWndw = itr.next();
		String childWndw = itr.next();
		drv.switchTo().window(childWndw);
		//}
	}
}
