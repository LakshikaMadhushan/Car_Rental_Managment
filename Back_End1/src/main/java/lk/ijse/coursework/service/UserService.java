package lk.ijse.coursework.service;

import lk.ijse.coursework.dto.UserDTO;


import java.util.List;

public interface UserService {
 void saveCustomer(UserDTO dto);
 void updateCustomer(UserDTO dto);
 UserDTO searchCustomer(String id);
 void deleteCustomer(String id);
 List<UserDTO> getAllCustomer();
 UserDTO searchLoginCustomer(String email,String password);

}
