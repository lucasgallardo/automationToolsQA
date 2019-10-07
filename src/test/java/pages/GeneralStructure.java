package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class GeneralStructure {
	public static WebDriver driver;	

	public GeneralStructure() {		
		this.driver = getDriver();
	}
	
	public void setUpDriver() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com");
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public void closeDriver() {
		driver.close();
	}
}
