package lk.ijse.coursework.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoseDamageWaiverDTO {
    private String lose_damage_waiver_id;
    private String reservation_Details_id;
    private String lose_damage_waiver_status;
    private String lose_damage_waiver_pay_amount;
    private String lose_damage_waiver_deduct_amount;
    private String lose_damage_waiver_deduct_amount_status;
    private String lose_damage_waiver_pic_01;
    private String lose_damage_waiver_pic_02;
    private String lose_damage_waiver_pic_03;
    private String lose_damage_waiver_pic_04;
}
