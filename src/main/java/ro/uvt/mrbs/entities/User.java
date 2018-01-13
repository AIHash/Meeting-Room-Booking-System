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
public class User {

    @Id
    @GeneratedValue
    private long id;
    private String username;
    private String password;

    @OneToOne(mappedBy = "user")
    private UserDetail userDetail;

    public User(String username, String password, UserDetail userDetail) {
        this.username = username;
        this.password = password;
        this.userDetail = userDetail;
    }

}
