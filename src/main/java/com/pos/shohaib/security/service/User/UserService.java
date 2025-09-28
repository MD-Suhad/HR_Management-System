package com.pos.shohaib.security.service.User;

import com.pos.shohaib.security.domain.model.User;
import com.pos.shohaib.security.dto.model.UserDTO;
import com.pos.shohaib.security.service.exception.UserNotFoundException;
import jdk.jshell.spi.ExecutionControl;

import java.util.List;
import java.util.Optional;

public interface UserService {
   List<UserDTO> index() throws UserNotFoundException;
   Optional<User> getById(Long id) throws ExecutionControl.UserException, UserNotFoundException;
   UserDTO show(Long id) throws UserNotFoundException;
   String store(UserDTO userDTO) throws UserNotFoundException;
}
