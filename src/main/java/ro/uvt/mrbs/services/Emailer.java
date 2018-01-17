package ro.uvt.mrbs.services;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ro.uvt.mrbs.entities.Book;
import ro.uvt.mrbs.entities.UserDetail;
import ro.uvt.mrbs.models.EmailerStatus;
import ro.uvt.mrbs.repositories.BookRepository;

/**
 *
 * @author Zbiera Alexandru-Robert
 */
@Service
public class Emailer {

    private final BookRepository bookRepository;

    @Value("${emailer.email}")
    private String email;

    @Value("${emailer.password}")
    private String password;

    @Value("${emailer.status:DEBUG}")
    private EmailerStatus status;

    @Autowired
    public Emailer(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void sendEmail(UserDetail user, String room) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email, password);
            }
        });
        session.setDebug(true);
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(email));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(user.getEmail()));
            message.setSubject("Room booking Notification");
            message.setText("Dear " + user.getFirstName() + " " + user.getLastName() + ","
                    + "\n\n The room you booked is ready to be occupied in 15 minutes, please direct to " + room);
            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    @Scheduled(cron = "* 0/1 * * * ?")
    @Transactional
    public void notifyBooks() {
        if (!status.equals(EmailerStatus.OFF)) {
            Date date = Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
            Long nrOfBooks = bookRepository.count();
            int nrOfBooksPerPage = 10;
            Long nrOfPages = nrOfBooks / nrOfBooksPerPage + 1;
            Page<Book> books;
            for (int i = 0; i < nrOfPages; i++) {
                books = bookRepository.findAllBySentFalseAndStartDateGreaterThan(date, new PageRequest(i, nrOfBooksPerPage));
                books.getContent().forEach(x -> {
                    if (Duration.between(date.toInstant(),x.getStartDate().toInstant()).toMinutes() <= 15) {
                        if (status.equals(EmailerStatus.ON)) {
                            sendEmail(x.getUser().getUserDetail(), x.getRoom().getName());
                            x.setSent(true);
                        }
                        Logger.getLogger("Emailer ")
                                .log(Level.INFO, "BookID:{0} Status:{1} UserDetails:{2} Room:{3} Duration:{4}",
                                        new Object[]{x.getId(), x.isSent(), x.getUser().getUsername(), x.getRoom().getName(), Duration.between(date.toInstant(),x.getStartDate().toInstant()).toMinutes()});
                        x.setSent(true);
                    }
                });
            }
        }
    }
}
