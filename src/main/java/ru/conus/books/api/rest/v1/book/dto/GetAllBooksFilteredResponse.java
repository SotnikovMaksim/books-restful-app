package ru.conus.books.api.rest.v1.book.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record GetAllBooksFilteredResponse(
        List<BookEntry> books
) { }
