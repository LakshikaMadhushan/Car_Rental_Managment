package lk.ijse.coursework.service.impl;

import lk.ijse.coursework.dto.ReservationDTO;
import lk.ijse.coursework.dto.UserDTO;
import lk.ijse.coursework.entity.Reservation;
import lk.ijse.coursework.entity.User;
import lk.ijse.coursework.repo.ReservationDetailRepo;
import lk.ijse.coursework.repo.ReservationRepo;
import lk.ijse.coursework.repo.UserRepo;
import lk.ijse.coursework.service.ReservationService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lk.ijse.coursework.mapper.ReservationMapper;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    ReservationRepo repo;
    @Autowired
    ModelMapper mapper;



    @Override
    public void saveReservation(ReservationDTO dto) {
        if (!repo.existsById(dto.getReservation_id())) {
            Reservation r = mapper.map(dto, Reservation.class);
            repo.save(r);
        } else {
            throw new RuntimeException("Reservation Allready Exists");
        }
    }

    @Override
    public void updateReservation(ReservationDTO dto) {
        if (repo.existsById(dto.getReservation_id())) {
            Reservation r = mapper.map(dto, Reservation.class);
            repo.save(r);
        } else {
            throw new RuntimeException("No Such Reservation For Update");
        }
    }

    @Override
    public ReservationDTO searchReservation(String id) {
        Optional<Reservation> reservation = repo.findById(id);
        if (reservation.isPresent()) {
            return mapper.map(reservation.get(), ReservationDTO.class);

        } else {
            throw new RuntimeException("No Reservation ID for " + id);
        }
    }

    @Override
    public void deleteReservation(String id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        } else {
            throw new RuntimeException("No Reservation ID for " + id);
        }
    }

    @Override
    public List<ReservationDTO> getAllReservation() {
        List<Reservation> all = repo.findAll();
        return mapper.map(all, new TypeToken<List<ReservationDTO>>() {
        }.getType());
    }

    @Override
    public String getLastIdOfR() {
        String id=repo.getLastIdOfR();
        return id;
    }
}
