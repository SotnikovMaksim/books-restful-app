package ru.conus.books.db.author.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Author {
    private Long id;
    private String name;
}