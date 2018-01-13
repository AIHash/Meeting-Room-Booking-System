package ro.uvt.mrbs.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Data
@NoArgsConstructor
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

    public UserDetail(String lastName, String firstName, String phoneNr, String email, User user) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.phoneNr = phoneNr;
        this.email = email;
        this.user = user;
    }

}
