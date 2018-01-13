package ro.uvt.mrbs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.uvt.mrbs.repositories.UserRepository;

/**
 *
 * @author Zbiera Alexandru-Robert
 */
@Service
public class LoginService {

    private final UserRepository userRepository;

    @Autowired
    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean validateUser(String username, String password) {
        return userRepository.existsByUsernameAndPassword(username, password);
    }

}
