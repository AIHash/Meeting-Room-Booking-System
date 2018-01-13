package ro.uvt.mrbs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.uvt.mrbs.entities.UserDetail;

public interface UserDetailRepository extends JpaRepository<UserDetail, Long> {

    UserDetail findByUserUsername(String username);
}
