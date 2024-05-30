package ru.conus.books.core.author;

import ru.conus.books.db.author.dto.Author;

import java.util.List;

public interface AuthorService {
    List<Author> findAll();

    Author addAuthor(Author author);

    Author updateAuthor(Long id, Author updatedAuthor);

    void deleteAuthor(Long authorId);
}
