package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends GeneralStructure{
	private By addToCartButton = By.className("btn_inventory");
	private By shoppingCartButton = By.className("shopping_cart_link");
	private By checkoutButton = By.className("checkout_button");
	
	public CartPage(SetupDriver setupDriver) {
		super(setupDriver);
	}
	
	public void checkout() {
		System.out.println("On checkout");
		List<WebElement> itemsElements = driver.findElements(By.className("inventory_item_name"));
		for (WebElement itemElement : itemsElements) {
			System.out.println(itemElement.getText());
		}
//		driver.findElement(addToCartButton).click();
	}

}
