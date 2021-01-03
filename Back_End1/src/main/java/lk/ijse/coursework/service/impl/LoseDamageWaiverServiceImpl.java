package lk.ijse.coursework.service.impl;

import lk.ijse.coursework.dto.CarDetailsDTO;
import lk.ijse.coursework.dto.LoseDamageWaiverDTO;
import lk.ijse.coursework.entity.CarDetails;
import lk.ijse.coursework.entity.LoseDamageWaiver;
import lk.ijse.coursework.repo.CarDetailsRepo;
import lk.ijse.coursework.repo.Lose_Damage_WaiverRepo;
import lk.ijse.coursework.service.LoseDamageWaiverService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LoseDamageWaiverServiceImpl implements LoseDamageWaiverService {
    @Autowired
    Lose_Damage_WaiverRepo repo;
    @Autowired
    ModelMapper mapper;

    @Override
    public void saveLoseDamageWaiver(LoseDamageWaiverDTO dto) {
        if (!repo.existsById(dto.getLose_damage_waiver_id())) {
            LoseDamageWaiver ls = mapper.map(dto, LoseDamageWaiver.class);
            repo.save(ls);
        } else {
            throw new RuntimeException("This Lose Damage Allready Exists " + dto.getLose_damage_waiver_id());
        }
    }

    @Override
    public void updateLoseDamageWaiver(LoseDamageWaiverDTO dto) {
        if (repo.existsById(dto.getLose_damage_waiver_id())) {
            LoseDamageWaiver ls = mapper.map(dto,  LoseDamageWaiver.class);
            repo.save(ls);
        } else {
            throw new RuntimeException("No Such Lose Damage Waiver For Update");
        }
    }

    @Override
    public LoseDamageWaiverDTO searchLoseDamageWaiver(String id) {
        Optional<LoseDamageWaiver> loseDamageWaiver = repo.findById(id);
        if (loseDamageWaiver.isPresent()) {
            return mapper.map(loseDamageWaiver.get(), LoseDamageWaiverDTO.class);

        } else {
            throw new RuntimeException("No Lose Damage Waiver ID for " + id);
        }
    }

    @Override
    public void deleteLoseDamageWaiver(String id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        } else {
            throw new RuntimeException("No Lose Damage Waiver ID for " + id);
        }
    }

    @Override
    public List<LoseDamageWaiverDTO> getAllLoseDamageWaiver() {
        List<LoseDamageWaiver> all = repo.findAll();
        return mapper.map(all, new TypeToken<List<LoseDamageWaiverDTO>>() {
        }.getType());
    }
}
