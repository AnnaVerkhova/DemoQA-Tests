package test.ui;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.ui.listeners.TestListener;
import org.ui.driver.DriverFactory;
import org.ui.driver.DriverManager;
import org.ui.utils.ScreenshotUtil;

import java.time.Duration;

@Listeners(TestListener.class)

public class BaseTest {
    @BeforeMethod
    public void setup() {
        WebDriver driver = DriverFactory.createDriver();
        DriverManager.setDriver(driver);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            ScreenshotUtil.takeScreenshot();
        }
        DriverManager.quitDriver();
    }
}
