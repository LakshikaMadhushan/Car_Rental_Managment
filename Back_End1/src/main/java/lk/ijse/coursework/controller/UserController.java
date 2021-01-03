package lk.ijse.coursework.controller;


import lk.ijse.coursework.dto.UserDTO;
import lk.ijse.coursework.service.UserService;
import lk.ijse.coursework.util.StandradResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/car/c1/user")
@CrossOrigin
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity  addUser(@RequestBody UserDTO dto) {
        userService.saveCustomer(dto);
//          User u = new User(dto.getUser_id(), dto.getName(), dto.getAddress(), dto.getEmail(), dto.getPassword(), dto.getContact_no(), dto.getDriving_licen_01(), dto.getDriving_licen_02(), dto.getRegistrate_date());

        return new ResponseEntity(new StandradResponse(200,"Success","null"), HttpStatus.OK) ;
    }

    @DeleteMapping(params = {"id"})
    public ResponseEntity deleteUser(@RequestParam String id) {
        userService.deleteCustomer(id);
        return new ResponseEntity(new StandradResponse(200,"Success","null"),HttpStatus.OK) ;
    }

    @PutMapping
    public ResponseEntity updateUser(@RequestBody UserDTO dto) {
        userService.updateCustomer(dto);
        return new ResponseEntity(new StandradResponse(200,"Success","null"),HttpStatus.OK) ;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity searchUser(@PathVariable String id) {
        UserDTO user = userService.searchCustomer(id);
        return new ResponseEntity( new StandradResponse(200,"Success",user),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllUser() {
        List<UserDTO> list = userService.getAllCustomer();
        return new ResponseEntity(new StandradResponse(200,"Success",list),HttpStatus.OK) ;
    }
}


