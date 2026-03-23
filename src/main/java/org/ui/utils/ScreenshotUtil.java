package org.ui.utils;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.ui.driver.DriverManager;

public class ScreenshotUtil {

    @Attachment(value = "Screenshot on failure", type = "image/png")
    public static byte[] takeScreenshot() {
        return ((TakesScreenshot) DriverManager.getDriver())
                .getScreenshotAs(OutputType.BYTES);
    }
}