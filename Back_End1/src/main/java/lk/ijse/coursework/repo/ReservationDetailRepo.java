package lk.ijse.coursework.repo;

import lk.ijse.coursework.entity.ReservationDetail;
import lk.ijse.coursework.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReservationDetailRepo extends JpaRepository<ReservationDetail,String> {

    @Query(value = "SELECT reservation_detail_id FROM reservationdetail ORDER BY reservation_detail_id DESC LIMIT 1", nativeQuery = true)
    String getLastIdOfRD();
}
