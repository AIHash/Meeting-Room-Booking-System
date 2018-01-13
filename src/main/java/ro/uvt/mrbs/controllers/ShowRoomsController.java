package ro.uvt.mrbs.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.uvt.mrbs.entities.Room;
import ro.uvt.mrbs.mappers.RoomMapper;
import ro.uvt.mrbs.models.OutBoundRoom;
import ro.uvt.mrbs.services.ShowRooms;

/**
 *
 * @author Zbiera Alexandru-Robert
 */
@RestController
@RequestMapping("/room")
public class ShowRoomsController {

    private final ShowRooms showRooms;

    @Autowired
    public ShowRoomsController(ShowRooms showRooms) {
        this.showRooms = showRooms;
    }

    @GetMapping
    public List<OutBoundRoom> getRooms() {
        List<OutBoundRoom> rooms = new ArrayList<>();
        List<Room> listRoom = showRooms.getRooms();
        listRoom.forEach(x -> {
            rooms.add(RoomMapper.toOutBound(x));
        });
        return rooms;
    }
}
