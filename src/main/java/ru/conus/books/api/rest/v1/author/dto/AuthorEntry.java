package ru.conus.books.api.rest.v1.author.dto;

import lombok.Builder;

@Builder
public record AuthorEntry(
        Long id,
        String name
) {}
