package lk.ijse.coursework.service.impl;

import lk.ijse.coursework.dto.CarDTO;
import lk.ijse.coursework.dto.CarDetailsDTO;
import lk.ijse.coursework.dto.DriverDTO;
import lk.ijse.coursework.entity.Car;
import lk.ijse.coursework.entity.CarDetails;
import lk.ijse.coursework.entity.Driver;
import lk.ijse.coursework.entity.ReservationDetail;
import lk.ijse.coursework.repo.CarDetailsRepo;
import lk.ijse.coursework.repo.CarRepo;
import lk.ijse.coursework.service.CarService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CarServiceImpl implements CarService {
    @Autowired
    CarRepo repo;
    @Autowired
    ModelMapper mapper;
    @Override
    public void saveCar(CarDTO dto) {
        if (!repo.existsById(dto.getCar_id())) {
          Car c = mapper.map(dto, Car.class);

            repo.save(c);
        } else {
            throw new RuntimeException("Car  Allready Exists "+dto.getCar_id());
        }
    }

    @Override
    public void updateCar(CarDTO dto) {
        if (repo.existsById(dto.getCar_id())) {
            Car c = mapper.map(dto, Car.class);

            repo.save(c);
        } else {
            throw new RuntimeException("No Such Car For Update");
        }
    }

    @Override
    public CarDTO searchCar(String id) {
        Optional<Car> car = repo.findById(id);


        if (car.isPresent()) {
            CarDTO map = mapper.map(car.get(), CarDTO.class);

            return map;
        } else {
            throw new RuntimeException("No Car Detail ID for " + id);
        }
    }

    @Override
    public List<CarDTO> getAllCar() {
//        List<Car> all = repo.findAll();
//        List<CarDTO> list = new ArrayList<>();
//        String model_id = all.get(4).getCarDetails().getModel_id();
//        System.out.println(model_id);
//        int i=0;
//        for (Car c:all) {
//
//            list.add(new CarDTO(
//                    c.getCar_id(),
//                    all.get(1).getCarDetails().getModel_id(),
//                    c.getMilage(),
//                    c.getColour(),
//                    c.getMaintain_km(),
//                    c.getMaintain_status(),
//                    c.getCar_pic_01(),
//                    c.getCar_pic_02(),
//                    c.getCar_pic_03(),
//                    c.getCar_pic_04()
//            ));
//i++;
//        }
//        return list;
//}
        List<Car> all = repo.findAll();
        return mapper.map(all, new TypeToken<List<CarDTO>>() {
        }.getType());
    }


//        for (int i = 0; i <all.size(); i++) {
//            System.out.println(i);

//           CarDTO carDTO=new CarDTO(
//                   all.get(i).getCar_id(),all.get(1).getCarDetailss(),
//                   all.get(i).getMilage(),"3","3","3","3", "4","4","4"
////                   all.get(i).getCar_id(),
////                   all.get(i).getCarDetailss(),
////                   all.get(i).getMilage(),
////                   all.get(i).getColour(),
////                   all.get(i).getMaintain_km(),
////                   all.get(i).getMaintain_status(),
////                   all.get(i).getCar_pic_01(),
////                   all.get(i).getCar_pic_02(),
////                   all.get(i).getCar_pic_03(),
////                   all.get(i).getCar_pic_04()
//           );
//           list.add(carDTO);
//        }






    @Override
    public void deleteCar(String id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        } else {
            throw new RuntimeException("No Car  ID for " + id);
        }
    }
}
