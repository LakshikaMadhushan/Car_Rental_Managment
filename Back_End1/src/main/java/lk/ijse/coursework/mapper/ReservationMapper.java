package lk.ijse.coursework.mapper;

import lk.ijse.coursework.dto.ReservationDTO;
import lk.ijse.coursework.entity.Reservation;

public interface ReservationMapper {

    Reservation sourceReservationDTOToReservation(ReservationDTO reservationDTO);
    ReservationDTO sourceReservationToReservationDTO(Reservation reservation);

}
