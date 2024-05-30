package ru.conus.books.core.author.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import ru.conus.books.core.author.AuthorService;
import ru.conus.books.core.exception.BusinessException;
import ru.conus.books.db.author.AuthorFacade;
import ru.conus.books.db.author.dto.Author;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorFacade authorFacade;

    @Override
    public List<Author> findAll() {
        return authorFacade.findAll();
    }

    @Override
    public Author addAuthor(Author author) {
        return authorFacade.save(author);
    }

    @Override
    public Author updateAuthor(Long id, Author updatedAuthor) {
        var author = findByIdThrowing(id);
        updateFields(author, updatedAuthor);
        return authorFacade.save(author);
    }

    private void updateFields(final Author currentAuthor, final Author updatedAuthor) {
        currentAuthor.setName(updatedAuthor.getName());
    }

    @Override
    public Optional<Author> findById(Long id) {
        return authorFacade.findById(id);
    }

    @Override
    public Author findByIdThrowing(Long id) {
        var optionalAuthor = authorFacade.findById(id);
        return optionalAuthor.orElseThrow(() -> new BusinessException(
                HttpStatus.NOT_FOUND,
                "Author not found with id " + id
        ));
    }

    @Override
    public void deleteAuthor(Long authorId) {
        authorFacade.delete(authorId);
    }

    @Override
    public List<Author> findAllAuthorsByTheirId(Iterable<Long> authorIds) {
        return authorFacade.findAllByIds(authorIds);
    }
}
