package lk.ijse.coursework.service;

import lk.ijse.coursework.dto.LoseDamageWaiverDTO;

import java.util.List;

public interface LoseDamageWaiverService {
    void saveLoseDamageWaiver(LoseDamageWaiverDTO dto);
    void updateLoseDamageWaiver(LoseDamageWaiverDTO dto);
    LoseDamageWaiverDTO searchLoseDamageWaiver(String id);
    void deleteLoseDamageWaiver(String id);
    List<LoseDamageWaiverDTO> getAllLoseDamageWaiver();

}
