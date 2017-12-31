package ro.uvt.mrbs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.uvt.mrbs.entities.Room;

public interface RoomRepository extends JpaRepository<Room,Long> {

}
