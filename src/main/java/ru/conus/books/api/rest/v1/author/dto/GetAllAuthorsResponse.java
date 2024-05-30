package ru.conus.books.api.rest.v1.author.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record GetAllAuthorsResponse(
        List<AuthorEntry> authors
) {}
