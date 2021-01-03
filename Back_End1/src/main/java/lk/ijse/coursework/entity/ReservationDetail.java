package lk.ijse.coursework.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDetail {
    @Id

    private String reservation_detail_id;

    private String reservation_id;

    private String car_id;

    private String driver_id;

    private String lose_damage_waiver_id;
    private String milage;
}
