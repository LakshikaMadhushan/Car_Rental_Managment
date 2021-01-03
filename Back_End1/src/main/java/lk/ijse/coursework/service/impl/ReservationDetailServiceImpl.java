package lk.ijse.coursework.service.impl;

import lk.ijse.coursework.dto.CarDetailsDTO;
import lk.ijse.coursework.dto.ReservationDTO;
import lk.ijse.coursework.dto.ReservationDetailDTO;
import lk.ijse.coursework.dto.UserDTO;
import lk.ijse.coursework.entity.CarDetails;
import lk.ijse.coursework.entity.Reservation;
import lk.ijse.coursework.entity.ReservationDetail;
import lk.ijse.coursework.repo.CarDetailsRepo;
import lk.ijse.coursework.repo.ReservationDetailRepo;
import lk.ijse.coursework.service.ReservationDetailService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ReservationDetailServiceImpl implements ReservationDetailService {
    @Autowired
    ReservationDetailRepo repo;
    @Autowired
    ModelMapper mapper;
    @Override
    public void saveReservation(ReservationDetailDTO dto) {
        if (!repo.existsById(dto.getReservation_detail_id())) {
            ReservationDetail rd = mapper.map(dto, ReservationDetail.class);
            repo.save(rd);
        } else {
            throw new RuntimeException("This Reservation Detail Allready Exists");
        }
    }

    @Override
    public void updateReservation(ReservationDetailDTO dto) {
        if (repo.existsById(dto.getReservation_detail_id())) {
            ReservationDetail rd = mapper.map(dto, ReservationDetail.class);
            repo.save(rd);
        } else {
            throw new RuntimeException("No Such Reservation Detail For Update");
        }
    }


    @Override
    public ReservationDetailDTO searchReservation(String id) {
        Optional<ReservationDetail> reservationDetail = repo.findById(id);
        if (reservationDetail.isPresent()) {
            return mapper.map(reservationDetail.get(), ReservationDetailDTO.class);

        } else {
            throw new RuntimeException("No Reservation Detail ID for " + id);
        }
    }

    @Override
    public void deleteReservation(String id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        } else {
            throw new RuntimeException("No Reservation Detail ID for " + id);
        }
    }

    @Override
    public List<ReservationDetailDTO> getAllReservation() {
        List<ReservationDetail> all = repo.findAll();
        return mapper.map(all, new TypeToken<List<ReservationDetailDTO>>() {
        }.getType());
    }

    @Override
    public String getLastIdOfRD() {

        String id=repo.getLastIdOfRD();
        return id;
    }
}

