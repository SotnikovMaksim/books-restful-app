package ru.conus.books.db.author.impl;

import lombok.experimental.UtilityClass;
import ru.conus.books.db.author.dto.Author;
import ru.conus.books.db.author.impl.entity.AuthorEntity;

import java.util.List;

@UtilityClass
class AuthorFacadeMapper {

    static Author convert(AuthorEntity entity) {
        return Author.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    static AuthorEntity convert(Author entity) {
        return AuthorEntity.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    static List<Author> convertToDtoList(List<AuthorEntity> entities) {
        return entities.stream()
                .map(AuthorFacadeMapper::convert)
                .toList();
    }

    static List<AuthorEntity> convertToEntitiesList(List<Author> entities) {
        return entities.stream()
                .map(AuthorFacadeMapper::convert)
                .toList();
    }
}
