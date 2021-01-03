package lk.ijse.coursework.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    @Id
    private String payment_id;
    private String reservation_id;
    private String total_cost;
    private String pay_amount;
    private String payment_date;
    private String payment_status;
}
