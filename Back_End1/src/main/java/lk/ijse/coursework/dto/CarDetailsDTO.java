package lk.ijse.coursework.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CarDetailsDTO {
    private String model_id;
    private String brand;
    private String car_type;
    private String transmission_type;
    private String fuel_type;
    private int no_of_passngers;
    private String daily_rate;
    private String monthly_rate;
    private String km_for_day;
    private String km_for_month;
    private String extra_km_price;
}
