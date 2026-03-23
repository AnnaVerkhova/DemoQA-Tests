package org.ui.driver;

import org.openqa.selenium.WebDriver;
import org.config.ConfigManager;

public class DriverFactory {
    public static WebDriver createDriver() {

        String browser = ConfigManager.getConfig().browser().toLowerCase();

        switch (browser) {
            case "chrome":
                return BrowserManager.createChrome();
            case "firefox":
                return BrowserManager.createFirefox();
            default:
                throw new RuntimeException("Browser not supported: " + browser);
        }
    }
}
