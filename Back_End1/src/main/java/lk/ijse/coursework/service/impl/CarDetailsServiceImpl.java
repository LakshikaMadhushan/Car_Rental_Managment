package lk.ijse.coursework.service.impl;

import lk.ijse.coursework.dto.CarDetailsDTO;
import lk.ijse.coursework.entity.CarDetails;
import lk.ijse.coursework.repo.CarDetailsRepo;
import lk.ijse.coursework.service.CarDetailsService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
    @Service
    @Transactional
public class CarDetailsServiceImpl implements CarDetailsService {
    @Autowired
    CarDetailsRepo repo;
    @Autowired
    ModelMapper mapper;

    @Override
    public void saveCarDetails(CarDetailsDTO dto) {
        if (!repo.existsById(dto.getModel_id())) {
            CarDetails cd = mapper.map(dto, CarDetails.class);
            repo.save(cd);
        } else {
            throw new RuntimeException("This Car Detail Allready Exists");
        }

    }

    @Override
    public void updateCarDetails(CarDetailsDTO dto) {
        if (repo.existsById(dto.getModel_id())) {
            CarDetails cd = mapper.map(dto, CarDetails.class);
            repo.save(cd);
        } else {
            throw new RuntimeException("No Such Car Detail For Update");
        }
    }

    @Override
    public CarDetailsDTO searchCarDetails(String id) {
        Optional<CarDetails> carDetails = repo.findById(id);
        if (carDetails.isPresent()) {
            return mapper.map(carDetails.get(), CarDetailsDTO.class);

        } else {
            throw new RuntimeException("No Car Detail ID for " + id);
        }
    }

    @Override
    public void deleteCarDetails(String id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        } else {
            throw new RuntimeException("No Car Detail ID for " + id);
        }
    }

    @Override
    public List<CarDetailsDTO> getAllCarDetails() {
        List<CarDetails> all = repo.findAll();
        return mapper.map(all, new TypeToken<List<CarDetailsDTO>>() {
        }.getType());
    }
}

