package lk.ijse.coursework.controller;

import lk.ijse.coursework.dto.CarDTO;
import lk.ijse.coursework.dto.ReservationDTO;
import lk.ijse.coursework.entity.Reservation;
import lk.ijse.coursework.service.ReservationService;
import lk.ijse.coursework.util.StandradResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car/c1/reservation")
@CrossOrigin
public class ReservationController {
    @Autowired
    ReservationService reservationService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addReservation(@RequestBody ReservationDTO dto) {
        reservationService.saveReservation(dto);
        return new ResponseEntity(new StandradResponse(200,"Success","null"),HttpStatus.OK) ;
    }

    @PutMapping
    public ResponseEntity updateReservation(@RequestBody ReservationDTO dto) {
        reservationService.updateReservation(dto);
        return new ResponseEntity(new StandradResponse(200,"Success","null"),HttpStatus.OK) ;
    }

    @DeleteMapping(params = {"id"})
    public ResponseEntity deleteReservation(@RequestParam String id) {
        reservationService.deleteReservation(id);
        return new ResponseEntity(new StandradResponse(200,"Success","null"),HttpStatus.OK) ;
    }



    @GetMapping(path = "/{id}")
    public ResponseEntity searchReservation(@PathVariable String id) {
        ReservationDTO reservation = reservationService.searchReservation(id);
        return new ResponseEntity( new StandradResponse(200,"Success",reservation),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllReservation() {
        List<ReservationDTO> list = reservationService.getAllReservation();
        return new ResponseEntity(new StandradResponse(200,"Success",list),HttpStatus.OK) ;
    }
}
