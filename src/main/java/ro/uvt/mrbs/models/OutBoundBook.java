package ro.uvt.mrbs.models;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.uvt.mrbs.util.JsonDateSerializer;

/**
 *
 * @author Zbiera Alexandru-Robert
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OutBoundBook {

    @JsonSerialize(using = JsonDateSerializer.class)
    private Date startDate;
    @JsonSerialize(using = JsonDateSerializer.class)
    private Date endDate;
    private String room;
}
