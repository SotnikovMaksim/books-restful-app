package ru.conus.books.api.rest.v1.book;

import lombok.experimental.UtilityClass;
import ru.conus.books.api.rest.v1.book.dto.BookEntry;
import ru.conus.books.api.rest.v1.book.dto.GetAllBooksFilteredResponse;
import ru.conus.books.api.rest.v1.book.dto.GetBookResponse;
import ru.conus.books.db.book.dto.Book;

import java.util.List;

@UtilityClass
class BookControllerResponseMapper {

    static GetBookResponse convertToGetBookResponse(Book dto) {
        return GetBookResponse.builder()
                .book(convertToBookEntry(dto))
                .build();
    }

    static BookEntry convertToBookEntry(Book dto) {
        return BookEntry.builder()
                .title(dto.getTitle())
                .id(dto.getId())
                .isbn(dto.getIsbn())
                .authorIds(dto.getAuthorIds())
                .build();
    }

    static GetAllBooksFilteredResponse convertToGetAllBooksFilteredResponse(List<Book> books) {
        return GetAllBooksFilteredResponse.builder()
                .books(convertToBookEntriesList(books))
                .build();
    }

    private static List<BookEntry> convertToBookEntriesList(List<Book> books) {
        return books.stream()
                .map(BookControllerResponseMapper::convertToBookEntry)
                .toList();
    }
}
