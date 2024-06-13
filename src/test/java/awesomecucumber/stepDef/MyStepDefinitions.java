package awesomecucumber.stepDef;

import awesomecucumber.factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.AssertJUnit;

import java.time.Duration;



public class MyStepDefinitions {

    private WebDriver driver;
    @Given("I'm on the store page1")
    public void i_m_on_the_store_page1() throws InterruptedException {
        driver= DriverFactory.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
        driver.get("https://askomdch.com/store/");

    }
    @When("I add a {string} to the cart1")
    public void i_add_a_to_the_cart1(String string) {
        By addToCartBtn= By.cssSelector("a[aria-label='Add “Blue Shoes” to your cart']");
        driver.findElement(addToCartBtn).click();
        By viewCartLink=By.cssSelector("a[title='View cart']");
        driver.findElement(viewCartLink).click();

    }
    @Then("I should see {string} {string} in the cart1")
    public void i_should_see_in_the_cart1(String quantity, String productName) {
        By productNameFld=By.cssSelector("");
        String actualProductName=driver.findElement(productNameFld).getText();
        By productQuantityFld=By.cssSelector("");
        String actualQuantity=driver.findElement(productQuantityFld).getAttribute("value");
        Assert.assertEquals(productName,actualProductName);
        Assert.assertEquals(quantity,actualQuantity);
    }

    @Given("I'm a guest customer")
    public void i_m_a_guest_customer() {
        driver= DriverFactory.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
    }
    @Given("I have a product in the cart")
    public void i_have_a_product_in_the_cart() {
        driver.get("https://askomdch.com/store/");
        By addToCartBtn= By.cssSelector("a[aria-label='Add “Blue Shoes” to your cart']");
        driver.findElement(addToCartBtn).click();
        By viewCartLink=By.cssSelector("a[title='View cart']");
        driver.findElement(viewCartLink).click();
    }
    @Given("I'm on the Checkout page")
    public void i_m_on_the_checkout_page() {
        By proceedToCheckoutBtn=By.cssSelector(".checkout-button");
        driver.findElement(proceedToCheckoutBtn).click();
    }
    @When("I provide billing details")
    public void i_provide_billing_details(io.cucumber.datatable.DataTable dataTable) {

        By billingFirstnameFld=By.id()



    }
    @When("I place an order")
    public void i_place_an_order() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("the order should be placed successfully")
    public void the_order_should_be_placed_successfully() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
