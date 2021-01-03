package lk.ijse.coursework.service;

import lk.ijse.coursework.dto.CarDetailsDTO;

import java.util.List;

public interface CarDetailsService {
    void saveCarDetails(CarDetailsDTO dto);
    void updateCarDetails(CarDetailsDTO dto);
    CarDetailsDTO searchCarDetails(String id);
    void deleteCarDetails(String id);
    List<CarDetailsDTO> getAllCarDetails();
}
