package lk.ijse.coursework.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Car {
    @Id
    private String car_id;
    private String model_id;

    private String milage;
    private String colour;
    private String maintain_km;
    private String maintain_status;
    private String car_status;
    private String Car_pic_01;
    private String Car_pic_02;
    private String Car_pic_03;
    private String Car_pic_04;


}