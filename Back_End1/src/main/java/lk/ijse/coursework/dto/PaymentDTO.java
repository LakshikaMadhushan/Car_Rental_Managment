package lk.ijse.coursework.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDTO {
    private String payment_id;
    private String reservation_id;
    private String total_cost;
    private String pay_amount;
    private String payment_date;
    private String payment_status;
}
