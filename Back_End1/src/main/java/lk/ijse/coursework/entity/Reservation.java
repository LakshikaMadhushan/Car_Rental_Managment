package lk.ijse.coursework.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
    @Id
    private String reservation_id;
    private String user_id;
    private String request_status;
    private String pick_up_date;
    private String return_date;
    private String bank_slip;
}





