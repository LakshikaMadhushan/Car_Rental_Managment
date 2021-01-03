package lk.ijse.coursework.service;

import lk.ijse.coursework.dto.ReservationDTO;
import lk.ijse.coursework.dto.ReservationDetailDTO;
import lk.ijse.coursework.dto.UserDTO;
import lk.ijse.coursework.entity.ReservationDetail;

import java.util.List;

public interface ReservationDetailService {
    void saveReservation(ReservationDetailDTO dto);
    void updateReservation(ReservationDetailDTO dto);
    ReservationDetailDTO searchReservation(String id);
    void deleteReservation(String id);
    List<ReservationDetailDTO> getAllReservation();
    String getLastIdOfRD();
}
