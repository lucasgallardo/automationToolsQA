package io.cucumber.skeleton;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.LoginPage;
import pages.SetupDriver;

public class StepsOrder {
	SetupDriver setupDriver = new SetupDriver();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() throws Throwable {
		LoginPage loginPage = new LoginPage(setupDriver);
		loginPage.login("standard_user", "secret_sauce");
    }
    
    @When("user enter correct username and password")
    public void user_enter_correct_username_and_password() throws Throwable{
    	System.out.println("enter username and password");
    }
    
    @And("user add producto to cars")
    public void user_add_producto_to_cars() throws Throwable{
		CartPage cartPage = new CartPage(setupDriver);
		cartPage.addToCart(2);
		cartPage.checkout();
    }
    
    @And("user start checkout")
    public void user_start_checkout() throws Throwable{
		System.out.println("did checkout");
    }
    
    @Then("user finish the order")
    public void user_finish_the_order() throws Throwable{
    	System.out.println("finish the order");
    }
}
