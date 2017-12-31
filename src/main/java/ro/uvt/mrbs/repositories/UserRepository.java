package ro.uvt.mrbs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.uvt.mrbs.entities.User;

public interface UserRepository extends JpaRepository<User,Long>{

}
