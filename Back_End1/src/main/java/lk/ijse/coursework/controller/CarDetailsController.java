package lk.ijse.coursework.controller;

import lk.ijse.coursework.dto.CarDetailsDTO;
import lk.ijse.coursework.dto.UserDTO;
import lk.ijse.coursework.repo.CarDetailsRepo;
import lk.ijse.coursework.service.CarDetailsService;
import lk.ijse.coursework.util.StandradResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/car/c1/cardetails")
public class CarDetailsController {
    @Autowired
    CarDetailsService carDetailsService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addCarDetails(@RequestBody CarDetailsDTO dto) {
        carDetailsService.saveCarDetails(dto);
        return new ResponseEntity(new StandradResponse(200,"Success","null"), HttpStatus.OK) ;
    }
    @DeleteMapping(params = {"id"})
    public ResponseEntity deleteCarDetails(@RequestParam String id) {
        carDetailsService.deleteCarDetails(id);
        return new ResponseEntity(new StandradResponse(200,"Success","null"),HttpStatus.OK) ;
    }

    @PutMapping
    public ResponseEntity updateCarDetails(@RequestBody CarDetailsDTO dto) {
        carDetailsService.updateCarDetails(dto);
        return new ResponseEntity(new StandradResponse(200,"Success","null"),HttpStatus.OK) ;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity searchCarDetails(@PathVariable String id) {
        CarDetailsDTO user = carDetailsService.searchCarDetails(id);
        return new ResponseEntity( new StandradResponse(200,"Success",user),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllUser() {
        List<CarDetailsDTO> list = carDetailsService.getAllCarDetails();
        return new ResponseEntity(new StandradResponse(200,"Success",list),HttpStatus.OK) ;
    }
}
