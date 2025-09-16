package com.alibou.security.controller;

import com.alibou.security.controller.request.UserStoreAndUpdateRequest;
import com.alibou.security.dto.model.UserDTO;
import com.alibou.security.service.User.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Validated
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/user-registrar")
    public Response<Object> registrar(@RequestBody @Valid UserStoreAndUpdateRequest userStoreAndUpdateRequest){
        try{
            UserDTO userDTO = new UserDTO()
                    .setName(this.)
        }
    }


}
