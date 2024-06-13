package awesomecucumber.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    private static WebDriver driver;

    public static WebDriver initializeDriver(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        return driver;
    }
    public static WebDriver getDriver(){
        return driver;
    }
}
