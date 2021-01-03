package lk.ijse.coursework.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DriverDTO {
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
