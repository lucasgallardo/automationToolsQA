package pages;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SetupDriver {
	static WebDriver driver;
	
	public WebDriver setUpnav() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com");
		return driver;
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public void closeDriver() {
		driver.close();
	}

	
	

}
