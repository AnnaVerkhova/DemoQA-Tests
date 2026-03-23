package test.ui.smokeUITests;

import org.config.ConfigManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.ui.pages.LoginPage;
import test.ui.BaseTest;

public class LoginInvalidTest extends BaseTest {

    @Test(description = "Unsuccessful login with invalid password")
    public void failLoginTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.open();
        loginPage.enterUsername(ConfigManager.getConfig().username());
        loginPage.enterPassword(ConfigManager.getConfig().invalidPassword());
        loginPage.clickLogin();

        Assert.assertEquals(
                loginPage.getErrorMessageText(),
                "Invalid username or password!",
                "Error message did not appear after invalid login"
        );

        Assert.assertTrue(
                loginPage.isLoginPageOpened(),
                "User should remain on login page after failed login"
        );
        Assert.assertTrue(
                loginPage.isLoginPageUrl(),
                "User was redirected from login page after failed login"
        );
    }
}
