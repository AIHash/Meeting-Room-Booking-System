package ro.uvt.mrbs.mappers;

import ro.uvt.mrbs.entities.Book;
import ro.uvt.mrbs.models.OutBoundBook;

/**
 *
 * @author Zbiera Alexandru-Robert
 */
public class BookMapper {

    private BookMapper() {
    }

    public static OutBoundBook toOutBound(Book book) {
        return new OutBoundBook(book.getStartDate(), book.getEndDate(), book.getRoom());
    }
}
