package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private WebDriver driver;
	private By usernameField;
	private By passwordField;
	private By loginButton;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		usernameField = By.id("user-name");
		passwordField = By.id("password");
		loginButton = By.xpath("//*[@id=\"login_button_container\"]/div/form/input[3]");
	}
	
	public void login(String user, String password) {
		driver.findElement(usernameField).sendKeys(user);
		driver.findElement(passwordField).sendKeys(password);
		driver.findElement(loginButton).click();
	}
}
