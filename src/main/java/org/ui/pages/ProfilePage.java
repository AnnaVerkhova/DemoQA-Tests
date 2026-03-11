package org.ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.ui.actions.ElementActions;
import org.ui.driver.DriverManager;
import org.ui.waits.WaitUtils;

public class ProfilePage extends BasePage {

    @FindBy(id = "userName-value")
    private WebElement usernameLabel;

    @Step("Check that Profile page is opened")
    public boolean isProfilePageOpened() {
        WaitUtils.waitForVisible(usernameLabel);
        return usernameLabel.isDisplayed();
    }

    @FindBy(id = "gotoStore")
    private WebElement goToBookStoreButton;

    public ProfilePage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }


    @Step("Click 'Go To Book Store' button")
    public void goToBookStore() {
        ElementActions.click(goToBookStoreButton);
    }
}
