package ro.uvt.mrbs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.uvt.mrbs.entities.Book;

import java.util.Date;

public interface BookRepository extends JpaRepository<Book, Long> {

    Book findByStartDate(Date date);
}
