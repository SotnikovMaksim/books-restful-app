package ru.conus.books.api.rest.v1.book.dto;

import java.util.Set;

public record AddBookRequest(
        String title,
        String isbn,
        Set<Long> authorIds
) {}
