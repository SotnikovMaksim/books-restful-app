package ru.conus.books.core.book.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.conus.books.core.book.BookService;
import ru.conus.books.db.book.dto.Book;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    @Override
    public Book addBook(Book book) {
        return null;
    }

    @Override
    public Optional<Book> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Book findByIdThrowing(Long id) {
        return null;
    }

    @Override
    public void deleteBook(Long bookId) {

    }

    @Override
    public List<Book> findAllBooksFiltered(String title, String isbn, String authorName) {
        return List.of();
    }
}
