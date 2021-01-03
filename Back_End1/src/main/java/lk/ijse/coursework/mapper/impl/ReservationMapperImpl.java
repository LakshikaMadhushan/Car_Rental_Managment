package lk.ijse.coursework.mapper.impl;

import lk.ijse.coursework.dto.ReservationDTO;
import lk.ijse.coursework.entity.Reservation;
import lk.ijse.coursework.mapper.ReservationMapper;
import org.springframework.stereotype.Service;

@Service
public class ReservationMapperImpl implements ReservationMapper{
    @Override
    public Reservation sourceReservationDTOToReservation(ReservationDTO reservationDTO) {
        if (reservationDTO == null){
            return null;
        }
        return new Reservation(
                reservationDTO.getReservation_id(),
                reservationDTO.getUser_id(),
                reservationDTO.getRequest_status(),
                reservationDTO.getPick_up_date(),
                reservationDTO.getReturn_date(),
                reservationDTO.getBank_slip()
        );
    }

    @Override
    public ReservationDTO sourceReservationToReservationDTO(Reservation reservation) {
        if (reservation == null){
            return null;
        }
        return new ReservationDTO(
                reservation.getReservation_id(),
                reservation.getReservation_id(),
                reservation.getRequest_status(),
                reservation.getPick_up_date(),
                reservation.getReturn_date(),
                reservation.getBank_slip()
        );
    }
}
