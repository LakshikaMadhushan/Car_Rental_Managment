package lk.ijse.coursework.service.impl;

import lk.ijse.coursework.dto.CarDTO;
import lk.ijse.coursework.dto.PaymentDTO;
import lk.ijse.coursework.entity.Car;
import lk.ijse.coursework.entity.Payment;
import lk.ijse.coursework.repo.PaymentRepo;
import lk.ijse.coursework.service.PaymentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    ModelMapper mapper;
    @Autowired
    PaymentRepo repo;
    @Override
    public void savePayment(PaymentDTO dto) {
        if (!repo.existsById(dto.getPayment_id())) {
            Payment p = mapper.map(dto, Payment.class);
            repo.save(p);
        } else {
            throw new RuntimeException("Payment Allready Exists "+dto.getPayment_id());
        }
    }

    @Override
    public void updatePayment(PaymentDTO dto) {
        if (repo.existsById(dto.getPayment_id())) {
            Payment p = mapper.map(dto, Payment.class);
            repo.save(p);
        } else {
            throw new RuntimeException("No Such Payment For Update");
        }
    }

    @Override
    public PaymentDTO searchPayment(String id) {
        Optional<Payment> payment = repo.findById(id);
        if (payment.isPresent()) {
            return mapper.map(payment.get(), PaymentDTO.class);

        } else {
            throw new RuntimeException("No Payment ID for " + id);
        }
    }

    @Override
    public void deletePayment(String id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        } else {
            throw new RuntimeException("No Payment  ID for " + id);
        }
    }

    @Override
    public List<PaymentDTO> getAllPayment() {
        List<Payment> all = repo.findAll();
        return mapper.map(all, new TypeToken<List<PaymentDTO>>() {
        }.getType());
    }
}
