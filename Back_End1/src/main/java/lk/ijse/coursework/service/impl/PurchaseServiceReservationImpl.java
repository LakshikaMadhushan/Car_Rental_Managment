package lk.ijse.coursework.service.impl;

import lk.ijse.coursework.dto.PurchaseDTO;
import lk.ijse.coursework.dto.ReservationDTO;
import lk.ijse.coursework.dto.ReservationDetailDTO;
import lk.ijse.coursework.entity.Car;
import lk.ijse.coursework.entity.Reservation;
import lk.ijse.coursework.entity.ReservationDetail;
import lk.ijse.coursework.repo.CarRepo;
import lk.ijse.coursework.repo.ReservationDetailRepo;
import lk.ijse.coursework.repo.ReservationRepo;
import lk.ijse.coursework.service.PurchaseReservationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Service
public class PurchaseServiceReservationImpl implements PurchaseReservationService {

    @Autowired
    ReservationDetailRepo repo2;
    @Autowired
    ReservationRepo repo;
    @Autowired
    ModelMapper mapper;
    @Override
    public void savePurchaseReservationService(PurchaseDTO dto) {
        System.out.println("hai");
        if (!repo.existsById(dto.getReservation_id())) {
            Reservation reservation=new Reservation(dto.getReservation_id(),dto.getUser_id(),dto.getRequest_status(),dto.getPick_up_date(),dto.getReturn_date(),dto.getBank_slip());
            List<ReservationDetailDTO> reservationDetail=dto.getReservationDetails();

            repo.save(reservation);

            for (ReservationDetailDTO r: reservationDetail) {
                ReservationDetail reservationDetail1=new ReservationDetail(r.getReservation_detail_id(),r.getReservation_id(),r.getCar_id(),r.getDriver_id(),r.getLose_damage_waiver_id(),r.getMilage());
                System.out.println(r.getCar_id());
                repo2.save(reservationDetail1);
            }

            }else {
            throw new RuntimeException("Invalid Format ");
        }
    }


}
