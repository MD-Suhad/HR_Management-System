package com.pos.shohaib.security.controller;

import com.pos.shohaib.security.controller.request.UserStoreAndUpdateRequest;
import com.pos.shohaib.security.dto.model.UserDTO;
import com.pos.shohaib.security.service.User.UserService;
import com.pos.shohaib.security.service.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Validated
@RequestMapping("/api/v1/auth")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/user-registrar")
    public ResponseEntity<Object> registrar(@RequestBody @Valid UserStoreAndUpdateRequest userStoreAndUpdateRequest){
        try{
            UserDTO userDTO = new UserDTO()
                    .setName(userStoreAndUpdateRequest.getName())
                    .setPassword(userStoreAndUpdateRequest.getPassword())
                    .setFirstName(userStoreAndUpdateRequest.getFirstName())
                    .setLastName(userStoreAndUpdateRequest.getLastName())
                    .setPhoneNumber(userStoreAndUpdateRequest.getPhoneNumber())
                    .setAddress(userStoreAndUpdateRequest.getAddress());
            return ResponseEntity.ok(this.userService.store(userDTO));
        }catch (UserNotFoundException e){
            return ResponseEntity.badRequest().body("error show");
        }
    }


}
