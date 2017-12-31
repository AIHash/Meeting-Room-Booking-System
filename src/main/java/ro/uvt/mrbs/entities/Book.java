package ro.uvt.mrbs.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue
    private long id;
    private Date startDate;
    private Date endDate;

    @OneToOne
    private Room room;

    @OneToMany
    private List<User> users;

}
