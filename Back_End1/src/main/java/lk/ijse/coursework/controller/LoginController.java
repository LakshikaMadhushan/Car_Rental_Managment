package lk.ijse.coursework.controller;

import lk.ijse.coursework.dto.UserDTO;
import lk.ijse.coursework.entity.User;
import lk.ijse.coursework.service.UserService;
import lk.ijse.coursework.util.StandradResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/car/c1/login")
public class LoginController {
    @Autowired
    UserService userService;
    @GetMapping(path = "/{id1}/{id2}")
    public ResponseEntity searchLoginUser(@PathVariable String id1,@PathVariable String id2) {
        UserDTO user = userService.searchLoginCustomer(id1,id2);
        return new ResponseEntity( new StandradResponse(200,"Success",user), HttpStatus.OK);
    }


}
