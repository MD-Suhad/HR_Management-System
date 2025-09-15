package com.alibou.security.service.User;

import com.alibou.security.dto.model.UserDTO;
import com.alibou.security.service.exception.UserNotFoundException;

import java.util.List;

public interface UserService {
   List<UserDTO> index() throws UserNotFoundException;
   UserDTO show(Long id) throws UserNotFoundException;
   String store(UserDTO userDTO) throws UserNotFoundException;
}
