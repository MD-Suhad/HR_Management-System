package com.pos.shohaib.security.service.User;


import com.pos.shohaib.security.domain.model.User;
import com.pos.shohaib.security.domain.repository.UserRepository;
import com.pos.shohaib.security.dto.model.UserDTO;
import com.pos.shohaib.security.service.exception.UserNotFoundException;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
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
    @Override
    public Optional<User> getByUsername(String username) throws UserNotFoundException {

        Optional<User> user = userRepository.findByUsernameAndDeletedFalse(username);
        if (user.isEmpty()) {
            throw new UserNotFoundException(
                    String.format("User with given username: '%s' does not exist", username));
        } else {
            return user;
        }

    }

    @Override
    public Optional<User> getByUsernameAndPassword(String username, String password)
            throws UserNotFoundException {
        Optional<User> user = userRepository.findByUsernameAndPasswordAndDeletedFalse(username, password);
        if (user.isEmpty()) {
            throw new UserNotFoundException(String.format(
                    "User with given username and password: '%s': '%d' does not exist", username,
                    password));
        } else {
            return user;
        }
    }

    @Override
    public Optional<User> getByEmail(String email) throws UserNotFoundException {

        Optional<User> user = userRepository.findByEmail(email);
        if (user.isEmpty()) {
            throw new UserNotFoundException(
                    String.format("User with given email: '%s' does not exist", email));
        } else {
            return user;
        }
    }

    @Override
    public Optional<User> getByEmailAndPassword(String email, String password)
            throws UserNotFoundException {

        Optional<User> user = userRepository.findByUsernameAndPasswordAndDeletedFalse(email, password);
        if (user.isEmpty()) {
            throw new UserNotFoundException(
                    String.format("User with given email and password: '%s': '%d' does not exist",
                            email, password));
        } else {
            return user;
        }
    }


    @Transactional
    @Override
    public String delete(Long id) throws UserNotFoundException {
        Optional<User> user;
        try {
            user = this.getById(id);
            userRepository.deleteById(id);
        } catch (UserNotFoundException e) {
            throw new UserNotFoundException(String.format(
                    "User with given id: '%s' could not be deleted because it does not exist", id));
        }
        return null;

    }

    @Transactional
    @Override
    public String restore(Long id) throws ExecutionControl.UserException {
        Optional<User> user;
        try {
            user = this.getByIdTrashed(id);
            userRepository.restoreById(id);
        } catch (UserException e) {
            throw new UserException(String.format(
                    "User with given id: '%s' could not be restored because it's not soft deleted",
                    id));
        }

        return null;
    }

    @Override
    public Optional<User> getByIdTrashed(Long id) throws UserException {

        Optional<User> user = userRepository.findByIdTrashed(id);
        if (user.isEmpty()) {
            throw new UserException(
                    String.format("Soft deleted user with given id: '%s' does not exist", id));
        } else {
            return user;
        }

    }

    @Override
    public List<User> getAllWithTrashed() {
        return userRepository.findAllWithTrashed();
    }


    @Transactional
    @Override
    public String updatePassword(UserDTO userDTO) throws UserException {
        try {
            User user = this.getByUsername(userDTO.getUsername()).get();
            user.setPassword(userDTO.getPassword());
            userRepository.save(user);
            return "Password has been changed";
        } catch (UserNotFoundException e) {
            throw new UserException(e.getMessage());
        }
    }

    @Transactional
    @Override
    public void verifyEmail(User user) {
        user.setEmailVerified(true);
        userRepository.save(user);

    }

    @Override
    public UserDTO getUserData(String username) throws UserNotFoundException {
        Optional<User> user;
        try {
            user = this.getByUsername(username);
        } catch (UserNotFoundException e) {
            throw new UserNotFoundException(e.getMessage());
        }
        return new UserDTO().setId(user.get().getId()).setUsername(username).setEmail(user.get()
                        .getEmail())
                .setFirstName(user.get().getFirstName()).setLastName(user.get().getLastName())
                .setProfileImage(user.get().getProfileImage())
                .setPhoneNumber(user.get().getPhoneNumber())
                .setAddress(user.get().getAddress());

    }


    @Override
    public void checkForPasswords(String password, String confirmPassword)
            throws PasswordsDontMatchException {
        if (!password.equals(confirmPassword)) {
            throw new PasswordsDontMatchException("Passwords don't match");
        }
    }

    @Override
    public boolean checkForOldPassword(String username, String oldPassword) throws UserNotFoundException, WrongOldPasswordException {
        User user = this.getByUsername(username).get();
        if (this.passwordEncoder.matches(oldPassword, user.getPassword())) {
            return true;
        } else {
            throw new WrongOldPasswordException("Wrong old password");
        }
    }

    @Override
    public void checkTermsAndConditions(String value) throws UserException {
        if (!value.equals("true") && !value.equals("false")) {
            throw new UserException("Illegal value");
        } else if (value.equals("false")) {
            throw new UserException("Terms and Condtions must be accepted in order to register");
        }

    }

    @Override
    public String storeProfileImage(String username, String token, MultipartFile image)
            throws IOException, UserNotFoundException, FileStorageException {
        User user = this.getByUsername(username).get();
        Response<Object> profileImageResponse = this.staticContentServiceFeignClient.addProfileImage(token, image);
        String fileName = (String) profileImageResponse.getPayload();

        if (fileName == null) {
            throw new FileStorageException((String) profileImageResponse.getErrors());
        } else {
            user.setProfileImage("users/" + fileName);
            this.userRepository.save(user);

            return "User photo has been stored";
        }
    }

    @Override
    public String deleteProfileImage(String username, String token) throws UserNotFoundException, ProfileImageNotFoundException {
        User user = this.getByUsername(username).get();
        String oldImage = "";
        if (!user.getProfileImage().equals("users/user-icon.png") || !user.getProfileImage().equals("users/admin-icon.png")) {
            oldImage = user.getProfileImage();
            Response response = this.staticContentServiceFeignClient.deleteProfileImage(token, username, Response.ok().setPayload(oldImage));
            if (response.getPayload() != null) {
                if (authService.isAdmin(user.getUsername())) {
                    user.setProfileImage("users/admin-icon.png");
                } else {
                    user.setProfileImage("users/user-icon.png");
                }
                userRepository.save(user);
                String message = (String) response.getPayload();
                return message;
            } else {
                throw new ProfileImageNotFoundException(response.getErrors().toString());
            }
        } else {
            throw new ProfileImageNotFoundException("You don't have a profile image to delete");
        }
    }

    @Override
    public List<UserDTO> userForResource() {
        List<UserPermission> userPermissions = this.userPermissionRepository.getUserByPermissionId();
        List<UserDTO> userDTOS = new ArrayList<>();
        for (UserPermission userPermission : userPermissions) {
            User user = this.userRepository.findByUserId(userPermission.getUser().getId());
            userDTOS.add(new UserDTO()
                    .setId(user.getId())
                    .setUsername(user.getUsername())
                    .setEmail(user.getEmail())
                    .setFirstName(user.getFirstName())
                    .setLastName(user.getLastName())
                    .setProfileImage(user.getProfileImage())
                    .setPhoneNumber(user.getPhoneNumber())
                    .setAddress(user.getAddress()));
        }
        return userDTOS;
    }

    @Override
    public List<AuthUserDTO> getUserByPermissionOnlyAdministration() throws PermissionNotFoundException {
        List<UserPermission> userPermissions = this.userPermissionRepository.getUserByPermissionOnlyAdministration();
        List<AuthUserDTO> authUserDTOS = new ArrayList<>();
        for (UserPermission userPermission : userPermissions) {
            User user = this.userRepository.findByUserId(userPermission.getUser().getId());
            Permission permission = this.permissionRepository.findById(userPermission.getPermission().getId()).orElseThrow(() -> new PermissionNotFoundException(String.format("Permission with id: %s could not found", userPermission.getPermission().getId())));
            authUserDTOS.add(
                    new AuthUserDTO()
                            .setId(user.getId())
                            .setFirstName(user.getFirstName())
                            .setLastName(user.getLastName())
                            .setUsername(user.getUsername())
                            .setEmail(user.getEmail())
                            .setPhoneNumber(user.getPhoneNumber())
                            .setPermission(permission.getTitle())
            );
        }
        return authUserDTOS;
    }

    @Override
    public List<UserDTO> AllTeacher() {
        List<UserPermission> userPermissions = this.userPermissionRepository.getAllTeacherByPermissionId();
        List<UserDTO> userDTOS = new ArrayList<>();
        for (UserPermission userPermission : userPermissions) {
            User user = this.userRepository.findByUserId(userPermission.getUser().getId());
            userDTOS.add(new UserDTO()
                    .setId(user.getId())
                    .setUsername(user.getUsername())
                    .setEmail(user.getEmail())
                    .setFirstName(user.getFirstName())
                    .setLastName(user.getLastName())
                    .setProfileImage(user.getProfileImage())
                    .setPhoneNumber(user.getPhoneNumber())
                    .setAddress(user.getAddress()));
        }
        return userDTOS;
    }
}
