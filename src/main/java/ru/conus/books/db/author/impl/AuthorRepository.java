package ru.conus.books.db.author.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.conus.books.db.author.impl.entity.AuthorEntity;

public interface AuthorRepository extends JpaRepository<AuthorEntity, Long> {
}
