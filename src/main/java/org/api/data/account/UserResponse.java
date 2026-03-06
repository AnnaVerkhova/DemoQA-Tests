package org.api.data.account;

import lombok.Data;

import java.util.List;

@Data
public class UserResponse {
    private String userId;
    private String username;
    private List<BookInfo> books;

    @Data
    public static class BookInfo {
        private String isbn;
        private String title;
        private String subTitle;
        private String author;
        private String publish_date;
        private String publisher;
        private Integer pages;
        private String description;
        private String website;
    }
}
