package ru.conus.books.db.author.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.conus.books.db.author.AuthorFacade;
import ru.conus.books.db.author.dto.Author;

import java.util.List;
import java.util.Optional;

import static ru.conus.books.db.author.impl.AuthorFacadeMapper.convert;
import static ru.conus.books.db.author.impl.AuthorFacadeMapper.convertToDtoList;

@Service
@RequiredArgsConstructor
public class AuthorFacadeImpl implements AuthorFacade {

    private final AuthorRepository authorRepository;

    @Override
    public List<Author> findAll() {
        return convertToDtoList(authorRepository.findAll());
    }

    @Override
    public List<Author> findAllByIds(Iterable<Long> ids) {
        return convertToDtoList(authorRepository.findAllById(ids));
    }

    @Override
    public Author save(Author author) {
        return convert(authorRepository.save(convert(author)));
    }

    @Override
    public void delete(Long id) {
        authorRepository.deleteById(id);
    }

    @Override
    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id).map(AuthorFacadeMapper::convert);
    }
}
