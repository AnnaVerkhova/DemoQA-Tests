package test.api.integrationTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import test.database.ClassicBook;
import test.database.GetClassicBooks;

import java.util.List;

public class GetClassicBooksTest {
    @Test(description = "Check that the classic_books table contains test data")
    public void testGetAllBooks() {
        List<ClassicBook> books = GetClassicBooks.getAllBooks();
        Assert.assertFalse(books.isEmpty(), "The book list is empty after selecting from the classic_books table");

        boolean hasAnna = books.stream().anyMatch(b -> b.getUsername().equals("Anna"));
        boolean hasAlisa = books.stream().anyMatch(b -> b.getUsername().equals("Alisa"));
        boolean hasOlga = books.stream().anyMatch(b -> b.getUsername().equals("Olga"));

        Assert.assertTrue(hasAnna, "User Anna was not found in the classic_books table");
        Assert.assertTrue(hasAlisa, "User Alisa was not found in the classic_books table");
        Assert.assertTrue(hasOlga, "User Olga was not found in the classic_books table");

        boolean hasPride = books.stream().anyMatch(b -> b.getBookTitle().equals("Pride and Prejudice"));
        boolean hasJane = books.stream().anyMatch(b -> b.getBookTitle().equals("Jane Eyre"));
        boolean hasWar = books.stream().anyMatch(b -> b.getBookTitle().equals("War and Peace"));

        Assert.assertTrue(hasPride, "The book 'Pride and Prejudice' was not found in the table");
        Assert.assertTrue(hasJane, "The book 'Jane Eyre' was not found in the table");
        Assert.assertTrue(hasWar, "The book 'War and Peace' was not found in the table");

        books.forEach(System.out::println);
    }
}
