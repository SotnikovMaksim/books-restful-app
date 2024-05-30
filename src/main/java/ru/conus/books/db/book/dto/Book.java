package ru.conus.books.db.book.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class Book {
    private Long id;
    private String title;
    private String isbn;
    private Set<Long> authorIds;
}
