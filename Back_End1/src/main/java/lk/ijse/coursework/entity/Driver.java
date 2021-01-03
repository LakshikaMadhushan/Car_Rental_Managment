package lk.ijse.coursework.entity;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Driver {
    @Id
    private String driver_id;
    private String name;
    private String address;
    private String email;
    private String password;
    private String registrate_date;
    private String driver_status;
    private String licen_pic_01;
    private String licen_pic_02;


}
