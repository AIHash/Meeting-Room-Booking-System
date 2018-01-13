package ro.uvt.mrbs.models;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Zbiera Alexandru-Robert
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Detail {

    private String lastname;
    private String firstname;
    private String email;
    private String phone;

    private List<OutBoundBook> books;
    
}
