package App.controller;

import App.entity.Book;
import App.dto.BookDTO;
import App.exception.BookIdMismatchException;
import App.exception.BookNotFoundException;
import App.mapper.BooksMapper;
import App.repository.BookRepository;
import App.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Tag(
        name = "Книги",
        description = "Все методы для работы с книгами"
)

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/books")

public class BookController {


    private BookService bookService;
    @Operation(summary = "Create a book", description = "Creates book")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully created"),
    })
    @PostMapping
    public ResponseEntity<BookDTO> createBook(@RequestBody BookDTO bookDTO) {
        BookDTO savedBook = bookService.createBook(bookDTO);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }
    @Operation(summary = "Get a book by id", description = "Returns a book as per the id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
    })
    @GetMapping("{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable("id")
                                                   @Parameter(name = "id", description = "Book id", example = "1")
                                                   Long bookId) {
        BookDTO bookDTO = bookService.getBookByID(bookId);
        return ResponseEntity.ok(bookDTO);
    }
    @Operation(summary = "Get all books", description = "Returns all books")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
    })
    @GetMapping
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        List<BookDTO> bookDTO = bookService.getAllbooks();
        return ResponseEntity.ok(bookDTO);
    }
    @Operation(summary = "Update a book by id", description = "Updates a book as per the id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully updated"),
    })
    @PutMapping("/{id}")
    public ResponseEntity<BookDTO> updateBook(@PathVariable("id") Long bookId,
                                              @RequestBody BookDTO updatedBook) {
        BookDTO bookDTO = bookService.updateBook(bookId, updatedBook);
        return ResponseEntity.ok(bookDTO);
    }

    @Operation(summary = "Delete a book by id", description = "Deletes a book as per the id")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable("id") Long bookId) {
        bookService.deleteBook(bookId);
        return ResponseEntity.ok("Book deleted successfully!");
    }
}
