package ro.uvt.mrbs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import ro.uvt.mrbs.services.LoginService;

/**
 *
 * @author Zbiera Alexandru-Robert
 */
@Controller
@SessionAttributes("name")
public class LoginController {

    @Autowired
    LoginService service;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginPage(ModelMap model) {
        return "LogIn";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String showWelcomePage(ModelMap model, @RequestParam String User, @RequestParam String pwd) {

        boolean isValidUser = service.validateUser(User, pwd);

        if (!isValidUser) {
            model.put("errorMessage", "Invalid Credentials");
            return "LogIn";
        }

        model.put("name", User);

        return "welcome";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String showLoginPageAfterLogout(ModelMap model) {
        model.remove("name");
        return "LogIn";
    }
}
