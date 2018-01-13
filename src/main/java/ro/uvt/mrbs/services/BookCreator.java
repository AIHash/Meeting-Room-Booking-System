package ro.uvt.mrbs.services;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ro.uvt.mrbs.entities.Book;
import ro.uvt.mrbs.entities.Room;
import ro.uvt.mrbs.entities.User;
import ro.uvt.mrbs.repositories.BookRepository;

/**
 *
 * @author Zbiera Alexandru-Robert
 */
@Service
public class BookCreator {

    private final BookRepository bookRepository;

    @Autowired
    public BookCreator(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book createBook(User user, Room room, Date startDate, Date endDate) {
        if (isBookable(room, startDate, endDate)) {
            Book book = new Book();
            book.setRoom(room);
            book.setUser(user);
            book.setStartDate(startDate);
            book.setEndDate(endDate);
            return bookRepository.save(book);
        } else {
            return null;
        }
    }

    private boolean isBookable(Room room, Date startDate, Date endDate) {
        Long nrOfBooks = bookRepository.count();
        int nrOfBooksPerPage = 10;
        Long nrOfPages = nrOfBooks / nrOfBooksPerPage;
        Page<Book> books;
        for (int i = 0; i < nrOfPages; i++) {
            books = bookRepository.findAllByRoom(room, new PageRequest(i, nrOfBooksPerPage));
            if (books.getContent().stream().anyMatch(x
                    -> (startDate.after(x.getStartDate()) && startDate.before(x.getEndDate()))
                    || (endDate.after(x.getStartDate()) && endDate.before(x.getEndDate())))) {
                return false;
            }
        }
        return true;
    }

}
