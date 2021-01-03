package lk.ijse.coursework.service.impl;

import lk.ijse.coursework.dto.UserDTO;
import lk.ijse.coursework.entity.User;
import lk.ijse.coursework.repo.UserRepo;
import lk.ijse.coursework.service.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepo repo;
    @Autowired
    ModelMapper mapper;

    @Override
    public void saveCustomer(UserDTO dto) {
        if (!repo.existsById(dto.getUser_id())) {
            User u = mapper.map(dto, User.class);
            repo.save(u);
        } else {
            throw new RuntimeException("User Allready Exists");
        }

    }

    @Override
    public void updateCustomer(UserDTO dto) {
        if (repo.existsById(dto.getUser_id())) {
            User u = mapper.map(dto, User.class);
            repo.save(u);
        } else {
            throw new RuntimeException("No Such User For Update");
        }
    }

    @Override
    public UserDTO searchCustomer(String id) {
        Optional<User> user = repo.findById(id);
        if (user.isPresent()) {
            return mapper.map(user.get(), UserDTO.class);
        } else {
            throw new RuntimeException("No User ID for " + id);
        }

    }

    @Override
    public void deleteCustomer(String id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        } else {
            throw new RuntimeException("No User ID for " + id);
        }
    }

    @Override
    public List<UserDTO> getAllCustomer() {
        List<User> all = repo.findAll();
        return mapper.map(all, new TypeToken<List<UserDTO>>() {
        }.getType());
    }

    @Override
    public UserDTO searchLoginCustomer(String email, String password) {
        Optional<User> user = Optional.ofNullable(repo.getMyUser(email, password));
        if (user.isPresent()) {
            return mapper.map(user.get(), UserDTO.class);
        } else {
            throw new RuntimeException("Invalid Email or Paasword " );
        }
    }
}
