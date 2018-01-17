package ro.uvt.mrbs.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue
    private long id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    private boolean sent;

    @OneToOne
    private Room room;

    @OneToOne
    private User user;

    public Book(Date startDate, Date endDate, Room room) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.room = room;
    }

}
