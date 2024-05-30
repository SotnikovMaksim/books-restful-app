package ru.conus.books.api.rest.v1.book.dto;

import lombok.Builder;

import java.util.Set;

@Builder
public record BookEntry(
        Long id,
        String title,
        String isbn,
        Set<Long> authorIds
) {}
