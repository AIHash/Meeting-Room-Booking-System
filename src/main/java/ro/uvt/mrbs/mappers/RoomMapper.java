package ro.uvt.mrbs.mappers;

import ro.uvt.mrbs.entities.Room;
import ro.uvt.mrbs.models.OutBoundRoom;

/**
 *
 * @author Zbiera Alexandru-Robert
 */
public class RoomMapper {

    private RoomMapper() {
    }

    public static OutBoundRoom toOutBound(Room room) {
        return new OutBoundRoom(room.getName());
    }

}
