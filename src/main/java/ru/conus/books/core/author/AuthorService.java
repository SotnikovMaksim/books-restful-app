package ru.conus.books.core.author;

import ru.conus.books.db.author.dto.Author;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface AuthorService {
    List<Author> findAll();

    Author addAuthor(Author author);

    Author updateAuthor(Long id, Author updatedAuthor);

    Optional<Author> findById(Long id);

    Author findByIdThrowing(Long id);

    void deleteAuthor(Long authorId);

    List<Author> findAllAuthorsByTheirId(Iterable<Long> authorIds);
}
