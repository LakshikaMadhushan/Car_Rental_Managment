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
public class User {
    @Id
    private String user_id;
    private String name;
    private String address;
    private String email;
    private String password;
    private int contact_no;
    private String driving_licen_01;
    private String driving_licen_02;
    private String registrate_date;


}

