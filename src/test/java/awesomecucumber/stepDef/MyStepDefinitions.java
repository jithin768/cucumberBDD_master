package awesomecucumber.stepDef;

import awesomecucumber.factory.DriverFactory;
import awesomecucumber.pages.CartPage;
import awesomecucumber.pages.CheckoutPage;
import awesomecucumber.pages.StorePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.AssertJUnit;

import java.time.Duration;
import java.util.List;
import java.util.Map;


public class MyStepDefinitions {

    private WebDriver driver;
    @Given("I'm on the store page1")
    public void i_m_on_the_store_page1() throws InterruptedException {
        driver= DriverFactory.getDriver();
        //StorePage storePage=new StorePage();
        //storePage.load("https://askomdch.com/store/");
        new StorePage(driver).load("https://askomdch.com/store/");



    }
    @When("I add a {string} to the cart1")
    public void i_add_a_to_the_cart1(String productName) {
        new StorePage(driver).addToCart(productName);

    }
    @Then("I should see {string} {string} in the cart1")
    public void i_should_see_in_the_cart1(String quantity, String productName) {
        CartPage cartPage=new CartPage(driver);
        Assert.assertEquals(productName,cartPage.getProductName());
        Assert.assertEquals(quantity,cartPage.getProductQuantity());
    }

    @Given("I'm a guest customer")
    public void i_m_a_guest_customer() {

        driver= DriverFactory.getDriver();
        new StorePage(driver).load("https://askomdch.com/store/");
    }
    @Given("I have a product in the cart")
    public void i_have_a_product_in_the_cart() {
        new StorePage(driver).addToCart("Blue Shoes");

    }
    @Given("I'm on the Checkout page")
    public void i_m_on_the_checkout_page() {
       new CartPage(driver).checkout();
    }
    @When("I provide billing details")
    public void i_provide_billing_details(List<Map<String, String>> billingDetails) {

        CheckoutPage checkoutPage=new CheckoutPage(driver);
        checkoutPage.setBillingDetails(billingDetails.get(0).get("firstname"),
                billingDetails.get(0).get("lastname"),
                billingDetails.get(0).get("address_line1"),
                billingDetails.get(0).get("city"),
                billingDetails.get(0).get("state"),
                billingDetails.get(0).get("zip"),
                billingDetails.get(0).get("email"));

    }
    @When("I place an order")
    public void i_place_an_order() {
      new CheckoutPage(driver).placeOrder();

    }
    @Then("the order should be placed successfully")
    public void the_order_should_be_placed_successfully() {
        Assert.assertEquals("Thank you. Your order has been received.",
               new CheckoutPage(driver).getNotice());
    }

}
