package ro.uvt.mrbs.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ro.uvt.mrbs.entities.Book;
import ro.uvt.mrbs.repositories.BookRepository;

/**
 *
 * @author Zbiera Alexandru-Robert
 */
public class ShowBooks {

    private final BookRepository bookRepository;

    @Autowired
    public ShowBooks(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Page<Book> getBooks(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }
}
