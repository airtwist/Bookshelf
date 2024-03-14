package App.mapper;

import App.dto.BookDTO;
import App.entity.Book;

public class BooksMapper {
    public static BookDTO mapToDTO(Book book){
        return new BookDTO(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getCover(),
                book.getRating(),
                book.getReview()
        );
    }
    public static Book mapToEntity (BookDTO bookDTO){
        return new Book(
                bookDTO.getId(),
                bookDTO.getTitle(),
                bookDTO.getAuthor(),
                bookDTO.getCover(),
                bookDTO.getRating(),
                bookDTO.getReview()
        );
    }
}
