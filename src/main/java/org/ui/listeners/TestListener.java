package org.ui.listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.ui.utils.ScreenshotUtil;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        ScreenshotUtil.takeScreenshot();
    }
}