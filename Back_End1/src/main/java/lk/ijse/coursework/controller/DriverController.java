package lk.ijse.coursework.controller;

import lk.ijse.coursework.dto.CarDTO;
import lk.ijse.coursework.dto.DriverDTO;
import lk.ijse.coursework.service.DriverService;
import lk.ijse.coursework.util.StandradResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/car/c1/driver")
public class DriverController {
    @Autowired
    DriverService driverService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addDriver(@RequestBody DriverDTO dto) {
        driverService.saveDriver(dto);
        return new ResponseEntity(new StandradResponse(200,"Success","null"), HttpStatus.OK) ;
    }
    @DeleteMapping(params = {"id"})
    public ResponseEntity deleteCarDetails(@RequestParam String id) {
        driverService.deleteDriver(id);
        return new ResponseEntity(new StandradResponse(200,"Success","null"),HttpStatus.OK) ;
    }

    @PutMapping
    public ResponseEntity updateCarDetails(@RequestBody DriverDTO dto) {
        driverService.updateDriver(dto);
        return new ResponseEntity(new StandradResponse(200,"Success","null"),HttpStatus.OK) ;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity searchCarDetails(@PathVariable String id) {
        DriverDTO user = driverService.searchDriver(id);
        return new ResponseEntity( new StandradResponse(200,"Success",user),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllUser() {
        List<DriverDTO> list = driverService.getAllDriver();
        return new ResponseEntity(new StandradResponse(200,"Success",list),HttpStatus.OK) ;
    }
}
