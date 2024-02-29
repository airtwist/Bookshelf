package App.service;

import App.dto.BookDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    BookDTO createBook(BookDTO bookDTO);

    BookDTO getBookByID(Long bookId);

    List<BookDTO> getAllbooks();

    BookDTO updateBook (Long bookId,BookDTO updatedBook);

    void deleteBook (Long bookId);

}
