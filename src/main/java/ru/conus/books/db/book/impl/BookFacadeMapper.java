package ru.conus.books.db.book.impl;

import lombok.experimental.UtilityClass;
import ru.conus.books.db.book.dto.Book;
import ru.conus.books.db.book.impl.entity.BookEntity;

import java.util.List;

@UtilityClass
class BookFacadeMapper {

    static Book convert(BookEntity entity) {
        return Book.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .isbn(entity.getIsbn())
                .authorIds(entity.getAuthorIds())
                .build();
    }

    static BookEntity convert(Book entity) {
        return BookEntity.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .isbn(entity.getIsbn())
                .authorIds(entity.getAuthorIds())
                .build();
    }

    static List<BookEntity> convertToEntityList(List<Book> books) {
        return books.stream().map(BookFacadeMapper::convert).toList();
    }

    static List<Book> convertToDtoList(List<BookEntity> books) {
        return books.stream().map(BookFacadeMapper::convert).toList();
    }
}
