package ru.conus.books.core.book;

import ru.conus.books.db.book.dto.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    Book addBook(Book book);

    Optional<Book> findById(Long id);

    Book findByIdThrowing(Long id);

    void deleteBook(Long bookId);

    List<Book> findAllBooksFiltered(String title, String isbn, String authorName);
}
