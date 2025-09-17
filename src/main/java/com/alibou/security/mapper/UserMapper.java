package com.alibou.security.mapper;

import com.alibou.security.domain.model.User;
import com.alibou.security.dto.model.UserDTO;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

    public static UserDTO map(User user){

        return new UserDTO()
                .setId(user.getId())
                .setName(user.getName())
                .setRole(user.getRole())
                .setPhoneNumber(user.getPhoneNumber())
                .setUpdateAt(user.getUpdateAt())
                .setCreateAt(user.getCreateAt());

    }
    public static List<UserDTO> map(List<User> users){
        return users.stream().map(UserMapper::map).collect(Collectors.toList());
    }

}
