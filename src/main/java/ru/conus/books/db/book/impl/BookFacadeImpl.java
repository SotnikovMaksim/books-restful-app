package ru.conus.books.db.book.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.conus.books.db.book.BookFacade;

@Service
@RequiredArgsConstructor
public class BookFacadeImpl implements BookFacade {

    private final BookRepository bookRepository;
}
