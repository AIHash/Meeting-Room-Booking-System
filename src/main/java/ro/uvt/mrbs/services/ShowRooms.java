package ro.uvt.mrbs.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.uvt.mrbs.entities.Room;
import ro.uvt.mrbs.repositories.RoomRepository;

/**
 *
 * @author Zbiera Alexandru-Robert
 */
@Service
public class ShowRooms {

    private final RoomRepository roomRepository;

    @Autowired
    public ShowRooms(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> getRooms() {
        return roomRepository.findAll();
    }
}
