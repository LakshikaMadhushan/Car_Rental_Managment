package lk.ijse.coursework.service.impl;

import lk.ijse.coursework.dto.CarDTO;
import lk.ijse.coursework.dto.DriverDTO;
import lk.ijse.coursework.entity.Car;
import lk.ijse.coursework.entity.Driver;
import lk.ijse.coursework.repo.CarRepo;
import lk.ijse.coursework.repo.DriverRepo;
import lk.ijse.coursework.service.DriverService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DriverServiceImpl implements DriverService {
    @Autowired
    DriverRepo repo;
    @Autowired
    ModelMapper mapper;
    @Override
    public void saveDriver(DriverDTO dto) {
        if (!repo.existsById(dto.getDriver_id())) {
            Driver d = mapper.map(dto, Driver.class);
            repo.save(d);
        } else {
            throw new RuntimeException("Driver  Allready Exists "+dto.getDriver_id());
        }
    }

    @Override
    public void updateDriver(DriverDTO dto) {
        if (repo.existsById(dto.getDriver_id())) {
            Driver d = mapper.map(dto, Driver.class);
            repo.save(d);
        } else {
            throw new RuntimeException("No Such Driver For Update");
        }
    }

    @Override
    public DriverDTO searchDriver(String id) {
        Optional<Driver> driver = repo.findById(id);
        if (driver.isPresent()) {
            return mapper.map(driver.get(), DriverDTO.class);

        } else {
            throw new RuntimeException("No Driver Detail ID for " + id);
        }
    }

    @Override
    public void deleteDriver(String id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        } else {
            throw new RuntimeException("No Driver  ID for " + id);
        }
    }

    @Override
    public List<DriverDTO> getAllDriver() {
        List<Driver> all = repo.findAll();
        return mapper.map(all, new TypeToken<List<DriverDTO>>() {
        }.getType());
    }
}
