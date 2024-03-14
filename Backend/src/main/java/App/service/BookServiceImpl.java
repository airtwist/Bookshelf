package App.service;

import App.dto.BookDTO;
import App.entity.Book;
import App.exception.BookNotFoundException;
import App.mapper.BooksMapper;
import App.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class BookServiceImpl implements BookService{


    private BookRepository bookRepository;
    @Override
    public BookDTO createBook(BookDTO bookDTO) {

        Book book = BooksMapper.mapToEntity(bookDTO);
        Book savedBook = bookRepository.save(book);
        return BooksMapper.mapToDTO(savedBook);
    }

    @Override
    public BookDTO getBookByID(Long bookId) {
      Book book =  bookRepository.findById(bookId)
                .orElseThrow(()->
                        new BookNotFoundException("Book is not exist with given id : " + bookId ));
      return BooksMapper.mapToDTO(book);
    }

    @Override
    public List<BookDTO> getAllbooks() {
       List<Book> books = bookRepository.findAll();
       return books.stream().map(BooksMapper::mapToDTO)
               .collect(Collectors.toList());

    }

    @Override
    public BookDTO updateBook (Long bookId, BookDTO updatedBook) {

       Book book = bookRepository.findById(bookId).orElseThrow(()-> new BookNotFoundException("Book is not exist with given id"+ bookId));

        book.setTitle(updatedBook.getTitle());
        book.setAuthor(updatedBook.getAuthor());
        book.setCover(updatedBook.getCover());
        book.setReview(updatedBook.getReview());
        book.setRating(updatedBook.getRating());

        Book updatedBookObj = bookRepository.save(book);

        return BooksMapper.mapToDTO(updatedBookObj);
    }

    @Override
    public void deleteBook(Long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(
                ()-> new BookNotFoundException("Book is not exist with given id"+ bookId)
        );
        bookRepository.deleteById(bookId);
    }
}
