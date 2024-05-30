package ru.conus.books.api.rest.v1.book.dto;

import lombok.Builder;

@Builder
public record GetBookResponse(
        BookEntry book
) {}
