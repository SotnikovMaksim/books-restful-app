package ru.conus.books.db.book.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.conus.books.db.book.BookFacade;
import ru.conus.books.db.book.dto.Book;

import java.util.List;
import java.util.Optional;

import static ru.conus.books.db.book.impl.BookFacadeMapper.convert;
import static ru.conus.books.db.book.impl.BookFacadeMapper.convertToDtoList;

@Service
@RequiredArgsConstructor
public class BookFacadeImpl implements BookFacade {

    private final BookRepository bookRepository;

    @Override
    public Book save(Book book) {
        return convert(bookRepository.save(convert(book)));
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id).map(BookFacadeMapper::convert);
    }

    @Override
    public void delete(Long bookId) {
        bookRepository.deleteById(bookId);
    }

    @Override
    public List<Book> findAllBooksFilteredBy(String title, String isbn, String authorName) {
        var spec = Specification.where(BookEntitySpecification.hasTitle(title))
                .and(BookEntitySpecification.hasIsbn(isbn))
                .and(BookEntitySpecification.hasAuthorName(authorName));
        return convertToDtoList(bookRepository.findAll(spec));
    }
}
