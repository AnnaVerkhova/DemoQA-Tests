package test.ui.smokeUITests;

import org.config.ConfigManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.ui.pages.BooksPage;
import org.ui.pages.LoginPage;
import org.ui.pages.ProfilePage;
import test.security.PasswordManager;
import test.ui.BaseTest;

public class BookSearchTest extends BaseTest {


    @Test(description = "Search book in Book Store")
    public void searchBookTest() {

        LoginPage loginPage = new LoginPage();
        ProfilePage profilePage = new ProfilePage();
        BooksPage bookStorePage = new BooksPage();

        loginPage.open();

        loginPage.login(
                ConfigManager.getConfig().username(),
                PasswordManager.getDecryptedPassword(ConfigManager.getConfig())
        );

        Assert.assertTrue(
                profilePage.isProfilePageOpened(),
                "Profile page did not open"
        );

        profilePage.goToBookStore();

        Assert.assertTrue(
                bookStorePage.isBooksPageOpened(),
                "Book Store page did not open"
        );

        String bookName = "Programming JavaScript Applications";

        bookStorePage.searchBook(bookName);

        Assert.assertTrue(
                bookStorePage.isBookPresent(bookName),
                "Search results do not match expected book"
        );
    }
}
