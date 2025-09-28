package com.pos.shohaib.security.dto.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.sql.Date;
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)

public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private String password;
    private String address;
    private String role;
    private String firstName;
    private String lastName;
    private String profileImage;
    private Date createAt;
    private Date updateAt;

}
