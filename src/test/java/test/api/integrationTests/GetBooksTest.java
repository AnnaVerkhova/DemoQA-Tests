package test.api.integrationTests;

import io.restassured.response.Response;
import org.api.data.bookstore.BooksResponse;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.api.ApiSender;
import test.api.BaseApiTest;

public class GetBooksTest extends BaseApiTest {
    @Test
    public void getBook(){
        Response response = ApiSender.getBooks();
        response.prettyPrint();
        Assert.assertEquals(response.statusCode(),200);
        BooksResponse booksResponse = response.as(BooksResponse.class);
        Assert.assertNotNull(booksResponse.getBooks());
        Assert.assertFalse(booksResponse.getBooks().isEmpty());
    }
}
