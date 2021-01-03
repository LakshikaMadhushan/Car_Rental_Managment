package lk.ijse.coursework.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDetailDTO {
    private String reservation_detail_id;
    private String reservation_id;
    private String car_id;
    private String driver_id;
    private String lose_damage_waiver_id;
    private String milage;



}
