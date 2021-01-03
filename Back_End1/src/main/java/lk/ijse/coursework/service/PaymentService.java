package lk.ijse.coursework.service;

import lk.ijse.coursework.dto.CarDTO;
import lk.ijse.coursework.dto.PaymentDTO;

import java.util.List;

public interface PaymentService {
    void savePayment(PaymentDTO dto);
    void updatePayment(PaymentDTO dto);
    PaymentDTO searchPayment(String id);
    void deletePayment(String id);
    List<PaymentDTO> getAllPayment();
}
