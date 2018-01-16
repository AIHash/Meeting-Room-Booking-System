package ro.uvt.mrbs.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import ro.uvt.mrbs.repositories.UserRepository;
import ro.uvt.mrbs.services.BookCreator;

@Controller
@SessionAttributes({"name", "user_id"})
public class BookingController {

    private final BookCreator bookCreator;
    private final UserRepository userRepository;

    @Autowired
    public BookingController(BookCreator bookCreator, UserRepository userRepository) {
        this.bookCreator = bookCreator;
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "/pick", method = RequestMethod.GET)
    public String getForm(ModelMap model) {
        if (model.get("name") == null) {
            return "redirect:/login";
        }
        return "Pick";
    }
    

    @RequestMapping(value = "/pick", method = RequestMethod.POST)
    public String postBooking(ModelMap model, @RequestParam int room_id,
            @RequestParam int start_day,
            @RequestParam int start_month,
            @RequestParam int start_year,
            @RequestParam int start_hour,
            @RequestParam int start_minute,
            @RequestParam int end_day,
            @RequestParam int end_month,
            @RequestParam int end_year,
            @RequestParam int end_hour,
            @RequestParam int end_minute) {
        Date start_date = Date.from(LocalDateTime.of(start_year, start_month, start_day, start_hour, start_minute).atZone(ZoneId.systemDefault()).toInstant());
        Date end_date = Date.from(LocalDateTime.of(end_year, end_month, end_day, end_hour, end_minute).atZone(ZoneId.systemDefault()).toInstant());
        Calendar cal = Calendar.getInstance();
        Date today = new Date();
        cal.setTime(today);
        //check if the input dates are older than today 
        if(start_date.after(today))
        {
        	//check if the dates are exactly the same 
        if(!start_date.equals(start_date) )
        {
        	 bookCreator.createBook(userRepository.findByUsername((String) model.get("name")).getId(), room_id, start_date, end_date);
        	 return "redirect:/details";
        }
        else {
        	 model.put("errorMessage", "end and start date cannot be the same");
        	 return "Pick";
        }
        }
        model.put("errorMessage", "the booking dates should be in the future");
   	    return "Pick";
        

    }

}
