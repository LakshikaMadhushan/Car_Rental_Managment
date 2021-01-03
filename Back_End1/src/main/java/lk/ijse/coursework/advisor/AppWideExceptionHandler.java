package lk.ijse.coursework.advisor;

import lk.ijse.coursework.util.StandradResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWideExceptionHandler {
    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity HandleException(RuntimeException ex) {
        new StandradResponse(500, "Error", ex.getMessage());
        return new ResponseEntity(new StandradResponse(500, "Error", ex.getMessage()), HttpStatus.OK);
    }

}
