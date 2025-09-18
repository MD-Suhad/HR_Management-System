package com.pos.shohaib.security.mapper;

import com.pos.shohaib.security.domain.model.User;
import com.pos.shohaib.security.dto.model.UserDTO;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

    public static UserDTO map(User user){

        return new UserDTO()
                .setId(user.getId())
                .setName(user.getName())
                .setRole(user.getRole())
                .setPhoneNumber(user.getPhoneNumber())
                .setPassword(user.getPassword())
                .setAddress(user.getAddress())
                .setRole(user.getRole())
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName());

    }
    public static List<UserDTO> map(List<User> users){
        return users.stream().map(UserMapper::map).collect(Collectors.toList());
    }

}
