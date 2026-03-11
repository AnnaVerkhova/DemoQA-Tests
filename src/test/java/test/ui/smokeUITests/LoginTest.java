package test.ui.smokeUITests;

import org.config.ConfigManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.ui.pages.LoginPage;
import org.ui.pages.ProfilePage;
import test.security.PasswordManager;
import test.ui.BaseTest;

public class LoginTest extends BaseTest {

    @Test(description = "Successful login test")
    public void successfulLoginTest() {

        LoginPage loginPage = new LoginPage();
        loginPage.open();
        loginPage.login(
                ConfigManager.getConfig().username(),
                PasswordManager.getDecryptedPassword(ConfigManager.getConfig())
        );

        ProfilePage profilePage = new ProfilePage();
        Assert.assertTrue(
                profilePage.isProfilePageOpened(),
                "Profile page did not open after login"
        );
    }
}
