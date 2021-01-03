package lk.ijse.coursework.controller;

import lk.ijse.coursework.dto.CarDTO;
import lk.ijse.coursework.dto.PurchaseDTO;
import lk.ijse.coursework.dto.UserDTO;
import lk.ijse.coursework.service.PurchaseReservationService;
import lk.ijse.coursework.service.ReservationDetailService;
import lk.ijse.coursework.service.ReservationService;
import lk.ijse.coursework.service.UserService;
import lk.ijse.coursework.util.StandradResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/car/c1/purchase")
@CrossOrigin
public class PurchaseReservationController {

    @Autowired
    ReservationDetailService reservationDetailService;
    @Autowired
    ReservationService reservationService;
@Autowired
    PurchaseReservationService purchaseReservationService;

    @GetMapping(path = "/last")
    public ResponseEntity serchlastIndexRD() {
        String lastIdOfRD = reservationDetailService.getLastIdOfRD();
        return new ResponseEntity( new StandradResponse(200,"Success",lastIdOfRD), HttpStatus.OK);
    }
    @GetMapping(path = "/last/1")
    public ResponseEntity serchlastIndexR() {
        String lastIdOfR = reservationService.getLastIdOfR();
        return new ResponseEntity( new StandradResponse(200,"Success",lastIdOfR), HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addPurchaceReservation(@RequestBody PurchaseDTO dto) {
        purchaseReservationService.savePurchaseReservationService(dto);
        return new ResponseEntity(new StandradResponse(200,"Success","null"), HttpStatus.OK) ;
    }

}
