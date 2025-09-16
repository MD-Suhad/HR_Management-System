package com.alibou.security.controller.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserStoreAndUpdateRequest {
    private String password;
    private String confirmPassword;

    @NotEmpty(message = "Email is required")
    @Email(message = "Email must be valid")
    private String email;

    @Size(min = 3, message = "First name must be at least 3 characters long")
    @Size(max = 64, message = "First name can not be longer than 64 characters")
    @NotEmpty(message = "First name is required")
    private String firstName;

    @Size(min = 3, message = "Last name must be at least 3 characters long")
    @Size(max = 64, message = "Last name can not be longer than 64 characters")
    @NotEmpty(message = "Last name is required")
    private String lastName;

    @NotEmpty(message = "Phone Number is required")
    private String phoneNumber;

    @NotEmpty(message = "Address is required")
    private String address;

    @NotEmpty(message = "Accepting Terms and Conditions is required")
    @Size(min = 4, max = 5, message = "Value must be either true or false")
    private String acceptTerms;

}
