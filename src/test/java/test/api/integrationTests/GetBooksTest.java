package test.api.integrationTests;

import io.restassured.response.Response;
import org.api.data.bookstore.BooksResponse;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.api.ApiSender;
import test.api.BaseApiTest;

public class  GetBooksTest extends BaseApiTest {
    @Test
    public void getBook() {

        Response response = ApiSender.getBooks();
        Assert.assertEquals(response.statusCode(),200,
                "Expected status code 200, but received: " + response.statusCode());
        BooksResponse booksResponse = response.as(BooksResponse.class);

        Assert.assertNotNull(booksResponse.getBooks(),"The book list is null");
        Assert.assertFalse(booksResponse.getBooks().isEmpty(),"The answer with the books was empty");
        Assert.assertTrue(booksResponse.getBooks().size() > 0,"The size of the book array is 0");
    }
}