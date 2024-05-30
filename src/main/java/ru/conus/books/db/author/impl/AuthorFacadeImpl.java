package ru.conus.books.db.author.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorFacadeImpl {

    private final AuthorRepository authorRepository;
}
