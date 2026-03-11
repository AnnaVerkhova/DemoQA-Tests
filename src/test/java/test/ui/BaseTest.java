package test.ui;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.ui.driver.DriverFactory;
import org.ui.driver.DriverManager;

import java.time.Duration;

public class BaseTest {
    @BeforeMethod
    public void setup() {
        WebDriver driver = DriverFactory.createDriver();
        DriverManager.setDriver(driver);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
