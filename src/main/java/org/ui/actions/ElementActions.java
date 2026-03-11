package org.ui.actions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.ui.waits.WaitUtils;

public class ElementActions {

    public static void click(WebElement element) {
        WaitUtils.waitForClickable(element).click();
    }

    public static void type(WebElement element, String text) {
        WebElement el = WaitUtils.waitForVisible(element);
        el.clear();
        el.sendKeys(text);
    }

    public static void selectByText(WebElement element, String text) {

        WebElement el = WaitUtils.waitForVisible(element);
        Select select = new Select(el);
        select.selectByVisibleText(text);
    }

    public static String getText(WebElement element) {
        return WaitUtils.waitForVisible(element).getText();
    }
}
