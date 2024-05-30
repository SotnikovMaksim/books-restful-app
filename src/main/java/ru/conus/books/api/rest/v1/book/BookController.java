package ru.conus.books.api.rest.v1.book;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import ru.conus.books.api.rest.v1.book.dto.AddBookRequest;
import ru.conus.books.api.rest.v1.book.dto.GetAllBooksFilteredResponse;
import ru.conus.books.api.rest.v1.book.dto.GetBookResponse;
import ru.conus.books.core.book.BookService;
import ru.conus.books.db.book.dto.Book;

import java.net.URI;

import static ru.conus.books.api.rest.v1.book.BookControllerRequestMapper.convert;
import static ru.conus.books.api.rest.v1.book.BookControllerResponseMapper.convertToGetAllBooksFilteredResponse;
import static ru.conus.books.api.rest.v1.book.BookControllerResponseMapper.convertToGetBookResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/books")
public class BookController {

    private final BookService bookService;

    @PostMapping
    public ResponseEntity<Void> addBook(
            UriComponentsBuilder uriComponentsBuilder,
            @RequestBody AddBookRequest request
    ) {
        var createdBook = bookService.addBook(convert(request));
        var location = buildLocationUri(uriComponentsBuilder, createdBook);
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<GetBookResponse> getBook(@PathVariable Long bookId) {
        var book = bookService.findByIdThrowing(bookId);
        return ResponseEntity.ok(convertToGetBookResponse(book));
    }

    @GetMapping
    public ResponseEntity<GetAllBooksFilteredResponse> getBooks(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String isbn,
            @RequestParam(required = false) String authorName
    ) {
        var books = bookService.findAllBooksFiltered(title, isbn, authorName);
        return ResponseEntity.ok(convertToGetAllBooksFilteredResponse(books));
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long bookId) {
        bookService.deleteBook(bookId);
        return ResponseEntity.ok().build();
    }

    private URI buildLocationUri(UriComponentsBuilder uriComponentsBuilder, Book createdBook) {
        return uriComponentsBuilder.path("/v1/books/{id}")
                .buildAndExpand(createdBook.getId())
                .toUri();
    }
}
