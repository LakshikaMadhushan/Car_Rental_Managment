package lk.ijse.coursework.repo;

import lk.ijse.coursework.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepo extends JpaRepository <User,String> {

    @Query(value = "select * from user where email=:email1 and password=:password1", nativeQuery = true)
    User getMyUser(@Param("email1") String id, @Param("password1") String name);
}
