package ro.uvt.mrbs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.uvt.mrbs.entities.Book;

import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ro.uvt.mrbs.entities.Room;
import ro.uvt.mrbs.entities.User;

public interface BookRepository extends JpaRepository<Book, Long> {

    Page<Book> findAll(Pageable pageable);

    Book findByStartDate(Date date);

    List<Book> findAllByRoom(Room room);

    Page<Book> findAllByRoom(Room room, Pageable pageable);

    Long countAllByRoom(Room room);

    List<Book> findLast10ByUser(User user);

    Page<Book> findAllBySentFalseAndStartDateGreaterThan(Date date, Pageable pageable);
}
