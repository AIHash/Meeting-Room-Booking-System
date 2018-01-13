package ro.uvt.mrbs.models;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.uvt.mrbs.entities.Room;

/**
 *
 * @author Zbiera Alexandru-Robert
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OutBoundBook {

    private Date startDate;
    private Date endDate;
    private Room room;
}
