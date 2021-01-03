package lk.ijse.coursework.repo;

import lk.ijse.coursework.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepo extends JpaRepository<Payment,String> {
}
