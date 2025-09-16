package com.alibou.security.service.User;


import com.alibou.security.domain.model.User;
import com.alibou.security.domain.repository.UserRepository;
import com.alibou.security.dto.model.UserDTO;
import com.alibou.security.service.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;


    @Override
    public List<UserDTO> index() throws UserNotFoundException {
        return null;
    }

    @Override
    public UserDTO show(Long id) throws UserNotFoundException {
        return null;
    }

    @Override
    public String store(UserDTO userDTO) throws UserNotFoundException {
        Random rnd = new Random();
        int number = rnd.nextInt(9999);
        Optional<User> foundUser = userRepository.findByUsername(userDTO.getName());
        if(foundUser.isPresent()){
            throw new UserNotFoundException(String.format("User with username: '%s' already exists",
                    userDTO.getName()));
        }else{
            User user = new User()
                    .setName(userDTO.getFirstName().replace(" ", "").toLowerCase() + userDTO.getLastName().replace(" ", "").toLowerCase() + String.format("%04d", number))
                    .setFirstName(userDTO.getFirstName())
                    .setLastName(userDTO.getLastName())
                    .setProfileImage("users/user-icon.png")
                    .setPhoneNumber(userDTO.getPhoneNumber())
                    .setAddress(userDTO.getAddress());
            user = this.userRepository.save(user);
            return "User Registration Successfully";
        }

    }
}
