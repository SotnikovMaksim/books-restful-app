package ru.conus.books.api.rest.v1.author;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import ru.conus.books.api.rest.v1.author.dto.AddAuthorRequest;
import ru.conus.books.api.rest.v1.author.dto.GetAllAuthorsResponse;
import ru.conus.books.api.rest.v1.author.dto.UpdateAuthorRequest;
import ru.conus.books.core.author.AuthorService;
import ru.conus.books.db.author.dto.Author;

import java.net.URI;

import static ru.conus.books.api.rest.v1.author.AuthorControllerRequestMapper.convert;
import static ru.conus.books.api.rest.v1.author.AuthorControllerResponseMapper.convertToGetAllAuthorsResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/authors")
public class AuthorController {

    private final AuthorService authorService;

    @PostMapping
    public ResponseEntity<Void> addAuthor(
            UriComponentsBuilder uriComponentsBuilder,
            @RequestBody AddAuthorRequest request
    ) {
        var createdAuthor = authorService.addAuthor(convert(request));
        var location = buildLocationUri(uriComponentsBuilder, createdAuthor);
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{authorId}")
    public ResponseEntity<Void> updateAuthor(
            @PathVariable Long authorId,
            @RequestBody UpdateAuthorRequest request
    ) {
        authorService.updateAuthor(authorId, convert(request));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{authorId}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long authorId) {
        authorService.deleteAuthor(authorId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<GetAllAuthorsResponse> getAuthors() {
        var authors = authorService.findAll();
        return ResponseEntity.ok(convertToGetAllAuthorsResponse(authors));
    }

    private URI buildLocationUri(UriComponentsBuilder uriComponentsBuilder, Author createdAuthor) {
        return uriComponentsBuilder.path("/v1/authors/{id}")
                .buildAndExpand(createdAuthor.getId())
                .toUri();
    }
}
