package lk.ijse.coursework.controller;

import lk.ijse.coursework.dto.CarDTO;
import lk.ijse.coursework.dto.LoseDamageWaiverDTO;
import lk.ijse.coursework.service.CarService;
import lk.ijse.coursework.service.LoseDamageWaiverService;
import lk.ijse.coursework.util.StandradResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/car/c1/LoseDamageWaiver")
@RestController
@CrossOrigin
public class LoseDamageWaiverController {
    @Autowired
    LoseDamageWaiverService loseDamageWaiverService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addLoseDamageWaiver(@RequestBody LoseDamageWaiverDTO dto) {
        loseDamageWaiverService.saveLoseDamageWaiver(dto);
        return new ResponseEntity(new StandradResponse(200,"Success","null"), HttpStatus.OK) ;
    }
    @DeleteMapping(params = {"id"})
    public ResponseEntity deleteLoseDamageWaiver(@RequestParam String id) {
        loseDamageWaiverService.deleteLoseDamageWaiver(id);
        return new ResponseEntity(new StandradResponse(200,"Success","null"),HttpStatus.OK) ;
    }

    @PutMapping
    public ResponseEntity updateLoseDamageWaiver(@RequestBody LoseDamageWaiverDTO dto) {
        loseDamageWaiverService.updateLoseDamageWaiver(dto);
        return new ResponseEntity(new StandradResponse(200,"Success","null"),HttpStatus.OK) ;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity searchLoseDamageWaiver(@PathVariable String id) {
        LoseDamageWaiverDTO user = loseDamageWaiverService.searchLoseDamageWaiver(id);
        return new ResponseEntity( new StandradResponse(200,"Success",user),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getLoseDamageWaiver() {
        List<LoseDamageWaiverDTO> list = loseDamageWaiverService.getAllLoseDamageWaiver();
        return new ResponseEntity(new StandradResponse(200,"Success",list),HttpStatus.OK) ;
    }
}
