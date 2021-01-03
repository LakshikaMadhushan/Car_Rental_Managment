package lk.ijse.coursework.service;

import lk.ijse.coursework.dto.CarDTO;
import lk.ijse.coursework.dto.DriverDTO;

import java.util.List;

public interface DriverService {
    void saveDriver(DriverDTO dto);
    void updateDriver(DriverDTO dto);
    DriverDTO searchDriver(String id);
    void deleteDriver(String id);
    List<DriverDTO> getAllDriver();
}
