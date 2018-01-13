package ro.uvt.mrbs.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.uvt.mrbs.entities.Book;
import ro.uvt.mrbs.mappers.BookMapper;
import ro.uvt.mrbs.models.OutBoundBook;
import ro.uvt.mrbs.services.ShowBooks;

/**
 *
 * @author Zbiera Alexandru-Robert
 */
@RestController
@RequestMapping("/book")
public class ShowBooksController {

    private final ShowBooks showBooks;

    @Autowired
    public ShowBooksController(ShowBooks showBooks) {
        this.showBooks = showBooks;
    }

    @GetMapping
    public List<OutBoundBook> getBooks(Pageable pageable) {
        List<OutBoundBook> books = new ArrayList<>();
        Page<Book> pageBooks = showBooks.getBooks(pageable);
        pageBooks.getContent().forEach((b) -> {
            books.add(BookMapper.toOutBound(b));
        });
        return books;
    }
}
