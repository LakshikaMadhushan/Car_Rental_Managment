package lk.ijse.coursework.repo;

import lk.ijse.coursework.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReservationRepo extends JpaRepository <Reservation,String> {
    @Query(value = "SELECT reservation_id FROM reservation ORDER BY reservation_id DESC LIMIT 1", nativeQuery = true)
    String getLastIdOfR();
}
