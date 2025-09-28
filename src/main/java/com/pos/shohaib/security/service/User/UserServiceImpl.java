package com.pos.shohaib.security.service.User;


import com.pos.shohaib.security.domain.model.User;
import com.pos.shohaib.security.domain.repository.UserRepository;
import com.pos.shohaib.security.dto.model.UserDTO;
import com.pos.shohaib.security.service.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;


    @Override
    public List<UserDTO> index()  {
        return this.userRepository
                .findAll()
                .forEach()
                .map
                        (user ->
                                new UserDTO()
                                        .setId(user.getId())
                                        .setEmail(user.getEmail)
                                        .setName(user.getName())
                                        .setLastName(user.getLastName())
                                        .setProfileImage(user.getProfileImage())
                                        .setPhoneNumber(user.getPhoneNumber())
                                        .setAddress(user.getAddress())
                        )
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO show(Long id) throws UserNotFoundException {
        User user = this.userRepository.findById(id).orElseThrow(()-> new UsernameNotFoundException(String.format("User with id: %s could not be found", id)));
        return new UserDTO()
                .setId(user.getId())
                .setName(user.getName())
                .setEmail(user.getEmail)
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName())
                .setProfileImage(user.getProfileImage())
                .setPhoneNumber(user.getPhoneNumber())
                .setAddress(user.getAddress());
    }

    @Override
    public Optional<User> getById(Long id) throws UserNotFoundException{
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty()){
            throw new UserNotFoundException(String.format("User with id: '%s' does not exist", id));
        } else{
            return user;
        }
    }

    @Override
    public String store(UserDTO userDTO) throws UserNotFoundException {
        Random rnd = new Random();
        int number = rnd.nextInt(9999);
        Optional<User> foundUser = userRepository.findByName(userDTO.getName());
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
