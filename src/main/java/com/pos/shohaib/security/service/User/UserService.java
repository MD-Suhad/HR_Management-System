package com.pos.shohaib.security.service.User;

import com.pos.shohaib.security.dto.model.UserDTO;
import com.pos.shohaib.security.service.exception.UserNotFoundException;

import java.util.List;

public interface UserService {
   List<UserDTO> index() throws UserNotFoundException;
   UserDTO show(Long id) throws UserNotFoundException;
   String store(UserDTO userDTO) throws UserNotFoundException;
}
