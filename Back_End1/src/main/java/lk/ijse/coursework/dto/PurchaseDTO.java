package lk.ijse.coursework.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseDTO {
    private String reservation_id;
    private String user_id;
    private String request_status;
    private String pick_up_date;
    private String return_date;
    private String bank_slip;
    private List<ReservationDetailDTO> reservationDetails;
}
