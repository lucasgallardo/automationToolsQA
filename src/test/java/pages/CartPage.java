package pages;

import static org.junit.Assert.assertTrue;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends GeneralStructure {
	private By addToCartButton = By.className("btn_inventory");
	private By shoppingCartButton = By.id("shopping_cart_container");
	private By checkoutButton = By.className("checkout_button");
	private By firstName = By.id("first-name");
	private By lastName = By.id("last-name");
	private By postalCode = By.id("postal-code");
	private By submitButton = By.className("cart_button");
	private By finishButton = By.linkText("FINISH");
	private By finishOrderMessage = By.id("checkout_complete_container");

	public CartPage(SetupDriver setupDriver) {
		super(setupDriver);
	}

	public void addToCart(int quantity) {
		List<WebElement> itemsElements = driver.findElements(By.className("inventory_item_name"));
		for (WebElement itemElement : itemsElements) {
			System.out.println(itemElement.getText());
		}
//		driver.findElement(addToCartButton).click();
		// Linked List
		LinkedList<String> productNames = new LinkedList<String>();

		for (WebElement temp : itemsElements) {
			String sTemp = temp.getText();
			productNames.add(sTemp.toLowerCase().trim());
		}
		// driver.findElement(addToCartButton).click();
		int limit = productNames.size();

		// select a random element
		for (int i = 0; i < quantity; i++) {
			int numero = (int) (Math.random() * limit);
			System.out.println("numero: " + numero);
			System.out.println("random: " + getRandomElement(productNames));
			driver.findElement(By.id("item_" + numero + "_title_link")).click();
			driver.findElement(addToCartButton).click();
			driver.findElement(By.className("inventory_details_back_button")).click();
		}
	}

	public void checkout() {
		System.out.println("On checkout");
		driver.findElement(shoppingCartButton).click();
		driver.findElement(checkoutButton).click();
		driver.findElement(firstName).sendKeys("Lucas");
		driver.findElement(lastName).sendKeys("Test");
		driver.findElement(postalCode).sendKeys("123456");
		driver.findElement(submitButton).click();
		driver.findElement(finishButton).click();
		String message = driver.findElement(finishOrderMessage).getText();
		System.out.println("finish message" + message);
		Assert.assertTrue(message.contains("THANK YOU FOR YOUR ORDER"));
	}

	public void add(String element) {

	}

	public String getRandomElement(LinkedList<String> productNames) {
		Random rand = new Random();
		return productNames.get(rand.nextInt(productNames.size()));
	}

}
