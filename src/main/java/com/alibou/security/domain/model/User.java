package com.alibou.security.domain.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

import java.sql.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Accessors(chain = true)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, columnDefinition = "VARCHAR(128)")
    private String firstName;
    @Column(nullable = false, columnDefinition = "VARCHAR(128)")
    private String lastName;
    private String name;
    private String phoneNumber;
    private String password;
    private String role;
    private String address;
    private String profileImage;
    private Date createAt;
    private Date updateAt;

}
