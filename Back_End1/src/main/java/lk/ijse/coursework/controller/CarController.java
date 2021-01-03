package lk.ijse.coursework.controller;

import lk.ijse.coursework.dto.CarDTO;
import lk.ijse.coursework.dto.CarDetailsDTO;
import lk.ijse.coursework.service.CarService;
import lk.ijse.coursework.util.StandradResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car/c1/car")
@CrossOrigin
public class CarController {
    @Autowired
    CarService carService;


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addCarDetails(@RequestBody CarDTO dto) {
        carService.saveCar(dto);
        return new ResponseEntity(new StandradResponse(200,"Success","null"), HttpStatus.OK) ;
    }
    @DeleteMapping(params = {"id"})
    public ResponseEntity deleteCarDetails(@RequestParam String id) {
        carService.deleteCar(id);
        return new ResponseEntity(new StandradResponse(200,"Success","null"),HttpStatus.OK) ;
    }

    @PutMapping
    public ResponseEntity updateCarDetails(@RequestBody CarDTO dto) {
        carService.updateCar(dto);
        return new ResponseEntity(new StandradResponse(200,"Success","null"),HttpStatus.OK) ;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity searchCarDetails(@PathVariable String id) {
        CarDTO user = carService.searchCar(id);
        return new ResponseEntity( new StandradResponse(200,"Success",user),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllUser() {
        List<CarDTO> list = carService.getAllCar();
        return new ResponseEntity(new StandradResponse(200,"Success",list),HttpStatus.OK) ;
    }
}
