package io.cucumber.skeleton;


import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.CartPage;
import pages.GeneralStructure;
import pages.LoginPage;
import pages.ProductsPage;
import pages.SetupDriver;

public class Tests{
	SetupDriver setupDriver = new SetupDriver();
	
	
	@Before
	public void setUp() {
		setupDriver.setUpnav();
	}
	
	@Test @Ignore
	public void loginOk() {
		
		LoginPage loginPage = new LoginPage(setupDriver);
//		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("standard_user", "secret_sauce");
		loginPage.assertLoginOk();
	}
	
	@Test @Ignore
	public void loginLockedUser() {
		LoginPage loginPage = new LoginPage(setupDriver);
		loginPage.login("locked_out_user", "secret_sauce");
		loginPage.assertLoginFail("user has been locked out");
	}
	
	@Test @Ignore
	public void sortProducts() {
		ProductsPage productsPage = new ProductsPage(setupDriver);
		LoginPage loginPage = new LoginPage(setupDriver);
		loginPage.login("standard_user", "secret_sauce");
		productsPage.sortProducts("hilo");
	}
	
	@Test
	public void makeAnOrder() {
		LoginPage loginPage = new LoginPage(setupDriver);
		loginPage.login("standard_user", "secret_sauce");
		CartPage cartPage = new CartPage(setupDriver);
		cartPage.addToCart(2);
		cartPage.checkout();		
	}
	
	@After
	public void tearDown() {
		setupDriver.closeDriver();
	}

}
