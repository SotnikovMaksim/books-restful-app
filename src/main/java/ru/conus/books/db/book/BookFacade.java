package ru.conus.books.db.book;

import ru.conus.books.db.book.dto.Book;

import java.util.List;
import java.util.Optional;

public interface BookFacade {
    Book save(Book book);

    Optional<Book> findById(Long id);

    void delete(Long bookId);

    List<Book> findAllBooksFilteredBy(String title, String isbn, String authorName);
}
