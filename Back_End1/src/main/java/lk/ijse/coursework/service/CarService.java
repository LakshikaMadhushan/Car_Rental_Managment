package lk.ijse.coursework.service;

import lk.ijse.coursework.dto.CarDTO;
import lk.ijse.coursework.dto.CarDetailsDTO;

import java.util.List;

public interface CarService {
    void saveCar(CarDTO dto);
    void updateCar(CarDTO dto);
    CarDTO searchCar(String id);
    void deleteCar(String id);
    List<CarDTO> getAllCar();
}
