package ru.conus.books.db.author;

import ru.conus.books.db.author.dto.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorFacade {
    List<Author> findAll();

    List<Author> findAllByIds(Iterable<Long> ids);

    Author save(Author author);

    void delete(Long authorId);

    Optional<Author> findById(Long id);
}
