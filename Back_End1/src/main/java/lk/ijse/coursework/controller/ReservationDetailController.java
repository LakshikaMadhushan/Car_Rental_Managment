package lk.ijse.coursework.controller;

import lk.ijse.coursework.dto.CarDTO;
import lk.ijse.coursework.dto.ReservationDTO;
import lk.ijse.coursework.dto.ReservationDetailDTO;
import lk.ijse.coursework.service.ReservationDetailService;
import lk.ijse.coursework.util.StandradResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car/c1/reservationdetails")
@CrossOrigin
public class ReservationDetailController {
    @Autowired
    ReservationDetailService reservationDetailService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addCarDetails(@RequestBody ReservationDetailDTO dto) {
        reservationDetailService.saveReservation(dto);
        return new ResponseEntity(new StandradResponse(200,"Success","null"), HttpStatus.OK) ;
    }
    @DeleteMapping(params = {"id"})
    public ResponseEntity deleteCarDetails(@RequestParam String id) {
        reservationDetailService.deleteReservation(id);
        return new ResponseEntity(new StandradResponse(200,"Success","null"),HttpStatus.OK) ;
    }

    @PutMapping
    public ResponseEntity updateCarDetails(@RequestBody ReservationDetailDTO dto) {
        reservationDetailService.updateReservation(dto);
        return new ResponseEntity(new StandradResponse(200,"Success","null"),HttpStatus.OK) ;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity searchCarDetails(@PathVariable String id) {
        ReservationDetailDTO user = reservationDetailService.searchReservation(id);
        return new ResponseEntity( new StandradResponse(200,"Success",user),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllUser() {
        List<ReservationDetailDTO> list = reservationDetailService.getAllReservation();
        return new ResponseEntity(new StandradResponse(200,"Success",list),HttpStatus.OK) ;
    }
}
