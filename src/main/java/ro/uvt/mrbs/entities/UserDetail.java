package ro.uvt.mrbs.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetail {


    @Id
    @GeneratedValue
    private long id;
    private String lastName;
    private String firstName;
    private String phoneNr;
    private String email;

    @OneToOne
    private User user;
}
