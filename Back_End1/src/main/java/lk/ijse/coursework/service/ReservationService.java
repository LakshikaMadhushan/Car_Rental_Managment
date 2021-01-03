package lk.ijse.coursework.service;

import lk.ijse.coursework.dto.CarDTO;
import lk.ijse.coursework.dto.ReservationDTO;

import java.util.List;

public interface ReservationService {
    void saveReservation(ReservationDTO dto);
    void updateReservation(ReservationDTO dto);
    ReservationDTO searchReservation(String id);
    void deleteReservation(String id);
    List<ReservationDTO> getAllReservation();
    String getLastIdOfR();
}
