package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class GeneralStructure {
	public static WebDriver driver;	

	public GeneralStructure(SetupDriver setupDriver) {		
		this.driver = setupDriver.getDriver();
	}
}
