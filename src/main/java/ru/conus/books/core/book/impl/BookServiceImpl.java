package ru.conus.books.core.book.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import ru.conus.books.core.author.AuthorService;
import ru.conus.books.core.book.BookService;
import ru.conus.books.core.exception.BusinessException;
import ru.conus.books.db.book.BookFacade;
import ru.conus.books.db.book.dto.Book;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookFacade bookFacade;

    private final AuthorService authorService;

    @Override
    public Book addBook(Book book) {
        checkAllAuthorsExist(book);
        return bookFacade.save(book);
    }

    private void checkAllAuthorsExist(Book book) {
        var specifiedAuthorsIds = book.getAuthorIds();
        var foundAuthors = authorService.findAllAuthorsByTheirId(specifiedAuthorsIds);
        if (foundAuthors.size() != specifiedAuthorsIds.size()) {
            throw new BusinessException(
                    HttpStatus.NOT_FOUND,
                    "Some or all authors were not found by provided ids: " + specifiedAuthorsIds
            );
        }
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookFacade.findById(id);
    }

    @Override
    public Book findByIdThrowing(Long id) {
        var optionalBook = bookFacade.findById(id);
        return optionalBook.orElseThrow(() -> new BusinessException(
                HttpStatus.NOT_FOUND,
                "Book not found by id: " + id
        ));
    }

    @Override
    public void deleteBook(Long bookId) {
        bookFacade.delete(bookId);
    }

    @Override
    public List<Book> findAllBooksFiltered(String title, String isbn, String authorName) {
        return bookFacade.findAllBooksFilteredBy(title, isbn, authorName);
    }
}
