package org.ui.waits;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.config.ConfigManager;
import org.ui.driver.DriverManager;
import java.time.Duration;

public class WaitUtils {
    private static WebDriver getDriver() {
        return DriverManager.getDriver();
    }

    private static WebDriverWait getWait() {
        return new WebDriverWait(
                getDriver(),
                Duration.ofSeconds(ConfigManager.getConfig().explicitTimeout()));
    }

    public static WebElement waitForVisible(WebElement element) {
        return getWait().until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForClickable(WebElement element) {
        return getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    public static boolean waitForInvisibility(WebElement element) {
        return getWait().until(ExpectedConditions.invisibilityOf(element));
    }
}
