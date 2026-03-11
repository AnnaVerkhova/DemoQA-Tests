package org.ui.driver;

import org.config.ConfigManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import java.time.Duration;

public class BrowserManager {

    public static WebDriver createChrome() {

        ChromeOptions options = new ChromeOptions();
        if (ConfigManager.getConfig().headless()) {
            options.addArguments("--headless=new");
        }
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(
                Duration.ofSeconds(ConfigManager.getConfig().implicitTimeout())
        );
        return driver;
    }

    public static WebDriver createFirefox() {

        FirefoxOptions options = new FirefoxOptions();

        if (ConfigManager.getConfig().headless()) {
            options.addArguments("--headless");
        }
        WebDriver driver = new FirefoxDriver(options);
        driver.manage().timeouts().implicitlyWait(
                Duration.ofSeconds(ConfigManager.getConfig().implicitTimeout())
        );
        return driver;
    }
}