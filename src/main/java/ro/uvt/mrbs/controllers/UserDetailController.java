package ro.uvt.mrbs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import ro.uvt.mrbs.models.Detail;
import ro.uvt.mrbs.services.ShowDetail;

/**
 *
 * @author Zbiera Alexandru-Robert
 */
@Controller
@SessionAttributes({"ln", "fn", "email", "phone", "name"})
public class UserDetailController {

    private final ShowDetail showDetail;

    @Autowired
    public UserDetailController(ShowDetail showDetail) {
        this.showDetail = showDetail;
    }

    @RequestMapping(value = "/details", method = RequestMethod.GET)
    public String showDetails(ModelMap model) {
        String username = (String) model.get("name");
        Detail detail = showDetail.showDetail(username);
        model.put("name", username);
        model.put("ln", detail.getLastname());
        model.put("fn", detail.getFirstname());
        model.put("email", detail.getEmail());
        model.put("phone", detail.getPhone());
        model.put("books", detail.getBooks());
        return "userdata";
    }

}
