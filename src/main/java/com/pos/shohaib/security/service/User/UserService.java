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
   public Optional<User> getByUsernameAndPassword(String username, String password) throws UserNotFoundException;
   public Optional<User> getByEmail(String email) throws UserNotFoundException;
   public Optional<User> getByEmailAndPassword(String email, String password) throws UserNotFoundException;
   public String delete(Long id) throws UserNotFoundException;
   public String restore(Long id) throws ExecutionControl.UserException;
   public Optional<User> getByIdTrashed(Long id) throws ExecutionControl.UserException;
   public String updatePassword(UserDTO userDTO) throws ExecutionControl.UserException;
   public void verifyEmail(User user);
   public void checkForPasswords(String password, String confirmPassword)
           throws PasswordsDontMatchException;
   public boolean checkForOldPassword(String username, String oldPassword) throws UserNotFoundException;
   UserDTO show(Long id) throws UserNotFoundException;
   String store(UserDTO userDTO) throws UserNotFoundException;
}
