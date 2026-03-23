package org.ui.pages;

import io.qameta.allure.Step;
import org.config.ConfigManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.ui.actions.ElementActions;
import org.ui.driver.DriverManager;

public class LoginPage extends BasePage {

    @FindBy(id = "userName")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "login")
    private WebElement loginButton;

    @FindBy(id = "name")
    private WebElement errorMessage;

    public LoginPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    @Step("Open Login page")
    public void open() {
        DriverManager.getDriver().get(ConfigManager.getConfig().urlLogin());
    }

    @Step("Enter username: {username}")
    public void enterUsername(String username) {
        ElementActions.type(usernameInput, username);
    }

    @Step("Enter password")
    public void enterPassword(String password) {
        ElementActions.type(passwordInput, password);
    }

    @Step("Click Login button")
    public void clickLogin() {
        ElementActions.click(loginButton);
    }

    @Step("Login with username: {username}")
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    @Step("Get error message text")
    public String getErrorMessageText() {
        return errorMessage.getText();
    }

    @Step("Check that Login page is opened")
    public boolean isLoginPageOpened() {
        return usernameInput.isDisplayed();
    }

    @Step("Checking that the URL has not changed")
    public boolean isLoginPageUrl() {
        return DriverManager.getDriver()
                .getCurrentUrl()
                .contains("login");
    }
}
