package test.database;

import lombok.Data;

@Data
public class ClassicBook {
    private String username;
    private String bookTitle;

    public ClassicBook(String username, String bookTitle) {
        this.username = username;
        this.bookTitle = bookTitle;
    }

    @Override
    public String toString() {
        return username + " -> " + bookTitle;
    }
}
