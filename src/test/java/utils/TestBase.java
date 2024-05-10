package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	
	public WebDriver drv;
	public WebDriver WebDriverManager() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String browser = prop.getProperty("browser");
		if (drv== null) {
			if (browser.equalsIgnoreCase("chrome")) {
		
				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//src//test//resources//chromedriver.exe");
				drv = new ChromeDriver();
				drv.manage().window().maximize();
				drv.get(prop.getProperty("url"));
				drv.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				}
			}else if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"//src//test//resources//geckodriver.exe");
				drv = new FirefoxDriver();
				drv.manage().window().maximize();
				drv.get(prop.getProperty("url"));
				drv.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			}
		return drv;	
	}
}
