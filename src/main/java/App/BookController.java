package App;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public Iterable findAll(){
        return bookRepository.findAll();
    }
    @GetMapping("/title/{bookTitle}")
    public List findByTitle(@PathVariable String bookTitle) {
        return bookRepository.findByTitle(bookTitle);
    }

    @GetMapping("/{id}")
    public Book findOne(@PathVariable Long id) {
        return bookRepository.findById(id)
                .orElseThrow(BookNotFoundException::new);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookDTO create(@RequestBody BookDTO bookDTO) {
        return toDTO(bookRepository.save(toEntity(bookDTO)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        bookRepository.findById(id)
                .orElseThrow(BookNotFoundException::new);
        bookRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Book updateBook(@RequestBody Book book, @PathVariable Long id) throws BookIdMismatchException {
        if (!book.getId().equals(id)) {
            throw new BookIdMismatchException();
        }
        bookRepository.findById(id)
                .orElseThrow(BookNotFoundException::new);
        return bookRepository.save(book);
    }
    private Book toEntity(BookDTO DTO){
        Book book = new Book();
        book.setAuthor(DTO.getAuthor());
        book.setTitle(DTO.getTitle());
        book.setCover(DTO.getCover());
        book.setRating(DTO.getRating());
        book.setReview(DTO.getReview());
        return book;
    }
    private BookDTO toDTO(Book book){
        BookDTO dto = new BookDTO();
        dto.setId(book.getId());
        dto.setAuthor(book.getAuthor());
        dto.setTitle(book.getTitle());
        dto.setCover(book.getCover());
        dto.setRating(book.getRating());
        dto.setReview(book.getReview());
        return dto;
    }
}
