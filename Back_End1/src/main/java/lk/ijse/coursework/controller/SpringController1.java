package lk.ijse.coursework.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/ctrl1")
public class SpringController1 {

    @GetMapping // get something from the server
    public String getMethod() {
        return "GET METHOD INVOKED";
    }

    @PostMapping// send data to the server
    public String postMethod() {
        return "POST METHOD INVOKED";
    }

    @PutMapping //update server details
    public String putMathod() {
        return "PUT METHOD INVOKED";
    }

    @DeleteMapping //delete something from the server
    public String deleteMapping() {
        return "DELETE METHOD INVOKED";
    }


}
