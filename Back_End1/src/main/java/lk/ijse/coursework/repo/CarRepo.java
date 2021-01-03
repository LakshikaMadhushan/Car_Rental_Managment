package lk.ijse.coursework.repo;

import lk.ijse.coursework.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepo extends JpaRepository<Car,String> {
}
