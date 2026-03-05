package test.database;

import org.testng.Assert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetClassicBooks {

    public static List<ClassicBook> getAllBooks() {
        List<ClassicBook> books = new ArrayList<>();
        String sql = "SELECT username, book_title FROM classic_books";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            Assert.assertTrue(rs.next(), "Таблица classic_books пуста или данные не найдены");
            books.add(new ClassicBook(
                    rs.getString("username"),
                    rs.getString("book_title")
            ));
            while (rs.next()) {
                books.add(new ClassicBook(
                        rs.getString("username"),
                        rs.getString("book_title")
                ));
            }
        } catch (SQLException e) {
            Assert.fail("Ошибка при получении данных из таблицы classic_books: " + e.getMessage());
        }
        Assert.assertFalse(books.isEmpty(), "Список книг пуст после выборки из таблицы classic_books");

        return books;
    }
}
