package awesomecucumber.stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class MyStepDefinitions {
    @Given("I'm on the store page1")
    public void i_m_on_the_store_page1() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://askomdch.com/store/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
        Thread.sleep(5000);
    }
    @When("I add a {string} to the cart1")
    public void i_add_a_to_the_cart1(String string) {

    }
    @Then("I should see {int} {string} in the cart1")
    public void i_should_see_in_the_cart1(Integer int1, String string) {

    }

}
