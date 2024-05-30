package ru.conus.books.api.rest.v1.author;

import lombok.experimental.UtilityClass;
import ru.conus.books.api.rest.v1.author.dto.AuthorEntry;
import ru.conus.books.api.rest.v1.author.dto.GetAllAuthorsResponse;
import ru.conus.books.api.rest.v1.author.dto.GetAuthorResponse;
import ru.conus.books.db.author.dto.Author;

import java.util.List;

@UtilityClass
class AuthorControllerResponseMapper {

    static GetAuthorResponse convertToGetAuthorResponse(Author author) {
        return GetAuthorResponse.builder()
                .author(convertToAuthorEntry(author))
                .build();
    }

    static GetAllAuthorsResponse convertToGetAllAuthorsResponse(List<Author> authors) {
        return GetAllAuthorsResponse.builder()
                .authors(convertToAuthorEntryList(authors))
                .build();
    }

    private static List<AuthorEntry> convertToAuthorEntryList(List<Author> authors) {
        return authors.stream()
                .map(AuthorControllerResponseMapper::convertToAuthorEntry)
                .toList();
    }

    static AuthorEntry convertToAuthorEntry(Author author) {
        return AuthorEntry.builder()
                .id(author.getId())
                .name(author.getName())
                .build();
    }
}
