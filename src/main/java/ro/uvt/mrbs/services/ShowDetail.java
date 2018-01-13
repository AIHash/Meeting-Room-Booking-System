package ro.uvt.mrbs.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.uvt.mrbs.entities.UserDetail;
import ro.uvt.mrbs.mappers.BookMapper;
import ro.uvt.mrbs.models.Detail;
import ro.uvt.mrbs.models.OutBoundBook;
import ro.uvt.mrbs.repositories.BookRepository;
import ro.uvt.mrbs.repositories.UserDetailRepository;

/**
 *
 * @author Zbiera Alexandru-Robert
 */
@Service
public class ShowDetail {

    private final UserDetailRepository detailRepository;
    private final BookRepository bookRepository;

    @Autowired
    public ShowDetail(UserDetailRepository detailRepository, BookRepository bookRepository) {
        this.detailRepository = detailRepository;
        this.bookRepository = bookRepository;
    }

    public Detail showDetail(String username) {
        UserDetail userDetail = detailRepository.findByUserUsername(username);
        List<OutBoundBook> books = new ArrayList<>();
        bookRepository.findLast10ByUser(userDetail.getUser()).forEach((b) -> {
            books.add(BookMapper.toOutBound(b));
        });
        return new Detail(userDetail.getLastName(), userDetail.getFirstName(), userDetail.getEmail(), userDetail.getPhoneNr(), books);
    }
}
