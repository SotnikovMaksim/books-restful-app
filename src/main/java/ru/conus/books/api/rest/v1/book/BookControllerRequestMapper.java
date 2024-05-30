package ru.conus.books.api.rest.v1.book;

import lombok.experimental.UtilityClass;
import ru.conus.books.api.rest.v1.book.dto.AddBookRequest;
import ru.conus.books.db.book.dto.Book;

@UtilityClass
class BookControllerRequestMapper {

    static Book convert(AddBookRequest request) {
        return Book.builder()
                .title(request.title())
                .isbn(request.isbn())
                .authorIds(request.authorIds())
                .build();
    }
}
