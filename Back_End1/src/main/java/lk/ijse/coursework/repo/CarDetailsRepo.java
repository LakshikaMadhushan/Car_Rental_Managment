package lk.ijse.coursework.repo;

import lk.ijse.coursework.entity.CarDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarDetailsRepo extends JpaRepository<CarDetails,String> {
}
