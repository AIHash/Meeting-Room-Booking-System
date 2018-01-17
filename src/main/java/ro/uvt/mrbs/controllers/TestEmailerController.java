package ro.uvt.mrbs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.uvt.mrbs.entities.User;
import ro.uvt.mrbs.entities.UserDetail;
import ro.uvt.mrbs.services.Emailer;

/**
 *
 * @author Zbiera Alexandru-Robert
 */
@RestController
public class TestEmailerController {

    private final Emailer e;

    @Autowired
    public TestEmailerController(Emailer e) {
        this.e = e;
    }

    @GetMapping("/testEmail")
    public void sendEmail(@Param("email") String email) {
        String name = email.split("@")[0];
        UserDetail d = new UserDetail(name.substring(0, name.length() / 2), name.substring(name.length() / 2), "phoneNr", email, new User());
        e.sendEmail(d, "room");
    }

}
