package pages;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends GeneralStructure{
	

	public LoginPage(SetupDriver setupDriver) {
		super(setupDriver);
	}

	private By usernameField = By.id("user-name");
	private By passwordField = By.id("password");
	private By loginButton = By.xpath("//*[@id=\"login_button_container\"]/div/form/input[3]");
	private By loginOKMessage = By.className("product_label");
	private By loginLockedUserMessage = By.tagName("h3");
	
	public void login(String user, String password) {
		System.out.println("On login");
		driver.findElement(usernameField).sendKeys(user);
		driver.findElement(passwordField).sendKeys(password);
		driver.findElement(loginButton).click();
	}
	
	public void assertLoginOk() {
		Assert.assertTrue(driver.findElement(loginOKMessage).getText().contains("Products"));
	}
	
	public void assertLoginFail(String failMessage) {
		Assert.assertTrue(driver.findElement(loginLockedUserMessage).getText().contains(failMessage));
	}
}
