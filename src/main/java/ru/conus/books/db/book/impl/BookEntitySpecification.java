package ru.conus.books.db.book.impl;

import org.springframework.data.jpa.domain.Specification;
import ru.conus.books.db.book.impl.entity.BookEntity;

/**
 * This auxiliary class is used for effectively filtering books
 */
public class BookEntitySpecification {

    public static Specification<BookEntity> hasTitle(String title) {
        return (root, query, criteriaBuilder) -> 
            title == null ? null : criteriaBuilder.like(criteriaBuilder.lower(root.get("title")), "%" + title.toLowerCase() + "%");
    }

    public static Specification<BookEntity> hasIsbn(String isbn) {
        return (root, query, criteriaBuilder) -> 
            isbn == null ? null : criteriaBuilder.equal(root.get("isbn"), isbn);
    }

    public static Specification<BookEntity> hasAuthorName(String authorName) {
        return (root, query, criteriaBuilder) -> {
            if (authorName == null) {
                return null;
            }
            return criteriaBuilder.like(criteriaBuilder.lower(root.join("authorIds").get("name")), "%" + authorName.toLowerCase() + "%");
        };
    }
}
