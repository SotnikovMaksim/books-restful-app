package ru.conus.books.api.rest.v1.author;

import lombok.experimental.UtilityClass;
import ru.conus.books.api.rest.v1.author.dto.AddAuthorRequest;
import ru.conus.books.api.rest.v1.author.dto.UpdateAuthorRequest;
import ru.conus.books.db.author.dto.Author;

@UtilityClass
class AuthorControllerRequestMapper {

    static Author convert(AddAuthorRequest request) {
        return Author.builder()
                .name(request.name())
                .build();
    }

    static Author convert(UpdateAuthorRequest request) {
        return Author.builder()
                .name(request.name())
                .build();
    }
}
