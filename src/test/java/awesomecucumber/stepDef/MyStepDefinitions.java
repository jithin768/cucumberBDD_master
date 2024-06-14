package awesomecucumber.stepDef;

import awesomecucumber.factory.DriverFactory;
import awesomecucumber.pages.CartPage;
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
        By proceedToCheckoutBtn=By.cssSelector(".checkout-button");
        driver.findElement(proceedToCheckoutBtn).click();
    }
    @When("I provide billing details")
    public void i_provide_billing_details(List<Map<String, String>> billingDetails) {

        By billingFirstnameFld=By.id("billing_first_name");
        By billingLastNameFld=By.id("billing_last_name");
        By billingAddressOneFld=By.id("billing_address_1");
        By billingCityFld=By.id("billing_city");
        By billingStateDropDown=By.id("billing_state");
        By billingZipFld=By.id("billing_postcode");
        By billingEmailFld=By.id("billing_email");

        driver.findElement(billingFirstnameFld).clear();
        driver.findElement(billingFirstnameFld).sendKeys(billingDetails.get(0).get("firstname"));
        driver.findElement(billingLastNameFld).clear();
        driver.findElement(billingLastNameFld).sendKeys(billingDetails.get(0).get("lastname"));
        driver.findElement(billingAddressOneFld).clear();
        driver.findElement(billingAddressOneFld).sendKeys(billingDetails.get(0).get("address_line1"));
        driver.findElement(billingCityFld).clear();
        driver.findElement(billingCityFld).sendKeys(billingDetails.get(0).get("city"));
        //Select select=new Select(driver.findElement(billingStateDropDown));
        //select.selectByVisibleText(billingDetails.get(0).get("state"));
        driver.findElement(billingZipFld).clear();
        driver.findElement(billingZipFld).sendKeys(billingDetails.get(0).get("zip"));
        driver.findElement(billingEmailFld).clear();
        driver.findElement(billingEmailFld).sendKeys(billingDetails.get(0).get("email"));


    }
    @When("I place an order")
    public void i_place_an_order() throws InterruptedException {
        System.out.println("Test1");
        By placeOrderBtn=By.id("place_order");
       System.out.println("Test1");
        Thread.sleep(5000);
       driver.findElement(placeOrderBtn).click();
        Thread.sleep(5000);
        driver.findElement(placeOrderBtn).click();

    }
    @Then("the order should be placed successfully")
    public void the_order_should_be_placed_successfully() {
       By noticeTxt=By.cssSelector(".woocommerce-notice.woocommerce-notice--success.woocommerce-thankyou-order-received");
       String actualNoticeMsg=driver.findElement(noticeTxt).getText();
       Assert.assertEquals("Thank you. Your order has been received.", actualNoticeMsg);
    }

}
