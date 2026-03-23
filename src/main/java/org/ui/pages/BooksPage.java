package org.ui.pages;


import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.ui.actions.ElementActions;
import org.ui.driver.DriverManager;
import org.ui.waits.WaitUtils;

import java.util.List;

public class BooksPage extends BasePage{

    @FindBy(id = "searchBox")
    private WebElement searchInput;

    @FindBy(css = ".rt-tbody .rt-tr-group .mr-2")
    private List<WebElement> bookTitles;

    public BooksPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    @Step("Check that Book Store page is opened")
    public boolean isBooksPageOpened() {
        return DriverManager.getDriver()
                .getCurrentUrl()
                .contains("books");
    }

    @Step("Search for book: {bookName}")
    public void searchBook(String bookName) {
        ElementActions.type(searchInput, bookName);

        WaitUtils.waitForVisible(
                DriverManager.getDriver().findElement(
                        By.xpath("//a[text()='" + bookName + "']")
                )
        );
    }

    @Step("Get number of books in search results")
    public int getBooksCount() {
        return bookTitles.size();
    }

    @Step("Verify that book '{bookName}' is present")
    public boolean isBookPresent(String bookName) {

        return DriverManager.getDriver()
                .findElements(By.xpath("//a[text()='" + bookName + "']"))
                .size() == 1;
    }
}
