package pages;

import static org.junit.Assert.assertTrue;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ProductsPage extends GeneralStructure{

	private By selectSort = By.className("product_sort_container");;

	public ProductsPage(WebDriver driver) {
		super(driver);
	}

	public void sortProducts(String criteria) {
		
		Select selectProduct = new Select(driver.findElement(selectSort));
		selectProduct.selectByValue(criteria);
		List<WebElement> itemsElements = driver.findElements(By.className("inventory_item_price"));
		for (WebElement itemElement : itemsElements) {
			System.out.println(itemElement.getText());
		}

		// Linked List
		LinkedList<String> productNames = new LinkedList<String>();

		for (WebElement temp : itemsElements) {
			String sTemp = temp.getText();
			sTemp = sTemp.replace("$", "");
			sTemp = sTemp.replace(".", "");
			productNames.add(sTemp.toLowerCase().trim());
		}
		int size = productNames.size();
		int first = Integer.parseInt(productNames.get(0));
		int last = Integer.parseInt(productNames.get(size - 1));
		
		if(criteria.equals("lohi")) {
			Assert.assertTrue("Is not sorted correctly", sortType(last, first));
		}else {
			Assert.assertTrue("Is not sorted correctly", sortType(first, last));
		}
	}

	public boolean sortType(int one, int two) {
		boolean status = false;
		if (one > two) {
			status = true;
		}
		
		return status;
	}

}
