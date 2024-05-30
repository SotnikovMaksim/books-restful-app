package ru.conus.books.core.author.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.conus.books.core.author.AuthorService;
import ru.conus.books.db.author.dto.Author;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    @Override
    public List<Author> findAll() {
        return List.of();
    }

    @Override
    public Author addAuthor(Author author) {
        return null;
    }

    @Override
    public Author updateAuthor(Long id, Author updatedAuthor) {
        return null;
    }

    @Override
    public void deleteAuthor(Long authorId) {

    }
}
