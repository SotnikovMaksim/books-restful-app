package ru.conus.books.db.book.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.conus.books.db.book.impl.entity.BookEntity;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
}
